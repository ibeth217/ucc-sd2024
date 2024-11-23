package com.pacheco.ibeth.tablay.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.pacheco.ibeth.tablay.domain.model.Usuario;
import com.pacheco.ibeth.tablay.infraestructure.persistence.entity.UsuarioEntity;


@Mapper
public interface IMapper {
	
	@Mapping(target = "id")
	public abstract UsuarioEntity usuarioConvertToEntity(Usuario usuario); 
	
	@Mapping(target = "id")
	public abstract Usuario usuarioConvertToDomain(UsuarioEntity usuarioEntity); 

}
