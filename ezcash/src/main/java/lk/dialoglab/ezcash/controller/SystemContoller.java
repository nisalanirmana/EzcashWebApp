package lk.dialoglab.ezcash.controller;

import java.io.IOException;
import java.util.List;



import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.dto.Login;
import lk.dialoglab.ezcash.service.AtmService;
import lk.dialoglab.ezcash.util.HibernateUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SystemContoller {
	
@Autowired
private AtmService atmService;


	private static final Logger logger = LoggerFactory
			.getLogger(SystemContoller.class);

	@RequestMapping(value="/authenticated")
	public ModelAndView Sytem(HttpServletRequest request) {   
		logger.info("System Overview Page!");
		
		List<Atm> atmlist=getSystemTable();	
		for (Atm a:atmlist)
		{
			
			logger.info("ATM Name"+a.getAtmName());
			logger.info("ATM Location"+a.getAtmLocation().getLocationName());
			logger.info("ATM Status"+a.getStatus());
		
		}
	logger.info("Creating Model and View for System Page");
	ModelAndView model = new ModelAndView("system");
	model.addObject("atmlist", atmlist);
	 HttpSession session = request.getSession();
     session.setAttribute("MenuTab", "system");
     logger.info("returning the model");
	return model;
	
	
	}
	

	 
	

	
	private List<Atm> getSystemTable(){
		List<Atm> atmlist=	atmService.getAtmList();
		logger.info("****************************************************************888");
		
		return atmlist;
		
	}
	
	
	@RequestMapping(value="/logout")
	public String Logout(HttpServletRequest request) {   
		logger.info("System Overview Page!");
		
		


	 HttpSession session = request.getSession();
     session.setAttribute("LoginUser", null);
     logger.info("returning the model");
     return  "redirect:/welcome";
	
	
	}

}
