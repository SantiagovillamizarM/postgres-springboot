package com.tarea.application.auth.usecase;

import com.tarea.application.auth.dto.AuthResponse;
import com.tarea.domain.auth.model.aggregate.User;
import com.tarea.domain.auth.model.entity.RefreshToken;
import com.tarea.domain.auth.port.repository.RefreshTokenRepository;
import com.tarea.domain.auth.port.security.TokenService;

// Lo comparten Login y Refresh: crea el access token (JWT) y guarda un refresh token nuevo
public class TokenIssuer {

    private final TokenService tokenService;
    private final RefreshTokenRepository refreshTokenRepository;

    public TokenIssuer(TokenService tokenService, RefreshTokenRepository refreshTokenRepository) {
        this.tokenService = tokenService;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public AuthResponse issue(User user) {
        String accessToken = tokenService.generateAccessToken(user);
        RefreshToken refreshToken = refreshTokenRepository.save(
                RefreshToken.issue(user.id(), tokenService.refreshTokenValidity()));

        return new AuthResponse(
                accessToken,
                refreshToken.token(),
                "Bearer",
                tokenService.accessTokenValidity().toSeconds()
        );
    }
}
