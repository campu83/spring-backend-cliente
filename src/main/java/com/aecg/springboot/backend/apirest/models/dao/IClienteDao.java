package com.aecg.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

import com.aecg.springboot.backend.apirest.models.entity.Cliente;

// Quitamos el crudRepository para heredar del jpaRepository que contiene la paginación
//public interface IClienteDao extends CrudRepository<Cliente, Long>{}
public interface IClienteDao extends JpaRepository<Cliente, Long>{}

