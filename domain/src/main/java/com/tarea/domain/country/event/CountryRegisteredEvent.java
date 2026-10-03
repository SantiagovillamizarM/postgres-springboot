package com.tarea.domain.country.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.country.model.valueobject.CountryId;

import java.time.LocalDateTime;
import java.util.Objects;

public record CountryRegisteredEvent(CountryId id, LocalDateTime occurredOn) implements DomainEvent {
    public CountryRegisteredEvent{
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
    
}
