 package lk.dialoglab.ezcash.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.dto.Login;
import lk.dialoglab.ezcash.dto.Period;
import lk.dialoglab.ezcash.service.TransactionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
     
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);
     
    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    public ModelMap showSystemForm(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("MenuTab", "transaction");
        logger.info("transaction page !");
        
        List<Transactions> transaction=	getTransactions();
       List<Transactions> reload =		getReloads();
       ModelMap model = new ModelMap();
       
       // ModelAndView model = new ModelAndView("transaction");
   	//model.addObject("transactions",transactions);
   	//model.addObject("transactions", reloads);
      model.put("transactions", transaction);
       model.put("reloads", reload);
      //  model.a("transactions", transactions);
       //model.addAttribute("two", 2);
         
      return model;
    }
    
    
    @RequestMapping(value = "/getdates", method = RequestMethod.POST)
   	public ModelAndView getdates(Period period,  BindingResult result
   		) throws ParseException {

   		System.out.println("-------------------------------------------------------------------------------Start Date:" + period.getFromDate() + "End Date:"
   		+ period.getToDate()+period.getAtmName());

   		logger.info("Get Dates");
   		
   		
   	  List<Transactions> transactions=getFilteredTrans(period.getFromDate(),period.getToDate());
   	 ModelAndView model = new ModelAndView("transaction");
    	model.addObject("transactions", transactions);
          
       return model;	
   		
   		

   	 
   	 
   
   }
    
    
    private List<Transactions> getFilteredTrans(String fromDate,String toDate) throws ParseException
    {	
    
    
   
	
	
	DateFormat formatter = new SimpleDateFormat("dd-MM-yy hh:mm");

	Date date1 = formatter.parse(fromDate);
	Date date2 = formatter.parse(toDate);
	List<Transactions> transactions=	transactionService.getFilteredTrans(date1,date2);
	logger.info("****************************************************************888");
	for (Transactions t:transactions)
	{
		
		logger.info("Amount"+t.getAmount());
	//	logger.info("ATM Location"+t.get);
		
	
	}
	return transactions;
    	
    	
    }
    
    
    
  
   
    
    
    private List<Transactions> getTransactions()
    {List<Transactions> transactions=	transactionService.getTransactions();
   /* 	
	logger.info("****************************************************************888");
	for (Transactions t:transactions)
	{
		
	logger.info("Date"+t.getCashOut().getCashOutDate());
		logger.info("Amount"+t.getAmount());
		
	
	}*/
	return transactions;
    	
    	
    }
    
    private List<Transactions> getReloads()
    {List<Transactions> reloads=	transactionService.getReloads();
   /* 	
	logger.info("****************************************************************888");
	for (Transactions t:transactions)
	{
		
	logger.info("Date"+t.getCashOut().getCashOutDate());
		logger.info("Amount"+t.getAmount());
		
	
	}*/
	return reloads;
    	
    	
    }
     
}