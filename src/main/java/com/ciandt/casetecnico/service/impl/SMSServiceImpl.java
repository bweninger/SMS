package com.ciandt.casetecnico.service.impl;

import com.ciandt.business.TecladoNumerico;
import com.ciandt.casetecnico.service.SMSService;
import com.ciandt.service.SMSService;
import org.springframework.stereotype.Service;

/**
 * Created by BWeninger on 01/08/2015.
 */
@Service
public class SMSServiceImpl implements SMSService {

    @Override
    public String traduzirParaTecladoNumerico(String frase) {
        TecladoNumerico tecladoNumerico = new TecladoNumerico();
        return tecladoNumerico.traduzirParaNumeros(frase);
    }
}
