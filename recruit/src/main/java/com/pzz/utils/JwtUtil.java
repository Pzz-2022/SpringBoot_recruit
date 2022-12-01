package com.pzz.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    private static final String signature = "pz-2022";

    public static String createToken(Long uid, String name){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                // header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // payload
                .claim("uid", uid)
                .claim("username", name)
                .setExpiration(new Date(System.currentTimeMillis()+1000*5))
                .setId(UUID.randomUUID().toString())
                // signature
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        return jwtToken;
    }


    public static boolean parseToken(String token){
        String uid = null;
        try {
            JwtParser jwtParser = Jwts.parser();
            Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            uid = (String) claims.get("uid");

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
