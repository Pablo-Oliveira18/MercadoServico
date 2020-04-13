package br.com.mercadoservicos.service;

import br.com.mercadoservicos.dao.UsuarioDao;
import br.com.mercadoservicos.domain.Usuario;
import br.com.mercadoservicos.util.HashMaker;

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
        usuario.setSenha(HashMaker.stringHexa(HashMaker.gerarHash(usuario.getSenha())));
        return usuarioDao.inserir(usuario);
    }

    public boolean alterar(Usuario usuario) {
        usuario.setSenha(HashMaker.stringHexa(HashMaker.gerarHash(usuario.getSenha())));
        return usuarioDao.alterar(usuario);
    }

    public boolean excluir(Usuario usuario) {
        return usuarioDao.excluir(usuario);
    }
    
    public boolean autenticar(Usuario usuario){
        Usuario usuarioBanco = usuarioDao.consultaPorEmail(usuario.getEmail());
        if(usuarioBanco == null){
            return false;
        }else{
            String senhaCriptografada = HashMaker.stringHexa(HashMaker.gerarHash(usuario.getSenha()));
            if (senhaCriptografada.equals(usuarioBanco.getSenha())){
                return true;
            }
        }
        return false;
    }
}
