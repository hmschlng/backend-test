import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
 
public class Test
{
    public static void main(String[] args) throws Exception
    {
    	
        
        
//    	String jwt = Jwts.builder()
//		// header에 들어갈 내용 및 서명을 하기 위한 SECRET_KEY
//		.signWith(SignatureAlgorithm.HS512, "sobangZZANGZZANG")
//		// payload에 들어갈 내용
//		.claim("emailId", "soulb9@naver.com")
//		.setIssuer("sobang.com") // iss
//		.setIssuedAt(new Date()) // iat
//		.setExpiration(Date.from(Instant.now().plus(1, ChronoUnit.HOURS))) // exp
//		.compact();
////    	String SALT = "sobangZZANGZZANG";
////    	
////		String jwt = Jwts.builder().setHeaderParam("typ", "JWT").setHeaderParam("regDate", System.currentTimeMillis())
////				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
////				.setSubject("access-token").claim("emailId", "soulb9@naver.com").signWith(SignatureAlgorithm.HS256, SALT.getBytes(Charsets.UTF_8)).compact();
//    	System.out.println(jwt);
//    	Claims claims = Jwts.parser().setSigningKey("sobangZZANGZZANG").parseClaimsJws(jwt).getBody();
//    	System.out.println(claims.get("emailId"));
    }
}
/*
 * eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzb3VsYjlAbmF2ZXIuY29tIiwiaXNzIjoic29iYW5nLmNvbSIsImlhdCI6MTY2OTIxNTEwMCwiZXhwIjoxNjY5MjE4NzAwfQ.7Nl35dYd63BlFAI7XxMtxnEvM79LJ1sGKHhJpbPgKuTw5KwgRzu_0MwrkcRZryeN_NMGxPAV4mGnYt1Lx8n9-A
 *
 * eyJ0eXAiOiJKV1QiLCJyZWdEYXRlIjoxNjY5MjE1MDM1MzM2LCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2NjkyMTg2MzUsInN1YiI6ImFjY2Vzcy10b2tlbiIsImVtYWlsSWQiOiJzb3VsYjlAbmF2ZXIuY29tIn0.g1npK5cr2PlZwFtyxnV7ttIDC9ve1hrecOOkg9-hnPA
*/
