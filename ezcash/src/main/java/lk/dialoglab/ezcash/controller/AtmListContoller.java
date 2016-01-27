package lk.dialoglab.ezcash.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lk.dialoglab.ezcash.domain.AssignedAtm;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmLocation;
import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.dto.AssignedAtmDto;
import lk.dialoglab.ezcash.dto.AtmDto;
import lk.dialoglab.ezcash.dto.AtmEditList;
import lk.dialoglab.ezcash.dto.AtmLocationDto;
import lk.dialoglab.ezcash.dto.AtmLocationEditList;
import lk.dialoglab.ezcash.dto.Login;
import lk.dialoglab.ezcash.service.AtmService;
import lk.dialoglab.ezcash.service.ReloadService;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AtmListContoller {

    @Autowired
    private AtmService atmService;

    @Autowired
    private ReloadService reloadService;

    private static final Logger logger = LoggerFactory.getLogger(AtmController.class);

    @RequestMapping(value = "/atmList")
    public ModelAndView AtmList(HttpServletRequest request) {
        logger.info("System Overview Page!");

        List<Atm> atmlist = getSystemTable();
        List<AtmLocation> atmlocationdropdownlistAtmLocations = atmService.getAtmLocationDropDownList();
        List<AtmLocation> atmlocationlist = atmService.getAtmLocationList();
        List<AssignedAtm> atmassignedoperatorlist = atmService.getAtmAssignedOperatorList();
        List<Atm> atmdropdownlist = reloadService.getAtmDropDownList();
        List<Operator> operatordropdownlist = reloadService.getOperatorDropDownList();
        String[] atmdrpdwn = atmdropdownlist.toArray(new String[] {});
        String[] opdrpdwn = operatordropdownlist.toArray(new String[] {});
        String[] atmlocationdrpdwn = atmlocationdropdownlistAtmLocations.toArray(new String[] {});

        for (Atm a : atmlist) {

            logger.info("ATM Name" + a.getAtmName());
            logger.info("ATM Location" + a.getAtmLocation().getLocationName());
            logger.info("ATM Status" + a.getStatus());

        }
        /*
         * for(AtmLocation d:atmlocationdropdownlistAtmLocations)
         * {
         * 
         * System.out.println(d.getLocationName());
         * 
         * }
         */
        logger.info("Creating Model and View for System Page");
        // ModelAndView model = new ModelAndView("atm");
        // model.addObject("atmlist1", atmlist);

        HttpSession session = request.getSession();
        session.setAttribute("MenuTab", "atm");
        session.setAttribute("AtmTab", "");
        // session.setAttribute("task", "editAtmLocation");
        String taskvariableAtmLocation = AtmLocationEditList.getTaskvariable();
        String taskvariableshowAtmLocation = AtmLocationEditList.getTaskvariableshow();
        request.setAttribute("taskAtmLocation", taskvariableAtmLocation);
        request.setAttribute("taskshowAtmLocation", taskvariableshowAtmLocation);

        String taskvariableAtm = AtmEditList.getTaskvariable();
        String taskvariableshowAtm = AtmEditList.getTaskvariableshow();
        System.out.println("Task Variable" + taskvariableAtmLocation);
        request.setAttribute("taskAtm", taskvariableAtm);
        request.setAttribute("taskshowAtm", taskvariableshowAtm);
        // request.getRequestDispatcher("page.jsp").forward(request, response);
        logger.info("AtmListController Model");
        // return model;
        /*
         * 
         * AtmLocation atmlocation = new AtmLocation();
         * atmlocation=atmService.findatmLocationbyid(10);
         * System.out.println("atmlocation"+atmlocation.getLocationName()+atmlocation.getLocationId());
         */
        List<AtmLocation> atmlocationeditlist = new ArrayList<AtmLocation>();
        atmlocationeditlist = AtmLocationEditList.getAtmlocation();
        

        List<Atm> atmeditlist = new ArrayList<Atm>();
        atmeditlist = AtmEditList.getAtm();
     
        // Map<String, Object> model = new HashMap<String, Object>();

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("atmlist1", atmlist);
        model.put("atm", atmlist);
        model.put("atmlocationlist", atmlocationlist);
        model.put("atmlocationdrpdwnlist", atmlocationdrpdwn);
        model.put("atmLocationAttribute", atmlocationeditlist);
        model.put("atmAttribute", atmeditlist);
        model.put("atmassignoplist", atmassignedoperatorlist);
        model.put("atmdrpdwnlist", atmdrpdwn);
        model.put("operatordrpdwnlist", opdrpdwn);

        // model.put("userdetails", userdetails);
        // and so on
        return new ModelAndView("addatm", model);

    }

    private List<Atm> getSystemTable() {
        List<Atm> atmlist = atmService.getAtmList();
        logger.info("****************************************************************888");

        return atmlist;

    }

    @RequestMapping(value = "/addAtm", method = RequestMethod.POST)
    public String addAtm(AtmDto atm, BindingResult result) {

        // System.out.println("Atm Name:" + atm.getAtmName()+ "Location:"
        // + atm.getAtmLocation());
        logger.info("Add Reload");
        System.out.println(atm.getAtmName());
        System.out.println(atm.getAtmLocation());
        System.out.println(atm.getSerialNo());
        System.out.println(atm.getTray1());
        System.out.println(atm.getTray2());
        System.out.println(atm.getAtmcode());
        System.out.println(atm.getTray1NoteValue());
        System.out.println(atm.getTray2NoteValue());
        atmService.addAtm(atm);
        return "redirect:/atmList";

    }

    @RequestMapping("/removeatm/{atmid}")
    public String removePerson(@PathVariable("atmid") int id) {
        Atm atm = null;
        atm = atmService.findatmbyid(id);
        atmService.deleteatmbyid(atm);
        return "redirect:/atmList";
    }

    @RequestMapping(value = "/editAtm/{atmid}", method = RequestMethod.GET)
    // This Retrives the Data
    public String updateAtm(@PathVariable("atmid") Integer id) {
        // atmlocation = atmService.findatmLocationbyid(id);
        System.out.println("ID " + id);
        Atm atm = new Atm();
        atm = atmService.findatmbyid(id);
        System.out.println("atm" + atm.getAtmName() + atm.getAtmId());
        List<Atm> atmlist = new ArrayList<Atm>();
        atmlist.add(atm);
        AtmEditList.setAtm(atmlist);
        AtmEditList.setTaskvariable("editAtm");
        AtmEditList.setTaskvariableshow("Save");
        // Map<String, Object> model = new HashMap<String, Object>();

        // model.put("atmAttribute",atmlocationlist);

        // System.out.println("get 0 "+atmlocationlist.get(0).getLocationName());

        return "redirect:/atmList";
    }

    @RequestMapping(value = "/editAtm", method = RequestMethod.POST)
    // this is only modify code
    // @RequestMapping(params = "editAtmLocation", method = RequestMethod.POST)
    public String editAtm(AtmDto atmdto, BindingResult result) {

        // System.out.println("Atm Name:" + atm.getAtmName()+ "Location:"
        // + atm.getAtmLocation());
        logger.info("Edit Atm Location");
        atmdto.setInstalledDate(atmService.findatmbyid(atmdto.getAtmId()).getInstalledDate());
        atmdto.setLivePktTime(atmService.findatmbyid(atmdto.getAtmId()).getLivePktTime());
        atmdto.setBatLevel(atmService.findatmbyid(atmdto.getAtmId()).getbatLevel());
        atmdto.setReject1(atmService.findatmbyid(atmdto.getAtmId()).getReject1());
        atmdto.setReject2(atmService.findatmbyid(atmdto.getAtmId()).getReject2());
        atmdto.setStatus(atmService.findatmbyid(atmdto.getAtmId()).getStatus());
        atmService.updateatmbyid(atmdto);
        AtmEditList.clearAtm();
        AtmEditList.setTaskvariable("addAtm");
        AtmEditList.setTaskvariableshow("Add New");
        return "redirect:/atmList";

    }

    @RequestMapping("/removeatmlocation/{locationId}")
    public String removeLocation(@PathVariable("locationId") int id) {
        AtmLocation atmlocation = null;
        atmlocation = atmService.findatmLocationbyid(id);
        atmService.deleteatmLocationbyid(atmlocation);
        return "redirect:/atmList";
    }

    @RequestMapping(value = "/editAtmLocation/{locationId}", method = RequestMethod.GET)
    // This Retrives the Data
    public String updateLocation(@PathVariable("locationId") Integer id) {
        // atmlocation = atmService.findatmLocationbyid(id);
        System.out.println("ID " + id);
        AtmLocation atmlocation = new AtmLocation();
        atmlocation = atmService.findatmLocationbyid(id);
        System.out.println("atmlocation" + atmlocation.getLocationName() + atmlocation.getLocationId());
        List<AtmLocation> atmlocationlist = new ArrayList<AtmLocation>();
        atmlocationlist.add(atmlocation);
        AtmLocationEditList.setAtmlocation(atmlocationlist);
        AtmLocationEditList.setTaskvariable("editAtmLocation");
        AtmLocationEditList.setTaskvariableshow("Save");
        // Map<String, Object> model = new HashMap<String, Object>();

        // model.put("atmAttribute",atmlocationlist);

        // System.out.println("get 0 "+atmlocationlist.get(0).getLocationName());

        return "redirect:/atmList";
    }

    @RequestMapping(value = "/editAtmLocation", method = RequestMethod.POST)
    // this is only modify code
    // @RequestMapping(params = "editAtmLocation", method = RequestMethod.POST)
    public String editAtmLocation(AtmLocationDto atmlocation, BindingResult result) {

        // System.out.println("Atm Name:" + atm.getAtmName()+ "Location:"
        // + atm.getAtmLocation());
        logger.info("Edit Atm Location");
        atmService.updateatmLocationbyid(atmlocation);
        AtmLocationEditList.clearAtmLocation();
        AtmLocationEditList.setTaskvariable("addAtmLocation");
        AtmLocationEditList.setTaskvariableshow("Add New");
        return "redirect:/atmList";

    }

    @RequestMapping(value = "/addAtmLocation", method = RequestMethod.POST)
    // @RequestMapping(params = "addAtmLocation", method = RequestMethod.POST)
    public String addAtmLocation(AtmLocationDto atmlocation, BindingResult result) {

        // System.out.println("Atm Name:" + atm.getAtmName()+ "Location:"
        // + atm.getAtmLocation());
        logger.info("Add Atm Location");
        System.out.println(atmlocation.getLocationName());
        atmService.addAtmLocation(atmlocation);
        return "redirect:/atmList";

    }

    @RequestMapping(value = "/assignAtmOperator", method = RequestMethod.POST)
    // @RequestMapping(params = "addAtmLocation", method = RequestMethod.POST)
    public String AssignedAtmOperator(AssignedAtmDto assignedAtmDto, BindingResult result) {

        // System.out.println("Atm Name:" + atm.getAtmName()+ "Location:"
        // + atm.getAtmLocation());
        logger.info("Add Atm Location");
        System.out.println(assignedAtmDto.getAtmId());
        atmService.addAssignedAtmOperator(assignedAtmDto);
        return "redirect:/atmList";

    }

    @RequestMapping("/removeAssignedAtmOperator/{assignId}")
    public String AssignedAtmOperator(@PathVariable("assignId") int id) {
        AssignedAtm assignedatm = null;
        assignedatm = atmService.findassignedatmoperatorbyid(id);
        atmService.deleteassignedatmoperatorbyid(assignedatm);
        return "redirect:/atmList";
    }

}
