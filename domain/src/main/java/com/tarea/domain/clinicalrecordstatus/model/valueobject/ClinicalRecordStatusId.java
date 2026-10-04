package com.tarea.domain.clinicalrecordstatus.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ClinicalRecordStatusId(UUID value) {
    public ClinicalRecordStatusId {
        Objects.requireNonNull(value, "El valor de ClinicalRecordStatusId no puede ser nulo");
    }

    public static ClinicalRecordStatusId generate() {
        return new ClinicalRecordStatusId(UUID.randomUUID());
    }
}
