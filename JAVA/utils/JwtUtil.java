package com.tan00xu.blog.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * JWT工具类
 *
 * @author 饮梦 TAN00XU
 * @date 2022/10/10 12:57:08
 */
public class JwtUtil {

    /**
     * 有效期为 60 * 60 *1000  一个小时
     */
    public static final Long JWT_TTL = 60 * 60 * 1000L;
    /**
     * 秘钥明文
     */
    public static final String JWT_KEY = "TAN00XU";

    /**
     * 得到uuid
     *
     * @return {@link String}
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


    /**
     * 生成jwt
     *
     * @param subject token中要存放的数据（json格式）
     * @return {@link String}
     */
    public static String createJWT(String subject) {
        // 设置过期时间
        JwtBuilder builder = getJwtBuilder(subject, null, getUUID());
        return builder.compact();
    }


    /**
     * 生成jwt
     *
     * @param subject   token中要存放的数据（json格式）
     * @param ttlMillis token超时时间
     * @return {@link String}
     */
    public static String createJWT(String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, getUUID());
        return builder.compact();
    }


    /**
     * 生成jwt
     *
     * @param id        唯一的ID
     * @param subject   token中要存放的数据（json格式）
     * @param ttlMillis token超时时间
     * @return {@link String}
     */
    public static String createJWT(String id, String subject, Long ttlMillis) {
        JwtBuilder builder = getJwtBuilder(subject, ttlMillis, id);
        return builder.compact();
    }


    /**
     * 解析jwt
     *
     * @param jwt jwt
     * @return {@link Claims}
     */
    public static Claims parseJWT(String jwt) {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    /**
     * @param subject   token中要存放的数据（json格式）
     * @param ttlMillis token超时时间
     * @param uuid      唯一的ID
     * @return
     */
    private static JwtBuilder getJwtBuilder(String subject, Long ttlMillis, String uuid) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        return Jwts.builder()
                // 唯一的ID
                .setId(uuid)
                // 主题  可以是JSON数据
                .setSubject(subject)
                // 签发者
                .setIssuer("TAN00XU")
                // 签发时间
                .setIssuedAt(now)
                // 使用HS256对称加密算法签名, 第二个参数为秘钥
                .signWith(signatureAlgorithm, secretKey)
                // 设置过期的时间
                .setExpiration(expDate);
    }


    /**
     * 生成加密后的秘钥 secretKey
     *
     * @return {@link SecretKey}
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }


}