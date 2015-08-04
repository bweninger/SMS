package com.ciandt.casetecnico.test;

import com.ciandt.casetecnico.service.SMSService;
import com.ciandt.casetecnico.service.impl.SMSServiceImpl;
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
        assertEquals(service.traduzir(frase), "833777783303_33063377772");

        frase = "BRUNO CESAR WENINGER";
        assertEquals(service.traduzir(frase), "227778866_6660222337777277709336644466433777");

        frase = "---Eu possuo caracteres especiais---";
        try {
            service.traduzir(frase);
        } catch (RuntimeException rex) {
            if (rex.getMessage().contains("Caractere nao identificado")){
               assertTrue(true);
            } else {
                fail();
            }
        }

    }

    @Test
    public void testNumeroParaPalavra(){
        String codigo = "833777783303_33063377772";
        assertEquals(service.traduzir(codigo), "TESTE DE MESA");

        codigo = "227778866_6660222337777277709336644466433777";
        assertEquals(service.traduzir(codigo), "BRUNO CESAR WENINGER");
    }
}
