package br.mackenzie.apd3.loja.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="2")
public class PagamentoDebitoConta extends Pagamento {

	@Override
	protected void pagar() {
		// TODO Auto-generated method stub
		
	}

}
