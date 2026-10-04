package com.tarea.domain.contact.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.contact.model.valueobject.ContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ContactUpdatedEvent(
        ContactId id,
        CityMunicipalityId cityId,
        ProfessionalId createdBy,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ContactUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(cityId, "La ciudad no puede ser nula");
        Objects.requireNonNull(createdBy, "El profesional que crea no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
