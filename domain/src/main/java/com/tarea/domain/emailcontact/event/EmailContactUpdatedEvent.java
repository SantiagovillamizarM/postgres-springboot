package com.tarea.domain.emailcontact.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.emailcontact.model.valueobject.EmailContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EmailContactUpdatedEvent(
        EmailContactId id,
        ContactId contactId,
        String email,
        LocalDateTime occurredOn
) implements DomainEvent {
    public EmailContactUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(contactId, "El contacto no puede ser nulo");
        Objects.requireNonNull(email, "El correo no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
