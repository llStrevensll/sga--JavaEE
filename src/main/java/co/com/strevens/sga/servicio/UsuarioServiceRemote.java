
package co.com.strevens.sga.servicio;

import co.com.strevens.sga.domain.Usuario;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface UsuarioServiceRemote {
    public List<Usuario> listarUsuario();
    public Usuario encontrarUsuarioPorId(Usuario persona);
    public void registrarUsuario(Usuario persona);
    public void modificarUsuario(Usuario persona);
    public void eliminarUsuario(Usuario persona);
}
