package br.com.mercadoservico.controller;

import br.com.mercadoservicos.domain.Servico;
import br.com.mercadoservicos.service.ServicoService;
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
        servicoService.inserir(servico);
        this.listar();
        return "list.xhtml?faces-redirect=true";
    }

    public String alterar() {
        servicoService.alterar(servico);
        this.listar();
        return "list.xhtml?faces-redirect=true";
    }

    public String excluir(Servico servico) {
        servicoService.excluir(servico);
        this.listar();
        return "list.xhtml?faces-redirect=true";

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
