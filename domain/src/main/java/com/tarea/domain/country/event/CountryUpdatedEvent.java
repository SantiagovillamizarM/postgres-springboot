package com.tarea.domain.country.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.country.model.valueobject.CountryId;

import java.time.LocalDateTime;
import java.util.Objects;

public record CountryUpdatedEvent(
    CountryId id,
    String nameCountry,
    String codeCountry,
    LocalDateTime occurredOn
) implements DomainEvent {
    public CountryUpdatedEvent{
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(nameCountry, "El nombre del pais no puede ser nulo");
        Objects.requireNonNull(codeCountry, "El codigo del pais no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
