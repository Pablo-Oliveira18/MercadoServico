package br.com.mercadoservicos.service;

import br.com.mercadoservicos.dao.UsuarioDao;
import br.com.mercadoservicos.domain.Usuario;
import java.util.List;


public class UsuarioService {
    private UsuarioDao usuarioDao = new UsuarioDao();

    public List<Usuario> listar() {
        return usuarioDao.listar();
    }

    public Usuario consultar(Integer id) {
        return usuarioDao.consulta(id);
    }

    public boolean inserir(Usuario usuario) {
        return usuarioDao.inserir(usuario);
    }

    public boolean alterar(Usuario usuario) {
        return usuarioDao.alterar(usuario);
    }

    public boolean excluir(Usuario usuario) {
        return usuarioDao.excluir(usuario);
    }
}
