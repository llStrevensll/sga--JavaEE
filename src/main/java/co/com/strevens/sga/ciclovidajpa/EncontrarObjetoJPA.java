
package co.com.strevens.sga.ciclovidajpa;

import co.com.strevens.sga.domain.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EncontrarObjetoJPA {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso 2. Ejecuta SQL de tipo select
        Persona persona1 = em.find(Persona.class, 6);
        
        //Paso 3. termina la transaccion
        tx.commit();
       
        //Objeto en estado de detached
        log.error("Objeto recuperado:" + persona1);
        
        //Cerramos el entity manager
        em.close();

    }
}
