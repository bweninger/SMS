package br.mackenzie.apd3.loja.model;

import java.math.BigDecimal;

public abstract class Pagamento {
	
	protected BigDecimal valor;
	protected StatusPagamento status;
	
	protected abstract void pagar();

}
