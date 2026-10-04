package com.tarea.infrastructure.professionalstudy.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateProfessionalStudyRequest(
        @NotNull(message = "El estudio es obligatorio")
        UUID studyId,

        @NotNull(message = "El profesional es obligatorio")
        UUID professionalId,

        @Size(max = 100, message = "El título no puede superar los 100 caracteres")
        String title,

        @Size(max = 100, message = "La universidad no puede superar los 100 caracteres")
        String university,

        Boolean valid,

        @Size(max = 60, message = "El número de resolución no puede superar los 60 caracteres")
        String resolutionNumber,

        @NotNull(message = "El país es obligatorio")
        UUID countryId
) {
}
