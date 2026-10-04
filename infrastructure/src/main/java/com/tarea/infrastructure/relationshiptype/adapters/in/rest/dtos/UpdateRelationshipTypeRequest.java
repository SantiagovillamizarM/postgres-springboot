package com.tarea.infrastructure.relationshiptype.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateRelationshipTypeRequest(
        @NotBlank(message = "La descripción no puede estar vacía")
        @Size(max = 50, message = "La descripción no puede superar los 50 caracteres")
        String description
) {
}
