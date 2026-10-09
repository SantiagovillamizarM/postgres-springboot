package com.tarea.infrastructure.auth.adapters.out.persistence.mappers;

import com.tarea.domain.auth.model.entity.RefreshToken;
import com.tarea.domain.auth.model.valueobject.UserId;
import com.tarea.infrastructure.auth.adapters.out.persistence.entity.RefreshTokenJpaEntity;

public class RefreshTokenPersistenceMapper {

    public RefreshTokenJpaEntity toJpa(RefreshToken domain) {
        if (domain == null) {
            return null;
        }

        RefreshTokenJpaEntity jpa = new RefreshTokenJpaEntity();
        jpa.setId(domain.id());
        jpa.setUserId(domain.userId().value());
        jpa.setToken(domain.token());
        jpa.setExpiresAt(domain.expiresAt());
        jpa.setRevoked(domain.isRevoked());
        jpa.setCreatedAt(domain.createdAt());
        return jpa;
    }

    public RefreshToken toDomain(RefreshTokenJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return RefreshToken.restore(
                jpa.getId(),
                new UserId(jpa.getUserId()),
                jpa.getToken(),
                jpa.getExpiresAt(),
                Boolean.TRUE.equals(jpa.getRevoked()),
                jpa.getCreatedAt()
        );
    }
}
