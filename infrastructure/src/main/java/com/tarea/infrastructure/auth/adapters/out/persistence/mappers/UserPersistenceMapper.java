package com.tarea.infrastructure.auth.adapters.out.persistence.mappers;

import com.tarea.domain.auth.model.aggregate.User;
import com.tarea.domain.auth.model.valueobject.Role;
import com.tarea.domain.auth.model.valueobject.UserId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.infrastructure.auth.adapters.out.persistence.entity.UserJpaEntity;

public class UserPersistenceMapper {

    public UserJpaEntity toJpa(User domain) {
        if (domain == null) {
            return null;
        }

        UserJpaEntity jpa = new UserJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setEmail(domain.email());
        jpa.setPasswordHash(domain.passwordHash());
        jpa.setRole(domain.role().name());
        jpa.setProfessionalId(domain.professionalId() != null ? domain.professionalId().value() : null);
        jpa.setActive(domain.isActive());
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public User toDomain(UserJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return User.restore(
                new UserId(jpa.getId()),
                jpa.getEmail(),
                jpa.getPasswordHash(),
                Role.valueOf(jpa.getRole()),
                jpa.getProfessionalId() != null ? new ProfessionalId(jpa.getProfessionalId()) : null,
                jpa.getActive() != null ? jpa.getActive() : true,
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
