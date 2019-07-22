package com.aecg.springboot.backend.apirest.models.dao;

import com.aecg.springboot.backend.apirest.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
	//Caso 1. Usando las palabras resesvadas find, by variable,
	// provocamos un select por ese campo. En el caso de querer más campos usamos el And.
	public Usuario findByUsername(String username);

	//Caso 2. Es la misma consulta que en el caso 1 pero en esta ocasion usamos la anotación
	//Query, en este caso da igual el nombre del método.
	@Query("Select u from Usuario u where u.username=?1")
	public Usuario findByUsername2(String username);
}
