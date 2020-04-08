package br.com.mercadoservico.controller;

import br.com.mercadoservicos.domain.Usuario;
import br.com.mercadoservicos.service.UsuarioService;
import br.com.mercadoservicos.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "usuarioMB")
@SessionScoped
public class UsuarioController implements Serializable{
    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios;
    private UsuarioService usuarioService = new UsuarioService();

    public UsuarioController() {
        listar();
    }

    public void listar() {
        usuarios = usuarioService.listar();
    }

    public String novo() {
        usuario = new Usuario();
        return "new.xhtml?faces-redirect=true";
    }

    public String cancelar() {
        return "list.xhtml?faces-redirect=true";
    }

    public String salvar() {
        if (usuarioService.inserir(usuario)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Usuario salva com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar usuario");
        return null;
    }

    public String alterar() {
        if (usuarioService.alterar(usuario)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Usuario alterada com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar a usuario");
        return null;
    }

    public String excluir(Usuario usuario) {
        if (usuarioService.excluir(usuario)) {
            UtilMensagens.mensagemSucesso("Sucesso", "Usuario excluida com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a usuario");
        return null;

    }

    public String buscaDados(Usuario usuario) {
        this.usuario = usuario;
        return "alter.xhtml?faces-redirect=true";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
