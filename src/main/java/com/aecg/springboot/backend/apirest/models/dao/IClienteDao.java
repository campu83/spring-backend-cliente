package com.aecg.springboot.backend.apirest.models.dao;

import com.aecg.springboot.backend.apirest.models.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

import com.aecg.springboot.backend.apirest.models.entity.Cliente;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Quitamos el crudRepository para heredar del jpaRepository que contiene la paginación
//public interface IClienteDao extends CrudRepository<Cliente, Long>{}
public interface IClienteDao extends JpaRepository<Cliente, Long>{

	// Como solo queremos recuperar las regiones a partir del cliente añadimos el método aqui en lugar de crear
	// su propio Dao, añadimos el decorador @Query para definir de donde obtendremos el valor.
	@Query("from Region")
	public List<Region> findAllRegiones();
}



