package com.tarea.infrastructure.auth.adapters.out.persistence.repositories;

import com.tarea.domain.auth.model.entity.RefreshToken;
import com.tarea.domain.auth.model.valueobject.UserId;
import com.tarea.domain.auth.port.repository.RefreshTokenRepository;
import com.tarea.infrastructure.auth.adapters.out.persistence.entity.RefreshTokenJpaEntity;
import com.tarea.infrastructure.auth.adapters.out.persistence.mappers.RefreshTokenPersistenceMapper;

import java.util.Optional;

public class RefreshTokenRepositoryAdapter implements RefreshTokenRepository {

    private final RefreshTokenJpaRepository refreshTokenJpaRepository;
    private final RefreshTokenPersistenceMapper mapper;

    public RefreshTokenRepositoryAdapter(RefreshTokenJpaRepository refreshTokenJpaRepository,
                                         RefreshTokenPersistenceMapper mapper) {
        this.refreshTokenJpaRepository = refreshTokenJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public RefreshToken save(RefreshToken refreshToken) {
        RefreshTokenJpaEntity entity = mapper.toJpa(refreshToken);
        RefreshTokenJpaEntity saved = refreshTokenJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenJpaRepository.findByToken(token)
                .map(mapper::toDomain);
    }

    @Override
    public void revokeAllByUserId(UserId userId) {
        refreshTokenJpaRepository.revokeAllByUserId(userId.value());
    }
}
