package com.pacheco.ibeth.tablay.infraestructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pacheco.ibeth.tablay.infraestructure.persistence.entity.UsuarioEntity;


public interface JpaUsuarioXRepository extends JpaRepository <UsuarioEntity,Long>{

}
