package com.pzz.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

public class JwtUtil {
    private static final String SIGNATURE = "pz-2022";
    private static final long MIN_TIME = 1000L * 60;
    private static final long HOUR_TIME = MIN_TIME * 60;
    private static final long DAY_TIME = HOUR_TIME * 24;
    private static final long TIME_Expiration = HOUR_TIME;

    public static String createToken(Long uid, String name){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                // header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                // payload
                .claim("uid", uid)
                .claim("username", name)
                .setExpiration(new Date(System.currentTimeMillis() + TIME_Expiration))
                .setId(UUID.randomUUID().toString())
                // signature
                .signWith(SignatureAlgorithm.HS256, SIGNATURE)
                .compact();
        return jwtToken;
    }


    public static boolean parseToken(String token){
        String uid = null;
        try {
            JwtParser jwtParser = Jwts.parser();
            Jws<Claims> claimsJws = jwtParser.setSigningKey(SIGNATURE).parseClaimsJws(token);
            Claims claims = claimsJws.getBody();
            uid = (String) claims.get("uid");

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // 强行拿用户id
    public static Integer parseTokenToGetUid(String token){
        Integer uid = null;
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(SIGNATURE).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        uid = (Integer) claims.get("uid");
        return uid;
    }

}
