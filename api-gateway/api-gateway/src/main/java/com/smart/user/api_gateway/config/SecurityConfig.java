package com.smart.user.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {
	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http
			.csrf(csrf->csrf.disable())
			.authorizeExchange(ex -> ex
				    .pathMatchers(
				        "/auth/login",
				        "/auth/register"
				    ).permitAll()
				    .anyExchange().authenticated())
			.oauth2ResourceServer(oauth2->oauth2.jwt(Customizer.withDefaults()));
		return http.build();
	}

}
