package com.pacheco.ibeth.tablay.aplication.usecase;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.pacheco.ibeth.tablay.domain.exception.UserNotFoundException;
import com.pacheco.ibeth.tablay.domain.model.Usuario;
import com.pacheco.ibeth.tablay.domain.port.in.UsuarioUpdate;
import com.pacheco.ibeth.tablay.domain.port.out.UserRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class UsuarioUpdateImpl implements UsuarioUpdate {

	private final UserRepositoryPort usuarioRepository;

	@Override
	public Usuario updateUsuario(Long id, Usuario usuario) {
	   
	      return usuarioRepository.obtenerUsuarioPorId(id)
	    		  .map(existingUsuario->{
        			  existingUsuario.setNombre(usuario.getNombre());
        			  existingUsuario.setEmail(usuario.getEmail());
        			  
        			  return usuarioRepository.crearUsuario( existingUsuario);
        		  }).orElseThrow(()-> new UserNotFoundException(id));
	        
	}


}