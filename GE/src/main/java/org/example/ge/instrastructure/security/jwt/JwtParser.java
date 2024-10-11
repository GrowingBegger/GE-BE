package org.example.ge.instrastructure.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.ge.instrastructure.security.auth.CustomUserDetailService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
@RequiredArgsConstructor
public class JwtParser {
    private final JwtProperties jwtProperties;
    private final CustomUserDetailService customUserDetailService;

    public String getHeader(HttpServletRequest req) {
        String token = req.getHeader(jwtProperties.header());

        if (StringUtils.hasText(token) && token.startsWith(jwtProperties.prefix()) && token.length() > 7) {
            token = token.split(" ")[0];
        }

        return token;
    }

    public Authentication getAuthentication (String token) {
        Claims claims = getClaims(token);
        UserDetails userDetails = customUserDetailService.loadUserByUsername(claims.getSubject());
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public Claims getClaims (String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(jwtProperties.secret())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
