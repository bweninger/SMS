package com.ciandt.casetecnico.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by BWeninger on 02/08/2015.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static final Logger LOGGER = Logger.getLogger(LoginController.class);

    @RequestMapping(method = RequestMethod.GET)
        public ModelAndView iniciarTelaLogin() {
        ModelAndView model = new ModelAndView("login");
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest req,
            @RequestParam(value = "error", required = false) String error) {

        ModelAndView model = null;
        if (error != null) {
            model = new ModelAndView("login");
            model.addObject("error", "Usuario ou senha invalidos");
            LOGGER.warn("Tentativa de acesso com usuario ou senha incorretos.");
        } else {
            Principal user = req.getUserPrincipal();
            LOGGER.info("Usuario " + user.getName() + " acessou o sistema.");
            model = new ModelAndView("sms");
        }
        return model;
    }
}
