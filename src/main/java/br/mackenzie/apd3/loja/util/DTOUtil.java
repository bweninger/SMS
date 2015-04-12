package br.mackenzie.apd3.loja.util;

import br.mackenzie.apd3.loja.dto.DataTransferObject;
import br.mackenzie.apd3.loja.model.Entidade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BWeninger on 11/04/2015.
 */
public final class DTOUtil {

    private DTOUtil(){

    }

    public static <DTO extends DataTransferObject>  List<DTO> converterLista(
            List<? extends Entidade> src, Class<DTO> clazz){
        List<DTO> dest = new ArrayList<>();
        for(Entidade ent : src){
            DataTransferObject dto = ent.converterParaDTO();
            dest.add(clazz.cast(dto));
        }
        return dest;
    }

}
