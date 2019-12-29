package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Fornecedor;
import util.JPAUtil;

/**
 *
 * @author Leandro
 */
public class FornecedorDAO {

    private EntityManager em;

    public void inserir(Fornecedor f) throws Exception {
        try {
            // obter um EntityManager (Conexão)
            em = JPAUtil.createEntityManager();
            // inicar transação
            em.getTransaction().begin();
            // executar operação (salva o registro)
            em.persist(f);
            // encerrar transação
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao inserir registro!");
        } finally {
            // encerrar entity manager
            JPAUtil.closeEntityManager();
        }
    }

    public void editar(Fornecedor f) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao excluir registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluir(Fornecedor f) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            // remove o registro informado
            f = em.find(Fornecedor.class, f.getId());
            em.remove(f);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao excluir registro!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public Fornecedor getPorId(long id) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            // realiza a busca de 1 único registro com o id especficado
            return em.find(Fornecedor.class, id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Fornecedor> getLista() throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            // JPQL (Linguagem de COnsulta do JPA)
            Query query = em.createQuery("SELECT f FROM Fornecedor f");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Fornecedor> buscar(String busca) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            // JPQL (Linguagem de COnsulta do JPA)
            // select * from contato where nome like 'Al%'
            Query query = em.createQuery("SELECT f FROM Fornecedor f WHERE lower(f.nome) like lower(:busca)");
            query.setParameter("busca", busca + "%");
            
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
