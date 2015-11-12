package lk.dialoglab.ezcash.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lk.dialoglab.ezcash.domain.Operator;
import lk.dialoglab.ezcash.domain.WebUser;
import lk.dialoglab.ezcash.dto.WebUserDto;
import lk.dialoglab.ezcash.service.OperatorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
 
/**
 * Handles requests for the application about page.
 */
@Controller
public class UsersController {
     
	@Autowired
    private OperatorService operatorService;
     
    private static final Logger logger = LoggerFactory.getLogger(OperatorsController.class);
    
     
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView showUser(HttpServletRequest request) {
      
        logger.info("User page !");
        
    List<WebUser> users=operatorService.getWebUsers();
        
     for(WebUser u:users)
        {
        	
        	System.out.println(u.getUserName());
        	System.out.println(u.getUserType().getTypeName());
        	System.out.println(u.getPhoneNumber());
        	System.out.println(u.getEmail());
        	
        	
        }
      
        ModelAndView model = new ModelAndView("users");
    	model.addObject("users", users);
    	
    	  HttpSession session = request.getSession();
          session.setAttribute("MenuTab", "users");
          logger.info("returning the model");
    	return model;
    }
    
	@RequestMapping(value = "/addWebUser", method = RequestMethod.POST)
		public String addWebUser(WebUserDto webuserdto,  BindingResult result,HttpServletRequest request
				) {
		HttpSession session = request.getSession();
			//	System.out.println("Atm Name:" + atm.getAtmName()+ "Location:"
			//			+ atm.getAtmLocation());
				logger.info("Add WebUser");
				/*
				System.out.println(operator.getOperatorName());
				System.out.println(operator.getOperatorType());
				System.out.println(operator.getOperatorPin());
				System.out.println(operator.getEmail());
				System.out.println(operator.getOperatorType());
				System.out.println(operator.getPhoneNumber());
				System.out.println(operator.getOperatorId());
				*/
				if(!(webuserdto.getPasswordconfirm().contentEquals(webuserdto.getPassword()))){
					session.setAttribute("Msgpass","Password Does Not Match");
					return  "redirect:/users";
					
				}
				else{
					session.setAttribute("Msgpass",null);
					operatorService.addWebUser(webuserdto);
					return  "redirect:/users";
				}
				
			
}
     
}
