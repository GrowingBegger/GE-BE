package org.example.ge.instrastructure.security.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtProperties jwtProperties;

    public String generateAccess (Long userId) {
        Long now = (new Date()).getTime();
        Date expireAt = new Date(jwtProperties.access_expire() + now);

        return Jwts.builder()
                .setSubject(Long.toString(userId))
                .setExpiration(expireAt)
                .signWith(SignatureAlgorithm.HS256, jwtProperties.secret())
                .compact();
    }
}
