package com.ciandt.casetecnico.test;

import com.ciandt.service.SMSService;
import com.ciandt.service.SMSServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by BWeninger on 01/08/2015.
 */
public class SMSTest {

    private SMSService service = new SMSServiceImpl();

    @Test
    public void testTraducaoPalavra(){

        String frase = "TESTE DE MESA";
        assertEquals(service.traduzirParaTecladoNumerico(frase), "833777783303_33063377772");

    }
}
