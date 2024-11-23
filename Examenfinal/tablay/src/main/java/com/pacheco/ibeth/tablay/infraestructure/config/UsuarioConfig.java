package com.pacheco.ibeth.tablay.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pacheco.ibeth.tablay.aplication.service.UsuarioService;
import com.pacheco.ibeth.tablay.aplication.usecase.UsuarioByIdImpl;
import com.pacheco.ibeth.tablay.aplication.usecase.UsuarioCreateImpl;
import com.pacheco.ibeth.tablay.aplication.usecase.UsuarioDeleteImpl;
import com.pacheco.ibeth.tablay.aplication.usecase.UsuarioListImpl;
import com.pacheco.ibeth.tablay.aplication.usecase.UsuarioUpdateImpl;
import com.pacheco.ibeth.tablay.domain.port.out.UserRepositoryPort;
import com.pacheco.ibeth.tablay.infraestructure.persistence.repository.JpaUsuarioRepositoryAdapter;
import com.pacheco.ibeth.tablay.infraestructure.persistence.repository.JpaUsuarioXRepository;

@Configuration
public class UsuarioConfig {
	
	@Bean
	public UsuarioService usuarioService(UserRepositoryPort usuarioRepositoryPort) {
		return new UsuarioService(
				new UsuarioCreateImpl(usuarioRepositoryPort),
                new UsuarioByIdImpl(usuarioRepositoryPort),
                new UsuarioUpdateImpl(usuarioRepositoryPort),
                new UsuarioDeleteImpl(usuarioRepositoryPort),
                new UsuarioListImpl(usuarioRepositoryPort));
	}
	
	@Bean
    public UserRepositoryPort usuarioRepositoryPort(JpaUsuarioRepositoryAdapter jpaUsuarioRepositoryAdapter) {
        return jpaUsuarioRepositoryAdapter;
    }
	
	
}
