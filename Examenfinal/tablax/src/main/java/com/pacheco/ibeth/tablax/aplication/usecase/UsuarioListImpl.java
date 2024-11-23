package com.pacheco.ibeth.tablax.aplication.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pacheco.ibeth.tablax.domain.model.Usuario;
import com.pacheco.ibeth.tablax.domain.port.in.UsuarioList;
import com.pacheco.ibeth.tablax.domain.port.out.UserRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class UsuarioListImpl  implements UsuarioList{
	
	private final UserRepositoryPort usuarioRepository;

	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.obtenerTodosLosUsuarios();
	}

}
