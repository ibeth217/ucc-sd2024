package com.pacheco.ibeth.tablax.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacheco.ibeth.tablax.infraestructure.persistence.entity.UsuarioEntity;


public interface JpaUsuarioXRepository extends JpaRepository <UsuarioEntity,Long>{

}
