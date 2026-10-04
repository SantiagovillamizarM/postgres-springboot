package com.tarea.domain.mentalstatusexam.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record MentalStatusExamId(UUID value) {
    public MentalStatusExamId {
        Objects.requireNonNull(value, "El valor de MentalStatusExamId no puede ser nulo");
    }

    public static MentalStatusExamId generate() {
        return new MentalStatusExamId(UUID.randomUUID());
    }
}
