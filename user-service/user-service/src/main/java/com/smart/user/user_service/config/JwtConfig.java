package com.smart.user.user_service.config;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;

@Configuration
public class JwtConfig {

	@Bean
	JwtEncoder jwtEncoder(
			@Qualifier("rsaPublicKey")RSAPublicKey publicKey,
			@Qualifier("rsaPrivateKey")RSAPrivateKey privateKey) {
		
			RSAKey jwk=new RSAKey.Builder(publicKey).privateKey(privateKey).build();
			return new NimbusJwtEncoder(new ImmutableJWKSet<>(new JWKSet(jwk)));
		}
	
	@Bean
	JwtDecoder jwtDecoder(@Qualifier("rsaPublicKey")RSAPublicKey publicKey) {
		return NimbusJwtDecoder.withPublicKey(publicKey).build();
	}
}
