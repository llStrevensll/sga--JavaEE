
package co.com.strevens.sga.servicio;

import co.com.strevens.sga.datos.PersonaDao;
import co.com.strevens.sga.domain.Persona;
import java.util.List;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService{
    
    //Inyectar capa de datos
    @Inject
    private PersonaDao personaDao;
    
    //Variable contexto para transacción
    private SessionContext contexto;
    
    @Override
    public List<Persona> listarPersona() {
        return personaDao.findAllPersonas();
                
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return personaDao.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return personaDao.findPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDao.insertarPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        try{
            personaDao.updatePersona(persona);
        } catch(Throwable r){
            contexto.setRollbackOnly();
            r.printStackTrace(System.out);
        }
        
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }
    
}
