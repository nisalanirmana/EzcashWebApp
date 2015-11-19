package lk.dialoglab.ezcash.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.AtmLocation;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.dto.AtmLocationDto;
import lk.dialoglab.ezcash.dto.AtmLocationEditList;
import lk.dialoglab.ezcash.dto.OperatorDto;
import lk.dialoglab.ezcash.dto.OperatorEditList;
import lk.dialoglab.ezcash.dto.ReloadDto;
import lk.dialoglab.ezcash.dto.WebUserDto;
import lk.dialoglab.ezcash.service.AlertService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lk.dialoglab.ezcash.service.OperatorService;

/**
 * Handles requests for the application about page.
 */

@Controller
public class OperatorsController {
    @Autowired
    private OperatorService operatorService;

    private static final Logger logger = LoggerFactory.getLogger(OperatorsController.class);

    @RequestMapping(value = "/operators", method = RequestMethod.GET)
    public ModelAndView showOperators(HttpServletRequest request) {

        logger.info("operators page !");

        List<Operator> operators = operatorService.getOperators();
        /*
         * for(Operator o:operators)
         * {
         * 
         * System.out.println(o.getOperatorName());
         * System.out.println(o.getEmail());
         * System.out.println(o.getOperatorPin());
         * System.out.println(o.getPhoneNumber());
         * System.out.println(o.getAssignedAtms().toString());
         * 
         * }
         */
        // ModelAndView model = new ModelAndView("operators");
        // model.addObject("operators", operators);

        HttpSession session = request.getSession();
        session.setAttribute("MenuTab", "operators");
        String taskvariableOperator = OperatorEditList.getTaskvariable();
        String taskvariableshowOperator = OperatorEditList.getTaskvariableshow();
        request.setAttribute("taskOperator", taskvariableOperator);
        request.setAttribute("taskshowOperator", taskvariableshowOperator);
        logger.info("returning the model");

        List<Operator> operatoreditlist = new ArrayList<Operator>();
        operatoreditlist = OperatorEditList.getOperator();

        Map<String, Object> model = new HashMap<String, Object>();

        model.put("operators", operators);
        model.put("operatorAttribute", operatoreditlist);

        return new ModelAndView("operators", model);
    }

    @RequestMapping(value = "/addOperator", method = RequestMethod.POST)
    public String addOperator(OperatorDto operator, BindingResult result) {

        // System.out.println("Atm Name:" + atm.getAtmName()+ "Location:"
        // + atm.getAtmLocation());
        logger.info("Add Operator");
        /*
         * System.out.println(operator.getOperatorName());
         * System.out.println(operator.getOperatorType());
         * System.out.println(operator.getOperatorPin());
         * System.out.println(operator.getEmail());
         * System.out.println(operator.getOperatorType());
         * System.out.println(operator.getPhoneNumber());
         * System.out.println(operator.getOperatorId());
         */
        operatorService.addOperator(operator);
        return "redirect:/operators";

    }

    @RequestMapping("/removeoperator/{id}")
    public String removePerson(@PathVariable("id") int id) {
        Operator operator = null;
        operator = operatorService.findoperatorbyid(id);
        operatorService.deleteoperatorbyid(operator);
        return "redirect:/operators";
    }

    @RequestMapping(value = "/editOperator/{operatorId}", method = RequestMethod.GET)
    // This Retrives the Data
    public String updateOperator(@PathVariable("operatorId") Integer id) {
        // atmlocation = atmService.findatmLocationbyid(id);
        System.out.println("ID " + id);
        Operator operator = new Operator();
        operator = operatorService.findoperatorbyid(id);
        System.out.println("atmlocation" + operator.getOperatorName() + operator.getOperatorId());
        List<Operator> operatorlist = new ArrayList<Operator>();
        operatorlist.add(operator);
        OperatorEditList.setOperator(operatorlist);
        OperatorEditList.setTaskvariable("editOperator");
        OperatorEditList.setTaskvariableshow("Save");
        // Map<String, Object> model = new HashMap<String, Object>();

        // model.put("atmAttribute",atmlocationlist);

        // System.out.println("get 0 "+atmlocationlist.get(0).getLocationName());

        return "redirect:/operators";
    }

    @RequestMapping(value = "/editOperator", method = RequestMethod.POST)
    // this is only modify code
    // @RequestMapping(params = "editAtmLocation", method = RequestMethod.POST)
    public String editOperator(OperatorDto operator, BindingResult result) {
        // System.out.println("Atm Name:" + atm.getAtmName()+ "Location:"
        // + atm.getAtmLocation());
        logger.info("Edit Atm Location");
        operatorService.updateOperatorbyid(operator);
        OperatorEditList.clearOperator();
        System.out.println("Cleared operator");
        OperatorEditList.setTaskvariable("addOperator");
        OperatorEditList.setTaskvariableshow("Add New");
        return "redirect:/operators";

    }

}