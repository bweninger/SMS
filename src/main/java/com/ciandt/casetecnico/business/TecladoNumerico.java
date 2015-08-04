package com.ciandt.casetecnico.business;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by BWeninger on 01/08/2015.
 */
public class TecladoNumerico {

    private Map<Integer, String> mapaCaracteres;

    public TecladoNumerico(){
        this.mapaCaracteres = new HashMap<Integer, String>();
        mapaCaracteres.put(2, "ABC");
        mapaCaracteres.put(3, "DEF");
        mapaCaracteres.put(4, "GHI");
        mapaCaracteres.put(5, "JKL");
        mapaCaracteres.put(6, "MNO");
        mapaCaracteres.put(7, "PQRS");
        mapaCaracteres.put(8, "TUV");
        mapaCaracteres.put(9, "WXYZ");
        mapaCaracteres.put(0, " ");
    }

    public final String traduzirParaNumeros(String frase) {
        StringBuilder result = new StringBuilder();
        frase = frase.toUpperCase().trim();
        for(int i = 0; i < frase.length();i++) {
            Integer representacaoNumerica = caractereParaNumero(frase.substring(i, i + 1));
            if(result.length() > 0) {
                if (representacaoNumerica.toString().charAt(representacaoNumerica.toString().length() - 1) == (result.charAt(result.length() - 1))) {
                    result.append("_");
                }
            }

            result.append(representacaoNumerica.toString());
        }

        return result.toString();
    }

    private Integer caractereParaNumero(String ch) {
        for (Map.Entry<Integer, String> entry : mapaCaracteres.entrySet()) {
            if (entry.getValue().contains(ch)) {
               return obterRepresentacaoLetra(entry.getKey(), ch);
            }
        }

        throw new RuntimeException("Caractere nao identificado");
    }

    private Integer obterRepresentacaoLetra(Integer key, String letra) {
        int pos = mapaCaracteres.get(key).indexOf(letra) + 1;
        int total = key;
        for (int i = 1; i < pos; i++) {
            total = (total * 10) + key;
        }

        return total;
    }

    public final String traduzirDeTecladoNumerico(String codigo) {
        StringBuilder result = new StringBuilder();
        String prev = codigo.substring(0, 1);
        int count = 0;
        for(int i = 1; i < codigo.length(); prev = codigo.substring(i, i+1), i++) {
           if (codigo.substring(i, i+1).equals(prev)) {
               count++;
               continue;
           }

            if (!prev.equals("_")) {
                result.append(mapaCaracteres.get(Integer.parseInt(prev.toString())).charAt(count));
            }
            count = 0;
        }

        result.append(mapaCaracteres.get(Integer.parseInt(prev.toString())).charAt(count));
        return result.toString();
    }
}
