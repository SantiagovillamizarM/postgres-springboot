package com.tarea.domain.clinicalnote.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ClinicalNoteId(UUID value) {
    public ClinicalNoteId {
        Objects.requireNonNull(value, "El valor de ClinicalNoteId no puede ser nulo");
    }

    public static ClinicalNoteId generate() {
        return new ClinicalNoteId(UUID.randomUUID());
    }
}
