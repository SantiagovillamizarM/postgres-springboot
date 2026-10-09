package com.tarea.application.auth.command;

import com.tarea.domain.auth.model.valueobject.Role;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

public record RegisterUserCommand(
        String email,
        String password,
        Role role,
        ProfessionalId professionalId
) {
}
