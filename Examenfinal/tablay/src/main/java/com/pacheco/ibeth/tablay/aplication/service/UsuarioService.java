package com.pacheco.ibeth.tablay.aplication.service;


import java.util.List;
import java.util.Optional;

import com.pacheco.ibeth.tablay.aplication.usecase.UsuarioByIdImpl;
import com.pacheco.ibeth.tablay.aplication.usecase.UsuarioCreateImpl;
import com.pacheco.ibeth.tablay.aplication.usecase.UsuarioDeleteImpl;
import com.pacheco.ibeth.tablay.aplication.usecase.UsuarioListImpl;
import com.pacheco.ibeth.tablay.domain.model.Usuario;
import com.pacheco.ibeth.tablay.domain.port.in.UsuarioById;
import com.pacheco.ibeth.tablay.domain.port.in.UsuarioCreate;
import com.pacheco.ibeth.tablay.domain.port.in.UsuarioDelete;
import com.pacheco.ibeth.tablay.domain.port.in.UsuarioList;
import com.pacheco.ibeth.tablay.domain.port.in.UsuarioUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UsuarioService implements UsuarioCreate, UsuarioById, UsuarioUpdate, UsuarioDelete, UsuarioList{

	private final UsuarioCreate usuarioCreate;
	private final UsuarioById usuarioById;
	private final UsuarioUpdate usuarioUpdate;
	private final UsuarioDelete usuarioDelete;
	private final UsuarioList usuarioList;

	

	@Override
	public Optional<Usuario> getUsuarioById(Long id) {
		// TODO Auto-generated method stub
		return usuarioById.getUsuarioById(id);
	}

	@Override
	public Usuario createUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioCreate.createUsuario(usuario);
	}

	@Override
	public Usuario updateUsuario(Long id, Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioUpdate.updateUsuario(id, usuario);
	}

	@Override
	public List<Usuario> getAllUsuarios() {
		// TODO Auto-generated method stub
		return usuarioList.getAllUsuarios()	;
	}

	@Override
	public boolean deleteUsuario(Long id) {
		// TODO Auto-generated method stub
		return usuarioDelete.deleteUsuario(id);
	}
}
