package com.aecg.springboot.backend.apirest.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

// Aqui añadimos seguridad por el lado de OAuth
// Configuramos el acceso a los recursos del servicio, peticiones, etc.
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Override
	public void configure(HttpSecurity http) throws Exception {
		// Permitimos a todos el acceso al GET de la ruta exacta /api/clientes, el resto requiere autenticacion
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/clientes", "/api/clientes/page/**", "/api/uploads/img/**", "/images/**").permitAll()
		//.antMatchers("/api/clientes/{id}").permitAll()
		//.antMatchers("/api/facturas/**").permitAll()
			/* Quitamos este modo para incluirlo como anotaciones, no obstante necesitamos tenerlo incluido los que se permiten a todos.
			.antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER", "ADMIN")
			.antMatchers(HttpMethod.POST, "/api/clientes/**").hasRole("ADMIN")
			.antMatchers("/api/clientes/**").hasRole("ADMIN")*/
			.anyRequest().authenticated()
			.and().cors().configurationSource(corsConfigurationSource()); //Añadimos el cors configurado
	}
	
	//Configuramos el cors para permitir el acceso al frontend
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200", "*"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		
		return source;
	}
	
	//Creamos un filtro para Cors y le aplicamos la prioridad más alta.
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
