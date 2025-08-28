package com.delivery.web.config;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Component
public class JwtUtil {

	private static final String SECRET_KEY = "p1zz4-4pp";
	private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);
	
	public String create(String username) {
		return JWT.create()
				.withSubject(username)
				.withIssuer("pizza-app")
				.withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(15)))
				.sign(ALGORITHM);
	}
}
