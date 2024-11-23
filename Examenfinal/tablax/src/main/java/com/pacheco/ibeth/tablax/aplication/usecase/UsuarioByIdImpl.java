package com.pacheco.ibeth.tablax.aplication.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pacheco.ibeth.tablax.domain.model.Usuario;
import com.pacheco.ibeth.tablax.domain.port.in.UsuarioById;
import com.pacheco.ibeth.tablax.domain.port.out.UserRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Service
public class UsuarioByIdImpl implements UsuarioById {
	
	private UserRepositoryPort usuarioRepositoryPort;

	@Override
	public Optional<Usuario> getUsuarioById(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepositoryPort.obtenerUsuarioPorId(id);
	}	

}
