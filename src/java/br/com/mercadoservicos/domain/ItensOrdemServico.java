package br.com.mercadoservicos.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table (name="itensos")

public class ItensOrdemServico  implements Serializable{
    
    @EmbeddedId
    private ItensOrdemServicoPk itensOrdemServicoPk;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="idServico", referencedColumnName="id")
    private Servico servico;
    
    @NotNull
    @Column(name="preco")
    private Double preco;
        
    @NotNull
    @Column(name="quantidade")
    private Double quantidade;

    public ItensOrdemServico() {
    }

    public ItensOrdemServico(OrdemServico ordemServico,Integer sequencia, Servico servico, Double preco, Double quantidade) {
        this.itensOrdemServicoPk.setOrdemServico(ordemServico);
        this.itensOrdemServicoPk.setSequencia(sequencia);
        this.servico = servico;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public ItensOrdemServicoPk getItensOrdemServicoPk() {
        return itensOrdemServicoPk;
    }

    public void setItensOrdemServicoPk(ItensOrdemServicoPk itensOrdemServicoPk) {
        this.itensOrdemServicoPk = itensOrdemServicoPk;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.itensOrdemServicoPk);
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
        final ItensOrdemServico other = (ItensOrdemServico) obj;
        if (!Objects.equals(this.itensOrdemServicoPk, other.itensOrdemServicoPk)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "ItensOrdemServico{" + "itensOrdemServicoPk=" + itensOrdemServicoPk + ", servico=" + servico + ", preco=" + preco + ", quantidade=" + quantidade + '}';
    }
    
    
    
}
