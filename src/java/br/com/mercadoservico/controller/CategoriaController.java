package br.com.mercadoservico.controller;

import br.com.mercadoservicos.domain.Categoria;
import br.com.mercadoservicos.service.CategoriaService;
import br.com.mercadoservicos.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean (name = "categoriaMB")
@SessionScoped
public class CategoriaController implements Serializable{
   
    private Categoria categoria = new Categoria();
    private List<Categoria> categorias;
    private CategoriaService categoriaService = new CategoriaService();

    public CategoriaController() {
        listar();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("servicoMB");
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
        if(categoriaService.inserir(categoria)){
            UtilMensagens.mensagemSucesso("Sucesso", "Categoria salva com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar categoria");
        return null;
    }
    
    
    public String alterar(){
        if (categoriaService.alterar(categoria)){
            UtilMensagens.mensagemSucesso("Sucesso", "Categoria alterada com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar a categoria");
        return null;
    }
    
    public String excluir(Categoria categoria){
        if(categoriaService.excluir(categoria)){
            UtilMensagens.mensagemSucesso("Sucesso", "Categoria excluida com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a categoria");
        return null;
        
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
