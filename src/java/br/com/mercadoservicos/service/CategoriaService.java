package br.com.mercadoservicos.service;

import br.com.mercadoservicos.dao.CategoriaDao;
import br.com.mercadoservicos.domain.Categoria;
import java.util.List;


public class CategoriaService {
    
    private CategoriaDao categoriaDao = new CategoriaDao();
    
    public List<Categoria> listar(){
        return categoriaDao.listar();
    }
    
    public Categoria consultar(Integer id){
        return categoriaDao.consulta(id);
    }
    
    public boolean inserir(Categoria categoria){
        return categoriaDao.inserir(categoria);
    }
    
    public boolean alterar(Categoria categoria){
        return categoriaDao.alterar(categoria);
    }
    
    public boolean excluir(Categoria categoria){
        return categoriaDao.excluir(categoria);
    }
    
}
