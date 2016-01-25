package lk.dialoglab.ezcash.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lk.dialoglab.ezcash.domain.Atm;
import lk.dialoglab.ezcash.service.AtmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SystemContoller {

    @Autowired
    private AtmService atmService;

    private static final Logger logger = LoggerFactory.getLogger(SystemContoller.class);

    @RequestMapping(value = "/authenticated")
    public ModelAndView Sytem(HttpServletRequest request) {
        logger.info("System Overview Page");
        List<Atm> atmlist = getSystemTable();
        ModelAndView model = new ModelAndView("system");
        model.addObject("atmlist", atmlist);
        HttpSession session = request.getSession();
        session.setAttribute("MenuTab", "system");
        session.setAttribute("AtmTab", "");
        return model;

    }

    private List<Atm> getSystemTable() {
        List<Atm> atmlist = atmService.getAtmList();
        System.out.println("Battary Level "+atmlist.get(0).getbatLevel());
        System.out.println("Battary Level "+atmlist.get(1).getbatLevel());
        System.out.println("Battary Level "+atmlist.get(2).getbatLevel());
        System.out.println("Battary Level "+atmlist.get(3).getbatLevel());
        return atmlist;
    }

    @RequestMapping(value = "/logout")
    public String Logout(HttpServletRequest request) {
        logger.info("User LogOut");
        HttpSession session = request.getSession();
        session.setAttribute("LoginUser", null);
        return "redirect:/welcome";
    }

}
