package com.tarea.infrastructure.auth.adapters.out.security;

import com.tarea.domain.auth.model.aggregate.User;
import com.tarea.domain.auth.port.security.TokenService;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

// Genera el access token (JWT firmado con HS256). La validación la hace Spring con el JwtDecoder de SecurityConfig.
public class JwtTokenService implements TokenService {

    private final JwtEncoder jwtEncoder;
    private final Duration accessTokenValidity;
    private final Duration refreshTokenValidity;

    public JwtTokenService(JwtEncoder jwtEncoder, Duration accessTokenValidity, Duration refreshTokenValidity) {
        this.jwtEncoder = jwtEncoder;
        this.accessTokenValidity = accessTokenValidity;
        this.refreshTokenValidity = refreshTokenValidity;
    }

    @Override
    public String generateAccessToken(User user) {
        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .subject(user.id().value().toString())
                .issuedAt(now)
                .expiresAt(now.plus(accessTokenValidity))
                .claim("email", user.email())
                .claim("roles", List.of("ROLE_" + user.role().name()))
                .build();

        JwsHeader header = JwsHeader.with(MacAlgorithm.HS256).build();
        return jwtEncoder.encode(JwtEncoderParameters.from(header, claims)).getTokenValue();
    }

    @Override
    public Duration accessTokenValidity() {
        return accessTokenValidity;
    }

    @Override
    public Duration refreshTokenValidity() {
        return refreshTokenValidity;
    }
}
