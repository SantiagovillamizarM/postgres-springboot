package com.tarea.domain.clinicalrecord.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ClinicalRecordRegisteredEvent(ClinicalRecordId id, LocalDateTime occurredOn) implements DomainEvent {
    public ClinicalRecordRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
