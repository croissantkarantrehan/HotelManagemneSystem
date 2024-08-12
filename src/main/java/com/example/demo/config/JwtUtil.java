package com.example.demo.config;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtil {
	

	
	//retrieve username from jwt token
	
		public String getUsernameFromToken(String token) {
			return  getClaimFromToken(token, Claims::getSubject);

			
		}

		//retrieve expiration date from jwt token
		public Date getExpirationDateFromToken(String token) {
			return getClaimFromToken(token, Claims::getExpiration);
		}

		public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
			final Claims claims = getAllClaimsFromToken(token);
//			System.out.println(claims);
			return claimsResolver.apply(claims);
		}
	    //for retrieveing any information from token we will need the secret key
		private Claims getAllClaimsFromToken(String token) {
//			return  Jwts.parser().setSigningKey(secret).build().parse(token);
//			return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			return Jwts.parserBuilder().setSigningKey(getSignInKey()).build().parseClaimsJws(token)
	                .getBody();
		}

	

		//check if the token has expired
		private Boolean isTokenExpired(String token) {
			final Date expiration = getExpirationDateFromToken(token);
			return expiration.before(new Date());
		}

	public String GenerateToken(String userName)
	{
		Map<String,Object> claim=new HashMap<>();
		
		
		return CreateToken(claim,userName);
		
	}

	String secret="28582B3AA46CC26FAF508ADBCB00A6745095D03C4C78FF3F0B115CDF0A2CD4F3";
	private String CreateToken(Map<String, Object> claim, String userName) {
		// TODO Auto-generated method stub
		return Jwts.builder()
		.addClaims(claim)
		.setIssuedAt(new Date(System.currentTimeMillis()))
		.setSubject(userName)
		.setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
		.signWith(SignatureAlgorithm.HS256,getSignInKey()).compact();  
		
		

	}
	
	private Key getSignInKey() {
	    byte[] keyBytes = Decoders.BASE64.decode(secret);
	 

	    return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	



}
