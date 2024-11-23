package com.pacheco.ibeth.tablax.domain.port.out;

import java.util.List;
import java.util.Optional;

import com.pacheco.ibeth.tablax.domain.model.Usuario;

public interface UserRepositoryPort {
	
	List<Usuario> obtenerTodosLosUsuarios();
	Optional<Usuario> obtenerUsuarioPorId(Long id);
    Usuario crearUsuario(Usuario usuario);
    Optional<Usuario> actualizarUsuario(Long id,Usuario usuario);
    boolean eliminarUsuario(Long id);

}
