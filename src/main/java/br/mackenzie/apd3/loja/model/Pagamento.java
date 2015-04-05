package br.mackenzie.apd3.loja.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType=DiscriminatorType.INTEGER, name="tipoPagamento")
public abstract class Pagamento {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long cdPagamento;
	protected BigDecimal valor;
	@ManyToOne
	@JoinColumn(name="idStatusPagamento", referencedColumnName="idStatusPagamento")
	protected StatusPagamento status;
	
	protected abstract void pagar();

}
