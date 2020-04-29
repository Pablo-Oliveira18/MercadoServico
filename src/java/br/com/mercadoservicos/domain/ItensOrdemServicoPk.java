package br.com.mercadoservicos.domain;

import br.com.mercadoservicos.domain.OrdemServico;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Embeddable
public class ItensOrdemServicoPk implements Serializable{
    
    @ManyToOne
    @JoinColumn(name="idOrdemServico", referencedColumnName="id")
    private OrdemServico ordemServico;
    
    @NotNull
    @Column(name="sequencia")
    private Integer sequencia;

    public ItensOrdemServicoPk() {
    }

    public ItensOrdemServicoPk(OrdemServico ordemServico, Integer sequencia) {
        this.ordemServico = ordemServico;
        this.sequencia = sequencia;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public Integer getSequencia() {
        return sequencia;
    }

    public void setSequencia(Integer sequencia) {
        this.sequencia = sequencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.ordemServico);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItensOrdemServicoPk other = (ItensOrdemServicoPk) obj;
        if (!Objects.equals(this.ordemServico, other.ordemServico)) {
            return false;
        }
        return true;
    }


    
    
}
