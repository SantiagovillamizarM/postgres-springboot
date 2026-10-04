package com.tarea.domain.patientallergy.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.patientallergy.model.valueobject.PatientAllergyId;

import java.time.LocalDateTime;
import java.util.Objects;

public record PatientAllergyRegisteredEvent(PatientAllergyId id, LocalDateTime occurredOn) implements DomainEvent {
    public PatientAllergyRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
