package br.mackenzie.apd3.loja.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.INTEGER, name = "tipoPagamento")
public abstract class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long cdPagamento;
    protected BigDecimal valor;
    @Enumerated(EnumType.ORDINAL)
    protected StatusPagamento status;

    protected abstract void pagar();

}
