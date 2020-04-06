package br.com.mercadoservico.controller;

import br.com.mercadoservicos.domain.Servico;
import br.com.mercadoservicos.service.ServicoService;
import br.com.mercadoservicos.util.UtilMensagens;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "servicoMB")
@SessionScoped
public class ServicoController implements Serializable{
    private Servico servico = new Servico();
    private List<Servico> servicos;
    private ServicoService servicoService = new ServicoService();

    public ServicoController() {
        listar();
    }

    public void listar() {
        servicos = servicoService.listar();
    }

    public String novo() {
        servico = new Servico();
        return "new.xhtml?faces-redirect=true";
    }

    public String cancelar() {
        return "list.xhtml?faces-redirect=true";
    }

    public String salvar() {
        if(servicoService.inserir(servico)){
            UtilMensagens.mensagemSucesso("Sucesso", "Serviço salvo com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar o servico");
        return null;
    }

    public String alterar() {
        if(servicoService.alterar(servico)){
            UtilMensagens.mensagemSucesso("Sucesso", "Serviço alterado com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar o servico");
        return null;
        
    }

    public String excluir(Servico servico) {
        if(servicoService.excluir(servico)){
            UtilMensagens.mensagemSucesso("Sucesso", "Serviço excluido com sucesso !");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir o servico");
        return null;
    }

    public String buscaDados(Servico servico) {
        this.servico = servico;
        return "alter.xhtml?faces-redirect=true";
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    public ServicoService getServicoService() {
        return servicoService;
    }

    public void setServicoService(ServicoService servicoService) {
        this.servicoService = servicoService;
    }
    
    
}
