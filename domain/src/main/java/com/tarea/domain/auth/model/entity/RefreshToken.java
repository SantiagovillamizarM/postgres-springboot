package com.tarea.domain.auth.model.entity;

import com.tarea.domain.auth.model.valueobject.UserId;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class RefreshToken {
    private final UUID id;
    private final UserId userId;
    private final String token;
    private final LocalDateTime expiresAt;
    private boolean revoked;
    private final LocalDateTime createdAt;

    private RefreshToken(UUID id, UserId userId, String token, LocalDateTime expiresAt,
                         boolean revoked, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.userId = Objects.requireNonNull(userId, "El usuario no puede ser nulo");
        this.token = Objects.requireNonNull(token, "El token no puede ser nulo");
        this.expiresAt = Objects.requireNonNull(expiresAt, "La expiración no puede ser nula");
        this.revoked = revoked;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
    }

    // Es un valor aleatorio (no un JWT): solo sirve si existe en la BD y no está revocado ni vencido
    public static RefreshToken issue(UserId userId, Duration validity) {
        LocalDateTime now = LocalDateTime.now();
        String token = UUID.randomUUID() + "-" + UUID.randomUUID();
        return new RefreshToken(UUID.randomUUID(), userId, token, now.plus(validity), false, now);
    }

    public static RefreshToken restore(UUID id, UserId userId, String token, LocalDateTime expiresAt,
                                       boolean revoked, LocalDateTime createdAt) {
        return new RefreshToken(id, userId, token, expiresAt, revoked, createdAt);
    }

    public boolean isUsable() {
        return !revoked && expiresAt.isAfter(LocalDateTime.now());
    }

    public void revoke() {
        this.revoked = true;
    }

    public UUID id() { return id; }
    public UserId userId() { return userId; }
    public String token() { return token; }
    public LocalDateTime expiresAt() { return expiresAt; }
    public boolean isRevoked() { return revoked; }
    public LocalDateTime createdAt() { return createdAt; }
}
