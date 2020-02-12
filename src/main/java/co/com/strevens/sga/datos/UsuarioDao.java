
package co.com.strevens.sga.datos;

import co.com.strevens.sga.domain.Usuario;
import java.util.List;


public interface UsuarioDao {
    public List<Usuario> findAllUsuarios();
    
    public Usuario findUsuarioById(Usuario usuario);
    
    public void insertarUsuario(Usuario usuario);
    
    public void updateUsuario(Usuario usuario);
    
    public void deleteUsuario(Usuario usuario);
}
