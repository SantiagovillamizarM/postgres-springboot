package com.tarea.infrastructure.country.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateCountryRequest(
        @NotBlank(message = "El nombre del país no puede estar vacío")
        @Size(max = 50, message = "El nombre del país no puede superar los 50 caracteres")
        String nameCountry,

        @NotBlank(message = "El código del país no puede estar vacío")
        @Size(max = 10, message = "El código del país no puede superar los 10 caracteres")
        String codeCountry,

        @Size(max = 100, message = "La descripción no puede superar los 100 caracteres")
        String description,

        Boolean isActive,

        @Size(max = 5, message = "El prefijo telefónico no puede superar los 5 caracteres")
        String telephonePrefix
) {
}
