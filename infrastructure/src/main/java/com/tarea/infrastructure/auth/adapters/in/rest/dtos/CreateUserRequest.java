package com.tarea.infrastructure.auth.adapters.in.rest.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateUserRequest(
        @NotBlank(message = "El email no puede estar vacío")
        @Email(message = "El email no tiene un formato válido")
        @Size(max = 150, message = "El email no puede superar los 150 caracteres")
        String email,

        // BCrypt solo usa los primeros 72 bytes
        @NotBlank(message = "La contraseña no puede estar vacía")
        @Size(min = 8, max = 72, message = "La contraseña debe tener entre 8 y 72 caracteres")
        String password,

        @NotBlank(message = "El rol no puede estar vacío")
        @Pattern(regexp = "ADMIN|PROFESSIONAL", message = "El rol debe ser ADMIN o PROFESSIONAL")
        String role,

        UUID professionalId
) {
}
