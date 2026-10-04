package com.tarea.infrastructure.professional.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateProfessionalRequest(
        @NotNull(message = "El tipo de documento es obligatorio")
        UUID documentTypeId,

        @NotBlank(message = "El número de documento no puede estar vacío")
        @Size(max = 30, message = "El número de documento no puede superar los 30 caracteres")
        String documentNumber,

        @Size(max = 60, message = "El nombre no puede superar los 60 caracteres")
        String firstName,

        @Size(max = 60, message = "El apellido no puede superar los 60 caracteres")
        String lastName,

        @NotNull(message = "El tipo de profesional es obligatorio")
        UUID professionalTypeId,

        @NotBlank(message = "El número de licencia no puede estar vacío")
        @Size(max = 100, message = "El número de licencia no puede superar los 100 caracteres")
        String licenseNumber,

        Boolean active,

        @NotNull(message = "La ciudad es obligatoria")
        UUID cityId
) {
}
