package com.pacheco.ibeth.tablay.aplication.usecase;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pacheco.ibeth.tablay.domain.model.Usuario;
import com.pacheco.ibeth.tablay.domain.port.in.UsuarioList;
import com.pacheco.ibeth.tablay.domain.port.out.UserRepositoryPort;

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
