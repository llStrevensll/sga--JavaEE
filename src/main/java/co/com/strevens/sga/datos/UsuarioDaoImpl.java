
package co.com.strevens.sga.datos;

import co.com.strevens.sga.domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao{
    
    @PersistenceContext(unitName="SgaPU") //Sga PU definido en persistence.xml
    EntityManager entityManager;
    
    @Override
    public List<Usuario> findAllUsuarios() {
        return entityManager.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return entityManager.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public void insertarUsuario(Usuario usuario) {
        entityManager.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        //primero sea hace merge para actualizar el estado del objeto (sincronizar)
        entityManager.remove(entityManager.merge(usuario));
    }
    
}
