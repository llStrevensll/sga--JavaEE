
package co.com.strevens.sga.ciclovidajpa;

import co.com.strevens.sga.domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class PersistirObjetoJPA {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        
        //Paso 1. Crea nuevo objeto
        //Objeto en estado transitivo
        Persona persona1 = new Persona("Juan", "Hernandez", "jher@mail.com", "22135566");
        
        //Paso 2. Inicia transaccion
        tx.begin();
        
        //Paso 3. Ejecuta SQL
        em.persist( persona1 );
        
        log.error("Objeto persistido - aun sin commit:" + persona1);
        
        //Paso 4. commit/rollback
        tx.commit();
        
        //Objeto en estado detached
        log.error("Objeto persistido - estado detached:" + persona1);
        
        //Cerramos el entity manager
        em.close();
        
    }
    
}