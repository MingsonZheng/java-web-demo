package com.zzm;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@SpringBootTest
class ZzmWebManagementApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testUuid() {
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    /**
     * ����JWT
     */
    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "zzmzzm")
                .setClaims(claims)// �Զ�������(�غ�)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))// ������Ч��Ϊ1h
                .compact();
        System.out.println(jwt);
    }

    /**
     * ����JWT
     */
    @Test
    public void testParseJwt() {
        Claims claims = Jwts.parser()
                .setSigningKey("zzmzzm")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoidG9tIiwiaWQiOjEsImV4cCI6MTcwNTc3ODUyOX0.qPN8OfzXC8ftdRFSX2DJ4N-Gn0B_L1q6gf-CIpRYwNs")
                .getBody();
        System.out.println(claims);
    }
}
