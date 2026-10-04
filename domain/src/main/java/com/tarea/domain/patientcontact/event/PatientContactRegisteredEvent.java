package com.tarea.domain.patientcontact.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.patientcontact.model.valueobject.PatientContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public record PatientContactRegisteredEvent(PatientContactId id, LocalDateTime occurredOn) implements DomainEvent {
    public PatientContactRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
