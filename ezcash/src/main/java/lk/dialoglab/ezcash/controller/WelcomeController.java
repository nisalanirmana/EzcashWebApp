package lk.dialoglab.ezcash.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lk.dialoglab.ezcash.dto.Login;
import lk.dialoglab.ezcash.service.OperatorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WelcomeController {

    @Autowired
    private OperatorService operatorService;

    private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @RequestMapping("welcome")
    public String welcome() {
        logger.info("Welcome-Login Page");
        return "welcome";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String authenticate(Login login, BindingResult result, HttpServletRequest request) {

        HttpSession session = request.getSession();
        String passwd = "";
        passwd = operatorService.getWebUserPassword(login.getName());
        if (passwd == null) {
         logger.error("User Name: "+login.getName()+" Not Found");
        } else {

            if (passwd.equals(login.getPassword())) {
        logger.info("User Name: "+login.getName()+" Authenticated Successfully");
                session.setAttribute("Msg", null);
                session.setAttribute("LoginUser", login.getName());
                return "redirect:/authenticated";

            } else {
        logger.error("User Name: "+login.getName()+" Wrong Password");
                session.setAttribute("Msg", "User Name or Password Incorrect");
                return "redirect:/welcome";
            }
        }
        return "redirect:/welcome";

    }

}
