package br.com.mercadoservico.controller;

import br.com.mercadoservicos.domain.Categoria;
import br.com.mercadoservicos.service.CategoriaService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean (name = "categoriaMB")
@SessionScoped
public class CategoriaController implements Serializable{
   
    private Categoria categoria = new Categoria();
    private List<Categoria> categorias;
    private CategoriaService categoriaService = new CategoriaService();

    public CategoriaController() {
        listar();
    }
    
    public void listar(){
        categorias = categoriaService.listar();
    }
    
    public String novo(){
        categoria = new Categoria();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        categoriaService.inserir(categoria);
        this.listar();
        return "list.xhtml?faces-redirect=true";
    }
    
    
    public String alterar(){
        categoriaService.alterar(categoria);
        this.listar();
        return "list.xhtml?faces-redirect=true";
    }
    
    public String excluir(Categoria categoria){
        categoriaService.excluir(categoria);
        this.listar();
        return "list.xhtml?faces-redirect=true";

    }
    
    public String buscaDados(Categoria categoria){
        this.categoria = categoria;
        return "alter.xhtml?faces-redirect=true";
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public CategoriaService getCategoriaService() {
        return categoriaService;
    }

    public void setCategoriaService(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    
    


    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
    
    
    
}
