package com.tarea.infrastructure.patient.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record CreatePatientRequest(
        @NotNull(message = "El tipo de documento es obligatorio")
        UUID documentTypeId,

        @Size(max = 30, message = "El número de documento no puede superar los 30 caracteres")
        String documentNumber,

        @Size(max = 50, message = "El primer nombre no puede superar los 50 caracteres")
        String firstName,

        @Size(max = 50, message = "El segundo nombre no puede superar los 50 caracteres")
        String middleName,

        @Size(max = 50, message = "El primer apellido no puede superar los 50 caracteres")
        String lastName,

        @Size(max = 50, message = "El segundo apellido no puede superar los 50 caracteres")
        String secondLastName,

        LocalDate birthDate,

        @NotNull(message = "El sexo biológico es obligatorio")
        UUID biologicalSexId,

        @NotNull(message = "La identidad de género es obligatoria")
        UUID genderIdentityId,

        @NotBlank(message = "El correo no puede estar vacío")
        @Size(max = 150, message = "El correo no puede superar los 150 caracteres")
        String email,

        @Size(max = 30, message = "El teléfono no puede superar los 30 caracteres")
        String phone,

        @Size(max = 250, message = "La dirección no puede superar los 250 caracteres")
        String address,

        Boolean active,

        UUID createdBy,

        UUID updatedBy,

        @NotNull(message = "La ciudad es obligatoria")
        UUID cityId
) {
}
