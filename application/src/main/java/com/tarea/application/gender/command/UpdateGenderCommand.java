package com.tarea.application.gender.command;

import com.tarea.domain.gender.model.valueobject.GenderId;

public record UpdateGenderCommand(
        GenderId id,
        String description
) {
}
