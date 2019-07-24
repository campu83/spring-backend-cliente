package com.aecg.springboot.backend.apirest.models.services;

import com.aecg.springboot.backend.apirest.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;

public interface IUsuarioService {

	public Usuario findByUsername(String username);

}
