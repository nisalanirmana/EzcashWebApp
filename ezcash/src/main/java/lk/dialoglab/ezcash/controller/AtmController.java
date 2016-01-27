package lk.dialoglab.ezcash.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.AssignedAtm;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmLocation;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.CashOut;
import lk.dialoglab.ezcash.dto.AtmDto;
import lk.dialoglab.ezcash.dto.AtmEditList;
import lk.dialoglab.ezcash.dto.AtmLocationDto;
import lk.dialoglab.ezcash.dto.ReloadDto;
import lk.dialoglab.ezcash.service.AlertService;
import lk.dialoglab.ezcash.service.AtmService;





import lk.dialoglab.ezcash.service.ReloadService;
import lk.dialoglab.ezcash.service.TransactionService;
import lk.dialoglab.ezcash.util.DBInfo;
import lk.dialoglab.ezcash.util.ServerInfo;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application about page.
 */
@Controller
public class AtmController {

    @Autowired
    private AtmService atmService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private ReloadService atmreloadService;
    @Autowired
    private AlertService alertService;

    private static final Logger logger = LoggerFactory.getLogger(AtmController.class);

    @RequestMapping(value = "/{atmName}", method = RequestMethod.GET)
    public ModelAndView Sytem(@PathVariable("atmName") String argument, HttpServletRequest request) {
        logger.info("System Overview Page!");
        System.out.println("Atm Name " + argument);
        List<Atm> atmlist = getSystemTable();
        List<Atm> atmdetails = getAtmDetails(argument);
        Set<AssignedAtm> assignatmlist=atmdetails.get(0).getAssignedAtms();
        List<Alerts> topatmalertlist = getTopAtmAlerts(argument);
        List<CashOut> topatmcashoutlist = getTopAtmCashOuts(argument);
        List<AtmReload> topatmreloadlist = getTopAtmReloads(argument);

        /*
         * for (Alerts a:atmalerts)
         * {
         * logger.info("ATM Name"+a.getTriggeredTime());
         * //logger.info("ATM Location"+a.getAtmLocation().getLocationName());
         * //System.out.println("CAshout "+a.getAssignedAtms().toArray());
         * 
         * }
         */

        logger.info("Creating Model and View for System Page");
        // ModelAndView model = new ModelAndView("atm");

        // ModelMap model = new ModelMap("atm");
        // model.addObject("atmlist1", atmlist);
        // model.put("atmlist1", atmlist);
        HttpSession session = request.getSession();
        session.setAttribute("AtmTab", argument);
     
        
        String disblebtntype=AtmEditList.getDisablebtntype();
        session.setAttribute("Disablebtntype",disblebtntype);
        
        String enablebtntype=AtmEditList.getEnablebtntype();
        session.setAttribute("Enablebtntype",enablebtntype);
        
        String rebootbtntype=AtmEditList.getRebootbtntype();
        session.setAttribute("Rebootbtntype",rebootbtntype);
        
        String unlockbtntype=AtmEditList.getUnlockbtntype();
        session.setAttribute("Unlockbtntype",unlockbtntype);
        
        logger.info("returning the model");

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("atmlist1", atmlist);
        model.put("atm", atmdetails);
        model.put("atmoperators", assignatmlist);
        model.put("atmalerts", topatmalertlist);
       model.put("atmcashouts", topatmcashoutlist);
        model.put("atmreloads", topatmreloadlist);

        // model.put("userdetails", userdetails);
        // and so on
        return new ModelAndView("atm", model);
        // return model;

    }

    
    private List<Atm> getSystemTable() {
        List<Atm> atmlist = atmService.getAtmList();
        logger.info("****************************************************************888");
        return atmlist;

    }

    private List<Atm> getAtmDetails(String atmname) {
        List<Atm> atmlist = atmService.getAtmDetails(atmname);
        setEnableBtnStatus(atmlist);
        setDisableBtnStatus(atmlist);
        setRebootBtnStatus(atmlist);
        setUnlockBtnStatus(atmlist);
        logger.info("****************************************************************888");
        return atmlist;

    }
    
    private List<Alerts> getTopAtmAlerts(String atmname){
        //List<Atm> atmdetails = getAtmDetails(atmname);
        //Set<Alerts> atmalerts=atmdetails.get(0).getAlertses();
        List<Alerts> atmalertslist = alertService.getAlertsbyAtm(atmname);
        Collections.sort(atmalertslist,new Comparator<Alerts>(){ public int compare(Alerts lhs, Alerts rhs){return(rhs.getAlertId().compareTo(lhs.getAlertId()));}});
        if(atmalertslist.size()>11){
        atmalertslist.subList(10,atmalertslist.size()).clear();
        }
        return atmalertslist;
    }
    
    private List<CashOut> getTopAtmCashOuts(String atmname){
     //   List<Atm> atmdetails = getAtmDetails(atmname);
      //  Set<CashOut> atmcashouts=atmdetails.get(0).getCashOuts();
       // List<CashOut> atmcashoutslist = new ArrayList<CashOut>(atmcashouts);
        logger.info("List<CashOut> atmcashoutslist = transactionService.getCashOutbyAtm(atmname);");
        System.out.println("Atm Name: "+atmname);
        List<CashOut> atmcashoutslist = transactionService.getCashOutbyAtm(atmname);
        Collections.sort( atmcashoutslist,new Comparator<CashOut>(){ public int compare(CashOut lhs, CashOut rhs){return(rhs.getCashOutId().compareTo(lhs.getCashOutId()));}});
        if(atmcashoutslist.size()>11){
            atmcashoutslist.subList(10,atmcashoutslist.size()).clear();
        }
        return atmcashoutslist;
    }
    
    private List<AtmReload> getTopAtmReloads(String atmname){
        //List<Atm> atmdetails = getAtmDetails(atmname);
       // Set<AtmReload> atmreloads=atmdetails.get(0).getAtmReloads();
        List<AtmReload> atmreloadslist = atmreloadService.getReloadsbyAtm(atmname);
        Collections.sort( atmreloadslist,new Comparator<AtmReload>(){ public int compare(AtmReload lhs, AtmReload rhs){return(rhs.getReloadId().compareTo(lhs.getReloadId()));}});
        if(atmreloadslist.size()>11){
            atmreloadslist.subList(10,atmreloadslist.size()).clear();
        }
        return atmreloadslist;
    }

    @RequestMapping(value = "/disableatm/{atmName}", method = RequestMethod.GET)
    public String handlePost3(@PathVariable("atmName") String argument, @RequestParam String action, Model m, ServerInfo serverinfo )
            throws IOException {
        String server = serverinfo.getServer();
        String port = serverinfo.getPort();
        String name = serverinfo.getName();
        List<Atm> atmdetails = getAtmDetails(argument);
        String AtmSerialNo = atmdetails.get(0).getSerialNo();
        setDisableBtnStatus(atmdetails);
        
        String sendingString = "##CMD,DISABLE," + AtmSerialNo;
        System.out.println("Sending String:" + sendingString);
        sendmsg(sendingString,"http://"+server+":"+port+"/"+name+"/webMsg/");
        String postData = sendingString;
        URL url = new URL("http://"+server+":"+port+"/"+name+"/webMsg/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/html");

        // Write data
        OutputStream os = connection.getOutputStream();
        os.write(postData.getBytes());

        os.close();
        System.out.println("Sending ");
        atmService.setAtmStatus(argument);
        return "redirect:/" + argument;
    }
    
    @RequestMapping(value = "/enableatm/{atmName}", method = RequestMethod.GET)
    public String handlePost4(@PathVariable("atmName") String argument, @RequestParam String action, Model m, ServerInfo serverinfo )
            throws IOException {
        String server = serverinfo.getServer();
        String port = serverinfo.getPort();
        String name = serverinfo.getName();
        List<Atm> atmdetails = getAtmDetails(argument);
        String AtmSerialNo = atmdetails.get(0).getSerialNo();
        setEnableBtnStatus(atmdetails);
        String sendingString = "##CMD,ENABLE," + AtmSerialNo;
        System.out.println("Sending String:" + sendingString);
        sendmsg(sendingString,"http://"+server+":"+port+"/"+name+"/webMsg/");
        String postData = sendingString;
        URL url = new URL("http://"+server+":"+port+"/"+name+"/webMsg/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/html");

        // Write data
        OutputStream os = connection.getOutputStream();
        os.write(postData.getBytes());

        os.close();
        System.out.println("Sending ");
        return "redirect:/" + argument;
    }
    
    @RequestMapping(value = "/unlockatm/{atmName}", method = RequestMethod.GET)
    public String handlePost1(@PathVariable("atmName") String argument, @RequestParam String action, Model m, ServerInfo serverinfo )
            throws IOException {
        String server = serverinfo.getServer();
        String port = serverinfo.getPort();
        String name = serverinfo.getName();
        System.out.println("Server Server : "+serverinfo.getServer());
        System.out.println("Server Port : "+serverinfo.getPort());
        System.out.println("Server Name : "+serverinfo.getName());
        List<Atm> atmdetails = getAtmDetails(argument);
        String AtmSerialNo = atmdetails.get(0).getSerialNo();
        String sendingString = "##CMD,UNLOCK," + AtmSerialNo;
        System.out.println("Sending String:" + sendingString);
        sendmsg(sendingString,"http://"+server+":"+port+"/"+name+"/webMsg/");
        String postData = sendingString;
        URL url = new URL("http://"+server+":"+port+"/"+name+"/webMsg/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/html");
        
        // Write data
        OutputStream os = connection.getOutputStream();
        os.write(postData.getBytes());

        os.close();
        System.out.println("Sending ");
        return "redirect:/" + argument;
    }

    @RequestMapping(value = "/rebootatm/{atmName}", method = RequestMethod.GET)
    public String handlePost2(@PathVariable("atmName") String argument, @RequestParam String action, Model m,ServerInfo serverinfo )
            throws IOException {
        String server = serverinfo.getServer();
        String port = serverinfo.getPort();
        String name = serverinfo.getName();
        List<Atm> atmdetails = getAtmDetails(argument);
        String AtmSerialNo = atmdetails.get(0).getSerialNo();
        String sendingString = "##CMD,REBOOT," + AtmSerialNo;
        System.out.println("Sending String:" + sendingString);
        sendmsg(sendingString,"http://"+server+":"+port+"/"+name+"/webMsg/");
        String postData = sendingString;
        URL url = new URL("http://"+server+":"+port+"/"+name+"/webMsg/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/html");

        // Write data
        OutputStream os = connection.getOutputStream();
        os.write(postData.getBytes());

        os.close();
        System.out.println("Sending ");
        return "redirect:/" + argument;
    }

    private String sendmsg(String msg, String path) {
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();

        List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
        acceptableMediaTypes.add(MediaType.TEXT_HTML);

        headers.setAccept(acceptableMediaTypes);
        // Pass the new call request and header
        HttpEntity<String> entity = new HttpEntity<String>(msg, headers);

        ResponseEntity<String> result = restTemplate.exchange(path, HttpMethod.POST, entity, String.class);

        return result.getBody();

    }
    
    private void setDisableBtnStatus(List<Atm> atmlist){
        String AtmStatus = atmlist.get(0).getStatus();
        System.out.println("Atm Status from Dis "+ AtmStatus);
        switch(AtmStatus){
        
        case "0": AtmEditList.setDisablebtntype("hidden");
        break;
        case "1": AtmEditList.setDisablebtntype("submit");
        break;
        case "2": AtmEditList.setDisablebtntype("hidden");
        break;
        case "3": AtmEditList.setDisablebtntype("hidden");
        break;
            
        }
        String disblebtntype=AtmEditList.getDisablebtntype();
        System.out.println("Atm Status dis frm dis "+ disblebtntype);
        
        String enablebtntype=AtmEditList.getEnablebtntype();
        System.out.println("Atm Status en frm dis "+ enablebtntype);
    }
    
    private void setEnableBtnStatus(List<Atm> atmlist){
        String AtmStatus = atmlist.get(0).getStatus();
        System.out.println("Atm Status from en "+ AtmStatus);
        switch(AtmStatus){
        
        case "0": AtmEditList.setEnablebtntype("hidden");
        break;
        case "1": AtmEditList.setEnablebtntype("hidden");
        break;
        case "2": AtmEditList.setEnablebtntype("hidden");
        break;
        case "3": AtmEditList.setEnablebtntype("submit");
        break;
            
        }
        
        String disblebtntype=AtmEditList.getDisablebtntype();
        System.out.println("Atm Status dis frm en "+ disblebtntype);
        
        String enablebtntype=AtmEditList.getEnablebtntype();
        System.out.println("Atm Status en frm en "+ enablebtntype);
    }
    
    private void setRebootBtnStatus(List<Atm> atmlist){
        String AtmStatus = atmlist.get(0).getStatus();
        System.out.println("Atm Status from en "+ AtmStatus);
        switch(AtmStatus){
        
        case "0": AtmEditList.setRebootbtntype("hidden");
        break;
        case "1": AtmEditList.setRebootbtntype("submit");
        break;
        case "2": AtmEditList.setRebootbtntype("hidden");
        break;
        case "3": AtmEditList.setRebootbtntype("submit");
        break;
            
        }
        
        String disblebtntype=AtmEditList.getDisablebtntype();
        System.out.println("Atm Status dis frm en "+ disblebtntype);
        
        String enablebtntype=AtmEditList.getEnablebtntype();
        System.out.println("Atm Status en frm en "+ enablebtntype);
    }
    
    private void setUnlockBtnStatus(List<Atm> atmlist){
        String AtmStatus = atmlist.get(0).getStatus();
        System.out.println("Atm Status from en "+ AtmStatus);
        switch(AtmStatus){
        
        case "0": AtmEditList.setUnlockbtntype("hidden");
        break;
        case "1": AtmEditList.setUnlockbtntype("submit");
        break;
        case "2": AtmEditList.setUnlockbtntype("hidden");
        break;
        case "3": AtmEditList.setUnlockbtntype("submit");
        break;
            
        }
        
        String disblebtntype=AtmEditList.getDisablebtntype();
        System.out.println("Atm Status dis frm en "+ disblebtntype);
        
        String enablebtntype=AtmEditList.getEnablebtntype();
        System.out.println("Atm Status en frm en "+ enablebtntype);
    }

}