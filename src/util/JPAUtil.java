package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Matheus
 */
public class JPAUtil {
    
    private static EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("ProjetoWeb2PU");
    
    private static EntityManager em;
    
    public static EntityManager createEntityManager(){
        em = emf.createEntityManager();
        return em;
    }
    
    public static void closeEntityManager(){
        em.close();
    }
}
