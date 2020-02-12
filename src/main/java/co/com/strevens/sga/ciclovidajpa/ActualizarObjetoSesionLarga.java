
package co.com.strevens.sga.ciclovidajpa;

import co.com.strevens.sga.domain.Persona;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActualizarObjetoSesionLarga {

    static Logger log = LogManager.getRootLogger();

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em = emf.createEntityManager();

        //Inicia la transaccion
        //Paso 1. Iniciar una transaccion
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        //Paso. ejecutamos SQL de tipo select
        Persona persona1 = em.find(Persona.class, 1);
        
        log.error("Objecto encontrado:" + persona1);
        
        //Paso 3. setValue(nuevoValor)
        persona1.setEmail("angel@mail.com");
        
        persona1.setEmail("a.ngel@mail.com");
        
        //Paso 4. Termina la transaccion 1
        tx.commit();
        
        //Objeto en estado detached
        log.error("objeto modificado:" + persona1);

        //Cerramos el entity manager
        em.close();

    }

}
