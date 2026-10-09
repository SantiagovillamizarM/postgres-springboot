package com.tarea.domain.auth.port.repository;

import com.tarea.domain.auth.model.entity.RefreshToken;
import com.tarea.domain.auth.model.valueobject.UserId;

import java.util.Optional;

public interface RefreshTokenRepository {
    RefreshToken save(RefreshToken refreshToken);
    Optional<RefreshToken> findByToken(String token);
    void revokeAllByUserId(UserId userId);
}
