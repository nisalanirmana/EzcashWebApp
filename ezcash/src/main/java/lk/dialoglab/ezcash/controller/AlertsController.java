package lk.dialoglab.ezcash.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.dto.Period;
import lk.dialoglab.ezcash.service.AlertService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
      // System.out.println("Session ID Alerts "+session.getAttribute("MenuTab"));
        logger.info("returning the model");
        return model;

    }
    
    @RequestMapping("/removeAlert/{alertId}")
    public String removeAlert(@PathVariable("alertId") int id,HttpServletRequest request) {
        Alerts alert =new Alerts();
        alert = alertService.findalertbyid(id);
        alertService.deletealertbyid(alert);
        HttpSession session = request.getSession();
        String menuSessionAttrib=session.getAttribute("MenuTab").toString();
        String submenuSessionAttrib=session.getAttribute("AtmTab").toString();
        if(menuSessionAttrib.equals("alerts")){
            return "redirect:/alerts";
        }
        else
        return "redirect:/"+submenuSessionAttrib;
    }
    
    @RequestMapping(value = "/getdatesalerts", method = RequestMethod.POST)
    public ModelAndView getalertsdates(Period period, BindingResult result) throws ParseException {

        System.out.println("-------------------------------------------------------------------------------Start Date:"
                + period.getFromDate() + "End Date:" + period.getToDate() + period.getAtmName());

        logger.info("Get Dates");

        List<Alerts> alerts = getFilteredAlerts(period.getFromDate(), period.getToDate());
        ModelAndView model = new ModelAndView("alerts");
        model.addObject("alerts", alerts);
        //model.addObject("reloads", transactions);

        return model;

    }

    private List<Alerts> getFilteredAlerts(String fromDate, String toDate) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd-MM-yy hh:mm");

        Date date1 = formatter.parse(fromDate);
        Date date2 = formatter.parse(toDate);
        List<Alerts> alerts = alertService.getFilteredAlerts(date1, date2);
        logger.info("****************************************************************888");
        for (Alerts t : alerts) {

          //  logger.info("Amount" + t.getAmount());
            // logger.info("ATM Location"+t.get);

        }
        return alerts;

    }   

}