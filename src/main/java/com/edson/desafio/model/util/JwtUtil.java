package com.edson.desafio.model.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

public class JwtUtil {

	private static final String KEY = "ET-KING";

	public static String encode(String decoded) {
		return Jwts.builder().setSubject(decoded).signWith(SignatureAlgorithm.HS256, KEY).compact();
	}

	public static boolean isValid(String token) {
		try {
			Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
			return true;
		} catch (SignatureException e) {
			return false;
		}
	}

}
