package br.com.mercadoservicos.dao;

import br.com.mercadoservicos.domain.ItensOrdemServico;
import br.com.mercadoservicos.domain.OrdemServico;
import br.com.mercadoservicos.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;


public class ItensOrdemServicoDao {
    
    public List<ItensOrdemServico> listar(OrdemServico ordemServico) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            List<ItensOrdemServico> itensOrdemServico = session.createQuery("from ItensOrdemServico where idOrdemServico = "+ ordemServico.getId()+ " order by sequencia").list();
            session.getTransaction().commit();
            return itensOrdemServico;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean inserir(ItensOrdemServico itemOrdemServico) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(itemOrdemServico);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean alterar(ItensOrdemServico itemOrdemServico) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.update(itemOrdemServico);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean excluir(ItensOrdemServico itemOrdemServico) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.delete(itemOrdemServico);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }
    
}
