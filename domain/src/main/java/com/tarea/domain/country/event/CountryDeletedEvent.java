package com.tarea.domain.country.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.country.model.valueobject.CountryId;

import java.time.LocalDateTime;
import java.util.Objects;

public record CountryDeletedEvent(CountryId id, LocalDateTime occurredOn) implements DomainEvent {
    public CountryDeletedEvent{
        Objects.requireNonNull(id, "El id no puede ser nulo");
        Objects.requireNonNull(occurredOn, "El tiempo de ocurrencia no puede ser nulo");
    }
    
}
