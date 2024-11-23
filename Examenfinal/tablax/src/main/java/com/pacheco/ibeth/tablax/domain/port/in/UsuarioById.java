package com.pacheco.ibeth.tablax.domain.port.in;

import java.util.Optional;

import com.pacheco.ibeth.tablax.domain.model.Usuario;

public interface UsuarioById {
	
	Optional<Usuario> getUsuarioById(Long id);

}
