package br.mackenzie.apd3.loja.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "3")
public class PagamentoPagSeguro extends Pagamento {

}
