package lk.dialoglab.ezcash.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.service.AlertService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application about page.
 */
@Controller
public class AlertsController {

    private static final Logger logger = LoggerFactory.getLogger(AlertsController.class);

    @Autowired
    private AlertService alertService;

    @RequestMapping(value = "/alerts", method = RequestMethod.GET)
    public ModelAndView showSystemForm(HttpServletRequest request) {

        logger.info("alerts page !");

        List<Alerts> alerts = alertService.getAlerts();

        for (Alerts a : alerts) {
            System.out.println(a.getSolvedTime());
            System.out.println(a.getTriggeredTime());
            System.out.println(a.getAlertType().getAlertName());
            System.out.println(a.getAtm().getAtmName());

        }

        ModelAndView model = new ModelAndView("alerts");
        model.addObject("alerts", alerts);
        HttpSession session = request.getSession();
        session.setAttribute("MenuTab", "alerts");
        logger.info("returning the model");
        return model;

    }
    
    @RequestMapping("/removeAlert/{alertId}")
    public String removeAlert(@PathVariable("alertId") int id) {
        Alerts alert =new Alerts();
        alert = alertService.findalertbyid(id);
        alertService.deletealertbyid(alert);
        return "redirect:/alerts";
    }

}