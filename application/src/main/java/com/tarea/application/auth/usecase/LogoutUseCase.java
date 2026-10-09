package com.tarea.application.auth.usecase;

import com.tarea.domain.auth.port.repository.RefreshTokenRepository;

public class LogoutUseCase {

    private final RefreshTokenRepository refreshTokenRepository;

    public LogoutUseCase(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    // No exige access token: así se puede cerrar sesión aunque el JWT ya haya vencido.
    // Si el token no existe no se informa, para no revelar si era válido.
    public void execute(String token) {
        refreshTokenRepository.findByToken(token).ifPresent(refreshToken -> {
            refreshToken.revoke();
            refreshTokenRepository.save(refreshToken);
        });
    }
}
