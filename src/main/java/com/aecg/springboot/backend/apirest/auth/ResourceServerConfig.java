package com.aecg.springboot.backend.apirest.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

// Aqui añadimos seguridad por el lado de OAuth
// Configuramos el acceso a los recursos del servicio, peticiones, etc.
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// Permitimos a todos el acceso al GET de la ruta exacta /api/clientes, el resto requiere autenticacion
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/clientes").permitAll()
			.anyRequest().authenticated();
	}
}
