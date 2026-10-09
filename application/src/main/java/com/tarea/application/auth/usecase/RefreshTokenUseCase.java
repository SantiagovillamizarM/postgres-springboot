package com.tarea.application.auth.usecase;

import com.tarea.application.auth.dto.AuthResponse;
import com.tarea.application.auth.exception.InvalidRefreshTokenApplicationException;
import com.tarea.domain.auth.model.aggregate.User;
import com.tarea.domain.auth.model.entity.RefreshToken;
import com.tarea.domain.auth.port.repository.RefreshTokenRepository;
import com.tarea.domain.auth.port.repository.UserRepository;

public class RefreshTokenUseCase {

    private final RefreshTokenRepository refreshTokenRepository;
    private final UserRepository userRepository;
    private final TokenIssuer tokenIssuer;

    public RefreshTokenUseCase(RefreshTokenRepository refreshTokenRepository, UserRepository userRepository,
                               TokenIssuer tokenIssuer) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userRepository = userRepository;
        this.tokenIssuer = tokenIssuer;
    }

    // Rotación: el refresh token usado se revoca y se entrega uno nuevo
    public AuthResponse execute(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token)
                .filter(RefreshToken::isUsable)
                .orElseThrow(InvalidRefreshTokenApplicationException::new);

        User user = userRepository.findById(refreshToken.userId())
                .filter(User::isActive)
                .orElseThrow(InvalidRefreshTokenApplicationException::new);

        refreshToken.revoke();
        refreshTokenRepository.save(refreshToken);

        return tokenIssuer.issue(user);
    }
}
