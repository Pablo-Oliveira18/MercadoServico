package br.com.mercadoservico.controller;

import br.com.mercadoservicos.domain.ItensOrdemServico;
import br.com.mercadoservicos.domain.OrdemServico;
import br.com.mercadoservicos.domain.Servico;
import br.com.mercadoservicos.domain.Usuario;
import br.com.mercadoservicos.service.OrdemServicoService;
import br.com.mercadoservicos.service.UsuarioService;
import br.com.mercadoservicos.util.UtilMensagens;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="ordemServicoMB")
@SessionScoped
public class OrdemServicoController implements Serializable{
    
    private OrdemServico ordemServico = new OrdemServico();
    private List<OrdemServico> ordemServicos;
    private OrdemServicoService ordemServicoService = new OrdemServicoService();
    private UsuarioService usuarioService = new UsuarioService();
    private List<Usuario> clientes;
    private List<Usuario> empresas;
    private List<ItensOrdemServico> itensOrdemServico;
    private ItensOrdemServico itemOrdemServico;
    
    public OrdemServicoController(){
        listar();
    }
    
    public void listar(){
        ordemServicos = ordemServicoService.listar();
    }
    
    public String novo(){
        ordemServico = new OrdemServico();
        itensOrdemServico = new ArrayList<>();
        itemOrdemServico = new ItensOrdemServico();
        clientes = usuarioService.listarClientes();
        empresas = usuarioService.listarEmpresas();
        return "new.xhtml?faces-redirect=true";
    }
    
    public String cancelar(){
        return "list.xhtml?faces-redirect=true";
    }
    
    public String buscaDados(OrdemServico ordemServico){
        this.ordemServico = ordemServico;
        return "alter.xhtml?faces-redirect=true";
    }
    
    public String salvar(){
        ordemServico.setItensOs(itensOrdemServico);
        if (ordemServicoService.inserir(ordemServico)){
            UtilMensagens.mensagemSucesso("Sucesso", "Ordem de Serviço salva com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao salvar a ordem de serviço!");
        return null;
    }
    
    public String alterar(){
        if (ordemServicoService.alterar(ordemServico)){
            UtilMensagens.mensagemSucesso("Sucesso", "Ordem de Serviço alterada com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao alterar a ordem de serviço");
        return null;
    }
    
    public String excluir(OrdemServico ordemServico){
        if (ordemServicoService.excluir(ordemServico)){
            UtilMensagens.mensagemSucesso("Sucesso", "Ordem de Serviço excluída com sucesso!");
            this.listar();
            return "list.xhtml?faces-redirect=true";
        }
        UtilMensagens.mensagemErro("Erro", "Ocorreu um erro ao excluir a ordem serviço");
        return null;
    }
    
    public void addServico(){
        itensOrdemServico.add(itemOrdemServico);
        itemOrdemServico = new ItensOrdemServico();
    }
    
    public void removeServico(ItensOrdemServico itemOrdemServico){
        itensOrdemServico.remove(itemOrdemServico);
    }
    
    public void calculaTotal (){
        Servico servico = itemOrdemServico.getServico();
        Double preco = servico.getPreco();
        Double quantidade = itemOrdemServico.getQuantidade();
        itemOrdemServico.setPreco(quantidade * preco);
    }

    public OrdemServicoService getOrdemServicoService() {
        return ordemServicoService;
    }

    public void setOrdemServicoService(OrdemServicoService ordemServicoService) {
        this.ordemServicoService = ordemServicoService;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public List<ItensOrdemServico> getItensOrdemServico() {
        return itensOrdemServico;
    }

    public void setItensOrdemServico(List<ItensOrdemServico> itensOrdemServico) {
        this.itensOrdemServico = itensOrdemServico;
    }

    public ItensOrdemServico getItemOrdemServico() {
        return itemOrdemServico;
    }

    public void setItemOrdemServico(ItensOrdemServico itemOrdemServico) {
        this.itemOrdemServico = itemOrdemServico;
    }
    
    

    public List<OrdemServico> getOrdemServicos() {
        return ordemServicos;
    }

    public void setOrdemServicos(List<OrdemServico> ordemServicos) {
        this.ordemServicos = ordemServicos;
    }

    public OrdemServico getOrdemServico() {
        return ordemServico;
    }

    public void setOrdemServico(OrdemServico ordemServico) {
        this.ordemServico = ordemServico;
    }

    public List<Usuario> getClientes() {
        return clientes;
    }

    public void setClientes(List<Usuario> clientes) {
        this.clientes = clientes;
    }

    public List<Usuario> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Usuario> empresas) {
        this.empresas = empresas;
    }
    
    
}
