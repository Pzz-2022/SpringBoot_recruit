package com.pzz.utils;

import io.jsonwebtoken.*;

import java.security.MessageDigest;
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

    // MD5
    public static String getMD5(String str) throws Exception {

        StringBuilder MD5 = new StringBuilder();

        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = str.getBytes();
        byte[] digest = md5.digest(bytes);

        for (int b : digest) {
            //摘要字节数组中各个字节的"十六进制"形式.
            int j = b;
            j = j & 0x000000ff;
            String s1 = Integer.toHexString(j);

            if (s1.length() == 1) {
                s1 = "0" + s1;
            }
            MD5.append(s1);
        }
        return MD5.toString();
    }
}
