package com.ciandt.casetecnico.controller;

import com.ciandt.casetecnico.form.SMSForm;
import com.ciandt.casetecnico.service.SMSService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value = "/sms")
public class SMSController {

    private static final Logger LOGGER = Logger.getLogger(SMSController.class);

    @Autowired
    private SMSService smsService;

    @RequestMapping(value="/iniciar", method = RequestMethod.GET)
    public ModelAndView iniciarPagina() {
        ModelAndView mav = new ModelAndView("sms");
        mav.addObject("formulario", new SMSForm());
        return mav;
    }

    @RequestMapping(value = "/traduzir", method = RequestMethod.POST)
    public ModelAndView traduzir(HttpServletRequest req, HttpServletResponse resp, SMSForm form) {
        form.setResultado(this.smsService.traduzir(form.getTexto()));
        LOGGER.info("Usuario " + req.getUserPrincipal().getName() + " traduziu a frase "
                + form.getTexto() + " para " + form.getResultado());
        ModelAndView mav = new ModelAndView("sms");
        mav.addObject("formulario", form);
        return mav;
    }
}