package com.example.EmployeeMM.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JWTUtil {

    private final long EXPIRATION_TIME = 1000*60*60; // 1 hour
    private final String SECRET =  "my-super-secret-key-that-is-long-enough-1234567890!@#";
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());


    public String generateToken(String username){

     return  Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
//        return "jwt";
    }


    public String extractUsername(String token){

        return extractClamins(token).getSubject();
    }

    private Claims extractClamins(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String username, UserDetails userDetails, String token) {

//        TODO - check if username is same as username in userDetails
//        TODO - check of token is not expired

        System.out.println("Userdetails:" + userDetails.getUsername());
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);

    }

    private boolean isTokenExpired(String token) {

        return extractClamins(token).getExpiration().before(new Date());

    }
}
