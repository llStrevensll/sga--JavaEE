
package co.com.strevens.sga.servicio;

import co.com.strevens.sga.domain.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class PersonaServiceImpl implements PersonaServiceRemote, PersonaService{

    @Override
    public List<Persona> listarPersona() {
        List<Persona> personas = new ArrayList();
        personas.add(new Persona(1, "Angel", "Rodriguez", "correo.email.com", "1234567"));
        personas.add(new Persona(2, "Emanuel", "Castro", "correo.email.com", "1234567"));
        
        return personas;
                
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return null;
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return null;
    }

    @Override
    public void registrarPersona(Persona persona) {
        
    }

    @Override
    public void modificarPersona(Persona persona) {
        
    }

    @Override
    public void eliminarPersona(Persona persona) {
        
    }
    
}
