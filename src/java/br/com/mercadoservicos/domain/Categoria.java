package br.com.mercadoservicos.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // tenta encotrar uma tabela no banco em um bjeto java
@Table(name = "categoria")
public class Categoria implements Serializable{
    
    @Id  // informa qual a chave primaria do banco >>> deve colocar em cima da msma...
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Especifica do MY SQL, dizendo que o ID é grado automaticamente...
    
    private Integer id;
    
    @NotNull // fala q no banco ñ pode ser null
    @Size (min = 1 , max = 45) // minimo de caracteres e o minimo.
    @Column (name = "descricao") // qndo minha coluna tem outro nome
    private String descricao;
    
    public Categoria() {
        
    }

    public Categoria(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", descricao=" + descricao + '}';
    } 
}
