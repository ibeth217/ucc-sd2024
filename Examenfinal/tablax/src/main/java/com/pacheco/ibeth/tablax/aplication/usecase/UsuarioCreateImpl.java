package com.pacheco.ibeth.tablax.aplication.usecase;

import org.springframework.stereotype.Service;

import com.pacheco.ibeth.tablax.domain.model.Usuario;
import com.pacheco.ibeth.tablax.domain.port.in.UsuarioCreate;
import com.pacheco.ibeth.tablax.domain.port.out.UserRepositoryPort;

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
