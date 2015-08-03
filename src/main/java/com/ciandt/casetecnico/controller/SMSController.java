package com.ciandt.casetecnico.controller;

import com.ciandt.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/sms/")
public class SMSController {

    @Autowired
    private SMSService smsService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView iniciarPagina(){
        System.out.println("TESTE");
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/traduzir/{frase}", method = RequestMethod.GET)
    public String traduzir(@PathVariable("frase") String frase) {
        return this.smsService.traduzirParaTecladoNumerico(frase);
    }
}