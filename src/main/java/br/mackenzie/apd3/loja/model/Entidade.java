package br.mackenzie.apd3.loja.model;

import br.mackenzie.apd3.loja.dto.DataTransferObject;

/**
 * Created by BWeninger on 11/04/2015.
 */
public interface Entidade<DTO extends DataTransferObject> {

    DTO converterParaDTO();
}
