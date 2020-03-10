package br.com.mercadoservico.controller;

import br.com.mercadoservicos.domain.Categoria;
import br.com.mercadoservicos.service.CategoriaService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name = "categoriaMB")
@RequestScoped
public class CategoriaController {
    
    private String descricao;
    private Integer id;
    private List<Categoria> categorias;
    private CategoriaService categoriaService = new CategoriaService();

    public CategoriaController() {
        listar();
    }
    
    public void listar(){
        categorias = categoriaService.listar();
    }
    
    public String novo(){
        return "private/cadastros/categoria/new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "private/cadastros/categoria/list.xhtml?faces-redirect=true";
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    
    
}
