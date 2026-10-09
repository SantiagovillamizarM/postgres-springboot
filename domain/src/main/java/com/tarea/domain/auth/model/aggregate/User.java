package com.tarea.domain.auth.model.aggregate;

import com.tarea.domain.auth.model.valueobject.Role;
import com.tarea.domain.auth.model.valueobject.UserId;
import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;

public class User extends AggregateRoot {
    private final UserId id;
    private final String email;
    private String passwordHash;
    private final Role role;
    private final ProfessionalId professionalId;
    private final boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private User(UserId id, String email, String passwordHash, Role role, ProfessionalId professionalId,
                 boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.email = Objects.requireNonNull(email, "El email no puede ser nulo");
        this.passwordHash = Objects.requireNonNull(passwordHash, "La contraseña no puede ser nula");
        this.role = Objects.requireNonNull(role, "El rol no puede ser nulo");
        this.professionalId = professionalId;
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    // Recibe la contraseña ya hasheada: en la BD nunca se guarda la contraseña en texto plano
    public static User register(String email, String passwordHash, Role role, ProfessionalId professionalId) {
        return new User(UserId.generate(), normalizeEmail(email), passwordHash, role, professionalId,
                true, LocalDateTime.now(), null);
    }

    public static User restore(UserId id, String email, String passwordHash, Role role,
                               ProfessionalId professionalId, boolean active,
                               LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new User(id, email, passwordHash, role, professionalId, active, createdAt, updatedAt);
    }

    public void changePassword(String newPasswordHash) {
        this.passwordHash = Objects.requireNonNull(newPasswordHash, "La contraseña no puede ser nula");
        this.updatedAt = LocalDateTime.now();
    }

    public static String normalizeEmail(String email) {
        return Objects.requireNonNull(email, "El email no puede ser nulo").trim().toLowerCase();
    }

    public UserId id() { return id; }
    public String email() { return email; }
    public String passwordHash() { return passwordHash; }
    public Role role() { return role; }
    public ProfessionalId professionalId() { return professionalId; }
    public boolean isActive() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
