package com.aecg.springboot.backend.apirest.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	@Qualifier("authenticationManager") //Asi indicamos cual queremos cargar.
	private AuthenticationManager authenticationManager;

	// Aqui configuramos nuestros endpoints.
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		// Necesitamos una ruta publica para registrarnos y una vez validados el resto son privadas
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
		super.configure(security);
	}

	// Aqui registramos a nuestros clientes, a ser solo el cliente de angular registramos solo 1.
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		/**
		 * Cliente angular, con clave encriptada 12345, con permisos de lectura y escritura
		 * el password se refresca automaticamente y genera un token valido y otro token para refrescar el token valido
		 * ambos con una validez de una hora.
		 */
		clients.inMemory()
			.withClient("angularapp")
				.secret(passwordEncoder.encode("12345"))
				.scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token")
				.accessTokenValiditySeconds(3600)
				.refreshTokenValiditySeconds(3600);


	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		endpoints.authenticationManager(authenticationManager)
			.tokenStore(tokenStore())
			.accessTokenConverter(accessTokenConverter());
	}
	@Bean
	public TokenStore tokenStore() {
	return new JwtTokenStore((accessTokenConverter()));
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		return jwtAccessTokenConverter;
	}
}
