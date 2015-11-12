package lk.dialoglab.ezcash.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;





















import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lk.dialoglab.ezcash.dao.AtmDAO;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.domain.AtmReload;
import lk.dialoglab.ezcash.domain.Didmap;
import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.domain.Transactions;
import lk.dialoglab.ezcash.dto.DidmapDto;
import lk.dialoglab.ezcash.dto.ReloadDto;
import lk.dialoglab.ezcash.service.DidmapService;
import lk.dialoglab.ezcash.service.ReloadService;
import lk.dialoglab.ezcash.service.TransactionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
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
public class MaintenanceController {
	
	@Autowired
	DidmapService didmapService;
	
	@Autowired
	ReloadService reloadService;
	
	@Autowired
	TransactionService transactionService;

     
	private static final Logger logger = LoggerFactory.getLogger(MaintenanceController.class);
     
    @RequestMapping(value = "/maintenance", method = RequestMethod.GET)
    
    public ModelMap showOperators(HttpServletRequest request) {
        
        logger.info("operators page !");
        
    //List<Didmap> didmap=didmapService.getDidmap();
    List<AtmReload> atmreload=reloadService.getReload();
    List<Atm> atmdropdownlist=reloadService.getAtmDropDownList();
    List<Operator> operatordropdownlist=reloadService.getOperatorDropDownList();
    //Convert Object Array to String Array ----List<AtmM --> List<String>
    String[] atmdrpdwn = atmdropdownlist.toArray(new String[] {});
    String[] opdrpdwn = operatordropdownlist.toArray(new String[] {});
    //System.out.println(Arrays.deepToString(arr));
   // System.out.println(atmdropdownlist);
    //System.out.println(arr);
    
    //Convert Object Array to String Array ----List<AtmM --> List<String>
    
    
    
    ModelMap model = new ModelMap();
   /* 
    for(Atm d:atmdropdownlist)
    {
    	
    	System.out.println(d.getAtmName());
    	
    }
        
     for(Didmap d:didmap)
        {
        	
        	System.out.println(d.getMapno());
        	System.out.println(d.getDid());
        	System.out.println(d.getPhone());
        	System.out.println(d.getName());
        	
        }
    */    
    	//ModelAndView model = new ModelAndView("maintenance");
    	//model.addObject("maintenance", didmap);
    //	model.put("maintenance", didmap);
    	model.put("reloadtasks", atmreload);
    	model.put("atmdrpdwnlist", atmdrpdwn);
    	model.put("operatordrpdwnlist", opdrpdwn);
    	//Navigation  Menu css Change---------------
    	HttpSession session = request.getSession();
        session.setAttribute("MenuTab", "maintenance");
        //-----------------------------------------
        logger.info("maintenance page !");
        return model;
    }


  
 
    	@RequestMapping(value="/unlockatm", method=RequestMethod.GET)
    	public String handlePost1(@RequestParam String action, Model m) throws IOException {
        String sendingString = "##CMD,UNLOCK,ABCDEFGHIJKLMNO";
        sendmsg("##CMD,UNLOCK,B827EB66B1AB","http://203.189.68.250:80/ezcashtest/webMsg/");
        String postData = sendingString;
        URL url = new URL("http://203.189.68.250:80/ezcashtest/webMsg/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "text/html");
    
        // Write data
        OutputStream os = connection.getOutputStream();
        os.write(postData.getBytes());
          

        os.close();
        System.out.println("Sending ");
        return  "redirect:/maintenance";
    }
    	  
    	  @RequestMapping(value="/rebootatm", method=RequestMethod.GET)
  	    public String handlePost2(@RequestParam String action, Model m) throws IOException {
      String sendingString = "##CMD,REBOOT,ABCDEFGHIJKLMNO";
      sendmsg("##CMD,REBOOT,B827EB66B1AB","http://203.189.68.250:80/ezcashtest/webMsg/");
      String postData = sendingString;
      URL url = new URL("http://203.189.68.250:80/ezcashtest/webMsg/");
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setDoOutput(true);
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "text/html");
  
      // Write data
      OutputStream os = connection.getOutputStream();
      os.write(postData.getBytes());
        

      os.close();
      System.out.println("Sending ");
      return  "redirect:/maintenance";
  }
    	  
   private String sendmsg(String msg,String path){
	   HttpHeaders headers = new HttpHeaders();
	   RestTemplate restTemplate = new RestTemplate();

	   List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
	   acceptableMediaTypes.add(MediaType.TEXT_HTML);


    		        headers.setAccept(acceptableMediaTypes);
    		        // Pass the new call request and header
    		        HttpEntity<String> entity = new HttpEntity<String>(msg, headers);

    		        ResponseEntity<String> result =
    		restTemplate.exchange(path, HttpMethod.POST, entity,
    		String.class);

    		        return result.getBody();

    		   
    	  }
    	  
    	 /* 
 		 @RequestMapping(value = "/addDidmap", method = RequestMethod.POST)
 			public String addAtm(DidmapDto didmap,  BindingResult result
 				) {

 			//	System.out.println("Atm Name:" + atm.getAtmName()+ "Location:"
 			//			+ atm.getAtmLocation());

 				logger.info("Add ATM");
 				didmapService.addDidmap(didmap);
 				
 				return  "redirect:/maintenance";
 		 }
 		 */
 		//Reloading		
 		 
 		@RequestMapping(value = "/addReload", method = RequestMethod.POST)
 	 		public String addReload(ReloadDto reload,  BindingResult result
 	 				) {

 	 			//	System.out.println("Atm Name:" + atm.getAtmName()+ "Location:"
 	 			//			+ atm.getAtmLocation());
 	 				logger.info("Add Reload");
 	 				System.out.println(reload.getReloadId());
 	 				System.out.println(reload.getAtm());
 	 				System.out.println(reload.getOperator());
 	 				System.out.println(reload.getTaskExpiryTime());
 	 				System.out.println(reload.getTray1());
 	 				System.out.println(reload.getTray2());
 	 				System.out.println(reload.getOtk());
 	 				reloadService.addReload(reload);
 	 				return  "redirect:/maintenance";
 					
 		}
 		
 		
 	    @RequestMapping("/remove/{id}")
 	    public String removePerson(@PathVariable("id") int id){
 	         AtmReload atmreload = null;
 	         Transactions transactions = null;
 	        List<Transactions> transactionslist = null;
 	        atmreload = reloadService.findreloadbyid(id);
 	        int Transactionid=0;
 	        switch(atmreload.getStatus()){
 	        case "4":
 	        transactionslist=transactionService.getTransactionbyReloadid(id);
 	        Transactionid=transactionslist.get(0).getTransactionId();
 	        transactions=transactionService.findtransactionbyid(Transactionid);
 	        transactionService.deletetransactionbyid(transactions);
 	        reloadService.deletereloadbyid(atmreload);
 	        System.out.println("Transaction");
 	        break;
 	        default:
 	        	
 	        	reloadService.deletereloadbyid(atmreload);
 	        }
 	       
 	       return  "redirect:/maintenance";
 	    }
 	  

    
  
}