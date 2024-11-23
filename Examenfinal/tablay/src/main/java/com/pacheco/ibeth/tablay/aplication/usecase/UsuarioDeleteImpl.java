package com.pacheco.ibeth.tablay.aplication.usecase;

import org.springframework.stereotype.Service;

import com.pacheco.ibeth.tablay.domain.port.in.UsuarioDelete;
import com.pacheco.ibeth.tablay.domain.port.out.UserRepositoryPort;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class UsuarioDeleteImpl implements UsuarioDelete {
    
    private final UserRepositoryPort usuarioRepository;	

    @Override
    public boolean deleteUsuario(Long id) {
        // TODO Auto-generated method stub
       return usuarioRepository.eliminarUsuario(id);
    }	

}


