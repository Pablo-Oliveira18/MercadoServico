package br.com.mercadoservicos.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "servicos")
public class Servico implements Serializable{
    
    @Id // chave primaria
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Column(name="descricao")
    private String descricao;
    
    @NotNull
    @Column(name = "preco")
    private Double preco;
    
    @ManyToOne // tenho um uúnico serviço para varias categorias
    @JoinColumn (name = "idCategoria", referencedColumnName="id" ) // em qual coluna é feito essa junção, e nome da coluna q esta usando para referenciar
    private Categoria categoria;
    
    @OneToMany (mappedBy="id")
    private List<ItensOrdemServico> itensOs;
    
    public Servico(){
        
    }

    public Servico(Integer id, String descricao, Double preco, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<ItensOrdemServico> getItensOs() {
        return itensOs;
    }

    public void setItensOs(List<ItensOrdemServico> itensOs) {
        this.itensOs = itensOs;
    }




    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Servico{" + "id=" + id + ", descricao=" + descricao + ", preco=" + preco + ", categoria=" + categoria + '}';
    }

    
    
    
}
