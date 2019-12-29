package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Usuario;
import util.JPAUtil;

/**
 *
 * @author Matheus
 */
public class UsuarioDAO {

    private EntityManager em;

    public void inserir(Usuario u) throws Exception {
        try {
            // obter um EntityManager (Conexão)
            em = JPAUtil.createEntityManager();
            // inicar transação
            em.getTransaction().begin();
            // executar operação (salva o registro)
            em.persist(u);
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

    public void editar(Usuario u) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            em.merge(u);
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

    public void excluir(Usuario u) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            em.getTransaction().begin();
            // remove o registro informado
            u = em.find(Usuario.class, u.getId());
            em.remove(u);
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

    public Usuario getPorId(long id) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            // realiza a busca de 1 único registro com o id especficado
            return em.find(Usuario.class, id);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Usuario> getLista() throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            // JPQL (Linguagem de COnsulta do JPA)
            Query query = em.createQuery("SELECT u FROM Usuario u");
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            throw new Exception("Erro ao consultar registros!");
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Usuario> buscar(String busca) throws Exception {
        try {
            em = JPAUtil.createEntityManager();
            // JPQL (Linguagem de COnsulta do JPA)
            // select * from contato where nome like 'Al%'
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE lower(u.nome) like lower(:busca)");
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
