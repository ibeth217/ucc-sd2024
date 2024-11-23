package com.pacheco.ibeth.tablay.domain.port.in;

import java.util.Optional;

import com.pacheco.ibeth.tablay.domain.model.Usuario;

public interface UsuarioById {
	
	Optional<Usuario> getUsuarioById(Long id);

}
