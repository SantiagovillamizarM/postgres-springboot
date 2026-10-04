package com.tarea.infrastructure.citymunicipality.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UpdateCityMunicipalityRequest(
        @NotBlank(message = "El nombre de la ciudad no puede estar vacío")
        @Size(max = 50, message = "El nombre de la ciudad no puede superar los 50 caracteres")
        String nameCity,

        @NotBlank(message = "El código de la ciudad no puede estar vacío")
        @Size(max = 10, message = "El código de la ciudad no puede superar los 10 caracteres")
        String codeCity,

        @Size(max = 100, message = "La descripción no puede superar los 100 caracteres")
        String description,

        Boolean active,

        @NotNull(message = "La región es obligatoria")
        UUID regionId
) {
}
