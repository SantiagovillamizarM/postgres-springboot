package com.tarea.application.auth.dto;

import com.tarea.domain.auth.model.aggregate.User;

import java.time.LocalDateTime;
import java.util.UUID;

// Nunca incluye el hash de la contraseña
public record UserResponse(
        UUID id,
        String email,
        String role,
        UUID professionalId,
        boolean active,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.id().value(),
                user.email(),
                user.role().name(),
                user.professionalId() != null ? user.professionalId().value() : null,
                user.isActive(),
                user.createdAt(),
                user.updatedAt()
        );
    }
}
