package com.tarea.domain.clinicalrecord.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ClinicalRecordId(UUID value) {
    public ClinicalRecordId {
        Objects.requireNonNull(value, "El valor de ClinicalRecordId no puede ser nulo");
    }

    public static ClinicalRecordId generate() {
        return new ClinicalRecordId(UUID.randomUUID());
    }
}
