package br.com.mercadoservicos.dao;

import br.com.mercadoservicos.domain.Usuario;
import br.com.mercadoservicos.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;


public class UsuarioDao {
    
    public List<Usuario> listar() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            List<Usuario> usuarios = session.createQuery("from Usuario order by nome").list();
            session.getTransaction().commit();
            return usuarios;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public Usuario consulta(Integer id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            Usuario usuario = (Usuario) session.createQuery("from Usuario where id = " + id).uniqueResult(); // uniqueResult retorna apenas 1 resultado
            session.getTransaction().commit();
            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean inserir(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(usuario);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }

    }

    public boolean excluir(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.delete(usuario);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }

    }

    public boolean alterar(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.update(usuario);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }

    }
    
}
