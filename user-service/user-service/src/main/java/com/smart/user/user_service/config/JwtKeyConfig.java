package com.smart.user.user_service.config;

import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.security.converter.RsaKeyConverters;


@Configuration
public class JwtKeyConfig {

	@Value("${jwt.public.key}")
	private Resource publicKey;
	
	@Value("${jwt.private.key}")
	private Resource privateKey;
	
	@Bean(name="rsaPublicKey")
	public RSAPublicKey rsaPublicKey() throws Exception{
//		return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(publicKey.getInputStream().readAllBytes()));
		return RsaKeyConverters.x509().convert(publicKey.getInputStream());
	}
	
	@Bean(name="rsaPrivateKey")
	public RSAPrivateKey rsaPrivateKey() throws Exception {
//		return (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKey.getInputStream().readAllBytes()));
		return RsaKeyConverters.pkcs8().convert(privateKey.getInputStream());
	}
	
}
