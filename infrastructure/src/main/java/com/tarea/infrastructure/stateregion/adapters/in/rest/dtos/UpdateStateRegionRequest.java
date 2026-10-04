package com.tarea.infrastructure.stateregion.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UpdateStateRegionRequest(
        @NotBlank(message = "El nombre de la región no puede estar vacío")
        @Size(max = 50, message = "El nombre de la región no puede superar los 50 caracteres")
        String nameRegion,

        @NotBlank(message = "El código de la región no puede estar vacío")
        @Size(max = 10, message = "El código de la región no puede superar los 10 caracteres")
        String codeRegion,

        @Size(max = 100, message = "La descripción no puede superar los 100 caracteres")
        String description,

        Boolean active,

        @NotNull(message = "El país es obligatorio")
        UUID countryId
) {
}
