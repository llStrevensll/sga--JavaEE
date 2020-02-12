
package co.com.strevens.sga.datos;

import co.com.strevens.sga.domain.Persona;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless
public class PersonaDaoImpl  implements PersonaDao{
    
    @PersistenceContext(unitName="SgaPU") //Sga PU definido en persistence.xml
    EntityManager entityManager;

    @Override
    public List<Persona> findAllPersonas() {
        System.out.println("Entre a FindAllllllllllllllllllllll");
        return entityManager.createNamedQuery("Persona.findAll").getResultList();
    }

    @Override
    public Persona findPersonaById(Persona persona) {
        return entityManager.find(Persona.class, persona.getIdPersona());
    }

    @Override
    public Persona findPersonaByEmail(Persona persona) {
        Query query = entityManager.createQuery("from Persona p where p.email =: email");//Parametro email
        query.setParameter("email", persona.getEmail());
        //Retorna objeto entonces castear a objeto de tipo persona
        return (Persona) query.getSingleResult();//Retorna unico valor  -> entonces email debe ser unique en BD
    }

    @Override
    public void insertarPersona(Persona persona) {
        entityManager.persist(persona);
    }

    @Override
    public void updatePersona(Persona persona) {
        entityManager.merge(persona);
    }

    @Override
    public void deletePersona(Persona persona) {
        //primero sea hace merge para actualizar el estado del objeto (sincronizar)
        entityManager.remove(entityManager.merge(persona));
    }
}
