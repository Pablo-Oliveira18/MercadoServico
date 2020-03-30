package br.com.mercadoservicos.service;

import br.com.mercadoservicos.dao.ServicoDao;
import br.com.mercadoservicos.domain.Servico;
import java.util.List;


public class ServicoService {
    private ServicoDao servicoDao = new ServicoDao();

    public List<Servico> listar() {
        return servicoDao.listar();
    }

    public Servico consultar(Integer id) {
        return servicoDao.consulta(id);
    }

    public boolean inserir(Servico servico) {
        return servicoDao.inserir(servico);
    }

    public boolean alterar(Servico servico) {
        return servicoDao.alterar(servico);
    }

    public boolean excluir(Servico servico) {
        return servicoDao.excluir(servico);
    }
}
