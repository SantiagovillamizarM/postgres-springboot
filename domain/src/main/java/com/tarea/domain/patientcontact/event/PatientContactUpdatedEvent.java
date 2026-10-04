package com.tarea.domain.patientcontact.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.tarea.domain.patientcontact.model.valueobject.PatientContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public record PatientContactUpdatedEvent(
        PatientContactId id,
        ContactId contactId,
        PatientId patientId,
        RelationshipTypeId relationshipTypeId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public PatientContactUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(contactId, "El contacto no puede ser nulo");
        Objects.requireNonNull(patientId, "El paciente no puede ser nulo");
        Objects.requireNonNull(relationshipTypeId, "El tipo de relación no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
