package com.pacheco.ibeth.tablax.infraestructure.persistence.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.pacheco.ibeth.tablax.domain.model.Usuario;
import com.pacheco.ibeth.tablax.domain.port.out.UserRepositoryPort;
import com.pacheco.ibeth.tablax.infraestructure.persistence.entity.UsuarioEntity;
import com.pacheco.ibeth.tablax.utils.IMapper;

@Component
@Primary
public class JpaUsuarioRepositoryAdapter implements UserRepositoryPort {
	
	@Autowired
	private JpaUsuarioXRepository jpaUsuarioRepository;
	
	private final IMapper mapper= Mappers.getMapper(IMapper.class);
	
	// Constructor para inyección de dependencia
    public JpaUsuarioRepositoryAdapter(JpaUsuarioXRepository jpaUsuarioRepository) {
        this.jpaUsuarioRepository = jpaUsuarioRepository;
    }

	@Override
	public List<Usuario> obtenerTodosLosUsuarios() {
		// TODO Auto-generated method stub
		return jpaUsuarioRepository
				.findAll()
				.stream()
                .map(mapper::usuarioConvertToDomain)
                .collect(Collectors.toList());
	}

	@Override
	public Optional<Usuario> obtenerUsuarioPorId(Long id) {
		// TODO Auto-generated method stub
		return Optional.of(jpaUsuarioRepository.findById(id).map(mapper::usuarioConvertToDomain).orElse(null));
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		UsuarioEntity usuarioEntity = mapper.usuarioConvertToEntity(usuario);
		usuarioEntity = jpaUsuarioRepository.save(usuarioEntity);
		return mapper.usuarioConvertToDomain(usuarioEntity);
	}

	@Override
	public Optional<Usuario> actualizarUsuario(Long id, Usuario usuario) {
		// TODO Auto-generated method stub
		if (jpaUsuarioRepository.existsById(id)) {
			UsuarioEntity entityToUpdate = mapper.usuarioConvertToEntity(usuario);
			UsuarioEntity updatedEntity = jpaUsuarioRepository.save(entityToUpdate);
			return Optional.of(mapper.usuarioConvertToDomain(updatedEntity));
		}
		return Optional.empty();
	}

	@Override
	public boolean eliminarUsuario(Long id) {
		if(jpaUsuarioRepository.existsById(id)){
			jpaUsuarioRepository.deleteById(id);
			return true;
			}
		else {
			return false;
		}
	}
}
