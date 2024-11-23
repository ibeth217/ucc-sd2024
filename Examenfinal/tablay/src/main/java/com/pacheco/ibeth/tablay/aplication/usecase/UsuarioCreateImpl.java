package com.pacheco.ibeth.tablay.aplication.usecase;

import org.springframework.stereotype.Service;

import com.pacheco.ibeth.tablay.domain.model.Usuario;
import com.pacheco.ibeth.tablay.domain.port.in.UsuarioCreate;
import com.pacheco.ibeth.tablay.domain.port.out.UserRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class UsuarioCreateImpl implements UsuarioCreate {
	
	private final UserRepositoryPort usuarioRepository;	

	@Override
	public Usuario createUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.crearUsuario(usuario);
	}	

}
