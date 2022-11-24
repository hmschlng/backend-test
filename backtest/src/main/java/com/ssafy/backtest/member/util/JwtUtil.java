package com.ssafy.backtest.member.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.google.common.base.Charsets;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	private static String SALT;
	
	public JwtUtil() throws Exception {
		BufferedReader br;
		br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\..\\account.dat"));
		br.readLine();
        br.readLine();
        SALT = br.readLine();
        br.close();
	}
	
	public static <T> String create(String emailId) throws Exception {
		Date expiry = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
		return Jwts.builder()
				.claim("emailId", emailId) // 데이터
				.setIssuer("sobang") // 토큰 발행인
				.setIssuedAt(new Date()) // 토큰 발행시각
				.setExpiration(expiry) // 토큰 만료 기한
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes(Charsets.UTF_8))
				.compact();
	}
	
	public static boolean isValid(String token) {
		try {
			Jwts.parser().setSigningKey(SALT.getBytes(Charsets.UTF_8)).parseClaimsJws(token);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	public static String getUserId(String token, String key) {
		return (String) Jwts.parser().setSigningKey(SALT).parseClaimsJws(token).getBody().get(key);
	}
}
