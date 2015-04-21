package br.mackenzie.apd3.loja.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "1")
public class PagamentoBoleto extends Pagamento {

}
