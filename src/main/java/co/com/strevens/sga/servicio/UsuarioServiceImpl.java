
package co.com.strevens.sga.servicio;

import co.com.strevens.sga.datos.UsuarioDao;
import co.com.strevens.sga.domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UsuarioServiceImpl implements UsuarioService, UsuarioServiceRemote{
    
    //Inyectar capa de datos
    @Inject
    private UsuarioDao usuarioDao;
    
    @Override
    public List<Usuario> listarUsuario() {
        return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario encontrarUsuarioPorId(Usuario usuario) {
        return usuarioDao.findUsuarioById(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertarUsuario(usuario);
    }

    @Override
    public void modificarUsuario(Usuario usuario) {
        usuarioDao.updateUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }
    
}
