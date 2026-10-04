package com.tarea.infrastructure.providermodelai.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateProviderModelAiRequest(
        @NotBlank(message = "El nombre del proveedor no puede estar vacío")
        @Size(max = 100, message = "El nombre del proveedor no puede superar los 100 caracteres")
        String nameProviderAi,

        String razonSocial,

        String sitioWeb,

        Boolean active
) {
}
