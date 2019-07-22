package com.aecg.springboot.backend.apirest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService usuarioService;

	// El Autowired es porque tenemos que inyectar como método
	// AuthenticationManagerBuilder auth
	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(passwordEncoder());
	}

	//Esta anotación es para devolver objetos que retornan métodos.
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean("authenticationManager") //para garantizar que el autowired devuelve este bean le ponemos nombre
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	// Añadimos este método para incluir seguridad por el lado de Spring
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// Permitimos a todos el acceso a los Get de /api/clientes, el resto requiere autenticacion
		http.authorizeRequests()
			.anyRequest().authenticated() //Cualquier petición requiere autenticación
			.and()
			.csrf().disable()// Si el formulario fuera de spring en lugar de angular no lo desactivaríamos
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//Definimos la sesion sin estado (REST).
	}
}
