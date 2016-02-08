package lk.dialoglab.ezcash.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lk.dialoglab.ezcash.domain.Alerts;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.CashOut;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.dto.Login;
import lk.dialoglab.ezcash.dto.Period;
import lk.dialoglab.ezcash.dto.TransAll;
import lk.dialoglab.ezcash.service.ReloadService;
import lk.dialoglab.ezcash.service.TransactionService;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.hibernate.Query;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @Autowired
    private ReloadService reloadService;

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public ModelMap Transaction(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("MenuTab", "transaction");
        System.out.println("Session ID Transaction "+session.getId());
        logger.info("transaction page !");
        List<Atm> atmdropdownlist = reloadService.getAtmDropDownList();
        String[] atmdrpdwn = atmdropdownlist.toArray(new String[] {});
       // List<CashOut> cashouts = getTransactionsCompletedfull();
        List<CashOut> cashouts = getCashOuts();
        List<Transactions> transactions = getTransactionsCompleted();
        for (Transactions t : transactions) {

            logger.info("Amount" + t.getAmount());
             logger.info("ATM Location"+t.getTray1());

        }
        //List<Transactions> reload = getReloads();
        ModelMap model = new ModelMap();
   
        // ModelAndView model = new ModelAndView("transaction");
        // model.addObject("transactions",transactions);
        // model.addObject("transactions", reloads);
       model.put("cashouts", cashouts);
        model.put("TransactionsComp", transactions);
        model.put("atmdrpdwnlist", atmdrpdwn);
        //model.put("reloads", reload);
        // model.a("transactions", transactions);
        // model.addAttribute("two", 2);

        return model;
    }
    
    @RequestMapping(value = "/reload", method = RequestMethod.GET)
    public ModelMap Reload(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("MenuTab", "reload");
        System.out.println("Session ID Transaction "+session.getId());
        logger.info("reload page !");
        List<Atm> atmdropdownlist = reloadService.getAtmDropDownList();
        String[] atmdrpdwn = atmdropdownlist.toArray(new String[] {});
        //List<CashOut> cashouts = getCashOuts();
        List<Transactions> reload = getReloads();
        ModelMap model = new ModelMap();

        // ModelAndView model = new ModelAndView("transaction");
        // model.addObject("transactions",transactions);
        // model.addObject("transactions", reloads);
       // model.put("cashouts", cashouts);
        model.put("reloads", reload);
        model.put("atmdrpdwnlist", atmdrpdwn);
        // model.a("transactions", transactions);
        // model.addAttribute("two", 2);

        return model;
    }

    @RequestMapping(value = "/getdatescashout", method = RequestMethod.POST)
    public ModelAndView getdatescashout(Period period, BindingResult result) throws ParseException {

        List<Atm> atmdropdownlist = reloadService.getAtmDropDownList();
        String[] atmdrpdwn = atmdropdownlist.toArray(new String[] {});
        System.out.println("-------------------------------------------------------------------------------Start Date:"
                + period.getFromDate() + "End Date:" + period.getToDate() + period.getAtmName());

        logger.info("Get Dates");
if(period.getAtmName().isEmpty()){
    List<CashOut> cashouts = getFilteredCashOuts(period.getFromDate(), period.getToDate());
    List<Transactions> transactions = getFilteredTransactions(period.getFromDate(), period.getToDate());
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("cashouts", cashouts);
    model.put("TransactionsComp", transactions);
    model.put("atmdrpdwnlist", atmdrpdwn);
    return new ModelAndView("transaction", model);
}else{
    List<CashOut> cashouts = getFilteredCashOutbyAtm(period.getFromDate(), period.getToDate(),period.getAtmName());
    List<Transactions> transactions = getFilteredTransactionsbyAtm(period.getFromDate(), period.getToDate(),period.getAtmName());
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("cashouts", cashouts);
        model.put("TransactionsComp", transactions);
        model.put("atmdrpdwnlist", atmdrpdwn);
        return new ModelAndView("transaction", model);
}
    }
    
 
    
    private List<CashOut> getFilteredCashOutbyAtm(String fromDate, String toDate,String atmName) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd-MM-yy hh:mm");

        Date date1 = formatter.parse(fromDate);
        Date date2 = formatter.parse(toDate);
        List<CashOut> cashouts = transactionService.getFilteredCashOutsbyAtm(date1, date2,atmName);
        logger.info("****************************************************************888");
      /*  for (Alerts t : alerts) {

          //  logger.info("Amount" + t.getAmount());
            // logger.info("ATM Location"+t.get);

        }*/
        return cashouts;

    } 
    
    private List<Transactions> getFilteredTransactionsbyAtm(String fromDate, String toDate,String atmName) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd-MM-yy hh:mm");

        Date date1 = formatter.parse(fromDate);
        Date date2 = formatter.parse(toDate);
        List<Transactions> transactions = transactionService.getFilteredTransactionsbyAtm(date1, date2,atmName);
        logger.info("****************************************************************888");
      /*  for (Alerts t : alerts) {

          //  logger.info("Amount" + t.getAmount());
            // logger.info("ATM Location"+t.get);

        }*/
        return transactions;

    }
    
    @RequestMapping(value = "/getdatesreload", method = RequestMethod.POST)
    public ModelAndView getdatesreload(Period period, BindingResult result) throws ParseException {

        List<Atm> atmdropdownlist = reloadService.getAtmDropDownList();
        String[] atmdrpdwn = atmdropdownlist.toArray(new String[] {});
        
if(period.getAtmName().isEmpty()){
    List<Transactions> reloads = getFilteredReloads(period.getFromDate(), period.getToDate());
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("reloads", reloads);
    model.put("atmdrpdwnlist", atmdrpdwn);
    return new ModelAndView("reload", model);
}else{
    List<Transactions> reloadsfilter = getFilteredReloadsbyAtm(period.getFromDate(), period.getToDate(),period.getAtmName());
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("reloads", reloadsfilter);
        model.put("atmdrpdwnlist", atmdrpdwn);
        return new ModelAndView("reload", model);
        
}
    }

    private List<CashOut> getFilteredCashOuts(String fromDate, String toDate) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd-MM-yy hh:mm");

        Date date1 = formatter.parse(fromDate);
        Date date2 = formatter.parse(toDate);
        List<CashOut> cashouts = transactionService.getFilteredCashOuts(date1, date2);
        /*
        logger.info("****************************************************************888");
        for (Transactions t : transactions) {

            logger.info("Amount" + t.getAmount());
            // logger.info("ATM Location"+t.get);

        }
        */
        return cashouts;

    }
    
    private List<Transactions> getFilteredTransactions(String fromDate, String toDate) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd-MM-yy hh:mm");

        Date date1 = formatter.parse(fromDate);
        Date date2 = formatter.parse(toDate);
        List<Transactions> transactions = transactionService.getFilteredTransactions(date1, date2);
        /*
        logger.info("****************************************************************888");
        for (Transactions t : transactions) {

            logger.info("Amount" + t.getAmount());
            // logger.info("ATM Location"+t.get);

        }
        */
        return transactions;

    }
    
    private List<Transactions> getFilteredReloads(String fromDate, String toDate) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd-MM-yy hh:mm");

        Date date1 = formatter.parse(fromDate);
        Date date2 = formatter.parse(toDate);
        List<Transactions> reloads = transactionService.getFilteredReloads(date1, date2);
        logger.info("****************************************************************888");
  /*      for (Transactions t : reloads) {

            logger.info("Amount" + t.getAtmReload().getReloadEndTime());
            // logger.info("ATM Location"+t.get);

        }*/
        return reloads;

    }
    
    private List<Transactions> getFilteredReloadsbyAtm(String fromDate, String toDate,String atmName) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("dd-MM-yy hh:mm");

        Date date1 = formatter.parse(fromDate);
        Date date2 = formatter.parse(toDate);
        List<Transactions> reloads = transactionService.getFilteredReloadsbyAtm(date1, date2,atmName);
        logger.info("****************************************************************888");
  /*      for (Transactions t : reloads) {

            logger.info("Amount" + t.getAtmReload().getReloadEndTime());
            // logger.info("ATM Location"+t.get);

        }*/
        return reloads;

    }

    private List<CashOut> getCashOuts() {
        List<CashOut> cashouts = transactionService.getCashOuts();
        /*
         * logger.info("****************************************************************888");
         * for (Transactions t:transactions)
         * {
         * 
         * logger.info("Date"+t.getCashOut().getCashOutDate());
         * logger.info("Amount"+t.getAmount());
         * 
         * 
         * }
         */
        return cashouts;

    }

    private List<Transactions> getReloads() {
        List<Transactions> reloads = transactionService.getReloads();
        /*
         * logger.info("****************************************************************888");
         * for (Transactions t:transactions)
         * {
         * 
         * logger.info("Date"+t.getCashOut().getCashOutDate());
         * logger.info("Amount"+t.getAmount());
         * 
         * 
         * }
         */
        return reloads;

    }
    
    @RequestMapping("/removeTransaction/{cashOutId}")
    public String removeTransactions(@PathVariable("cashOutId") int id,HttpServletRequest request) {
        CashOut cashout =new CashOut();
        cashout = transactionService.findCashOutbyid(id);
        transactionService.deleteCashOutbyid(cashout);
        HttpSession session = request.getSession();

        String menuSessionAttrib=session.getAttribute("MenuTab").toString();
        String submenuSessionAttrib=session.getAttribute("AtmTab").toString();
        if(menuSessionAttrib.equals("transaction")){
            return "redirect:/transaction";
        }
        else
        return "redirect:/"+submenuSessionAttrib;
       
    }
    
    public List<Transactions> getTransactionsCompleted() {
        List<Transactions> transactions = transactionService.getTransactionsCompleted();
        
          logger.info("****************************************************************888");
         for (Transactions t:transactions)
          {
          
          logger.info("Date"+t.getCashOut().getCashOutDate());
         logger.info("Amount"+t.getAmount());
         logger.info("Tray 1"+t.getTray1());
         
         }
         
     
        return transactions;

    }
    
    /*
    public List<CashOut> getTransactionsCompletedfull() {
        String status = "Cashout Success";
        List<Transactions> transactions = transactionService.getTransactionsCompleted();
        List<CashOut> cashouts = transactionService.getCashOuts();
        HashMap<CashOut,Transactions> hmap = new HashMap<CashOut,Transactions>();
        int i=0;
        
        while(i<cashouts.size()){
            if (cashouts.get(i).getTransactionStatus().getStatusName().equals(status)) {
        hmap.put(transactions.get(i).getCashOut(),transactions.get(i));
            }
        }
        
        
        for (CashOut c : cashouts) {
        
                if (c.getTransactionStatus().getStatusName().equals(status)) {
                    System.out.println(c.getCashOutId()+"aaaaaaaaaaaaaaaaaaa "+c.getTransactionStatus().getStatusName());
                System.out.println("Index " + cashouts.indexOf(c) );
                System.out.println("size1 " + cashouts.size() );
                System.out.println("size2 " + cashouts2.size() );
                cashouts2.remove(cashouts.indexOf(c));
                }
          }
        
        
        return cashouts2;
          
    }
  */
    
  /*  public List<TransAll> getTransactionsCompletedfull() {
        String status = "Cashout Success";
        List<Transactions> transactions = transactionService.getTransactionsCompleted();
        List<CashOut> cashouts = transactionService.getCashOuts();
        List<TransAll> alltrans =new ArrayList<TransAll>();
     
                for( Transactions transaction : transactions){  
                TransAll object = new TransAll();
                 object.setTransactionId(transaction.getTransactionId()); // transaction id eka wage ookkooma transaction fielt tika gahapan
                 object.setAmount(transaction.getAmount());
                 object.setTray1(transaction.getTray1());
                 object.setTray2(transaction.getTray2());
                 object.setReject1(transaction.getReject1());
                 object.setReject2(transaction.getReject2());
                 object.setAtm(transaction.getCashOut().getAtm());  // cash out eke anith ewath mewagema object transAll ekata gahapan
                 object.setTransactionStatus(transaction.getCashOut().getTransactionStatus());
                 object.setCashOutDate(transaction.getCashOut().getCashOutDate());
                 object.setPhoneNumber(transaction.getCashOut().getPhoneNumber());
                 object.setAmount(transaction.getCashOut().getAmount());
                 object.setResponseId(transaction.getCashOut().getResponseId());
                 
                 alltrans.add(object);
                }
                
                for(CashOut cashout:cashouts){
                    if(!(cashout.getTransactionStatus().getStatusName().equals(status))){
                        
                        alltrans.
                    }
                    
                    
                    
                }
                
                
                
                
              return alltrans;
                // for loop is over
     
          
    }
  */
}
