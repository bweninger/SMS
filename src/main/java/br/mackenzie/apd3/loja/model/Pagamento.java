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
    @Column(name = "idStatusPagamento")
    protected StatusPagamento status;

    public Long getCdPagamento() {
        return cdPagamento;
    }

    public void setCdPagamento(Long cdPagamento) {
        this.cdPagamento = cdPagamento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pagamento)) return false;

        Pagamento pagamento = (Pagamento) o;

        if (cdPagamento != null ? !cdPagamento.equals(pagamento.cdPagamento) : pagamento.cdPagamento != null)
            return false;
        if (!valor.equals(pagamento.valor)) return false;
        return status == pagamento.status;

    }

    @Override
    public int hashCode() {
        int result = cdPagamento != null ? cdPagamento.hashCode() : 0;
        result = 31 * result + valor.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }
}
