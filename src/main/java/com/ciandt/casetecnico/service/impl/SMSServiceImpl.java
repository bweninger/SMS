package com.ciandt.casetecnico.service.impl;

import com.ciandt.casetecnico.business.TecladoNumerico;
import com.ciandt.casetecnico.service.SMSService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BWeninger on 01/08/2015.
 */
@Service
public class SMSServiceImpl implements SMSService {

    @Override
    public String traduzir(String frase) {
        TecladoNumerico tecladoNumerico = new TecladoNumerico();

        String regexNumeros = "(\\d+_*)+\\d*";
        String regexFrase = "([a-zA-Z]+\\s*[a-zA-Z]+)+";

        Pattern patternNumeros = Pattern.compile(regexNumeros);
        Pattern patternFrase = Pattern.compile(regexFrase);
        Matcher m = patternNumeros.matcher(frase);

        if(m.matches()) {
            return tecladoNumerico.traduzirDeTecladoNumerico(frase);
        } else {
            m = patternFrase.matcher(frase);
            if(m.matches()) {
                return tecladoNumerico.traduzirParaNumeros(frase);
            } else {
                return "Conteudo nao identificado";
            }
        }
    }
}
