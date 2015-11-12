package lk.dialoglab.ezcash.controller;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
/**
 * Handles requests for the application about page.
 */
@Controller
public class AboutController {
     
    private static final Logger logger = LoggerFactory.getLogger(AboutController.class);
     
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String showSystemForm(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        session.setAttribute("MenuTab", "about");
        logger.info("About page !");
         //Git Test Comment
        return "about";
    }
     
}