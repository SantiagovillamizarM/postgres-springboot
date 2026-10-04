package com.tarea.domain.stateregion.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;

import java.time.LocalDateTime;
import java.util.Objects;

public record StateRegionUpdatedEvent(
        StateRegionId id,
        String nameRegion,
        String codeRegion,
        CountryId countryId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public StateRegionUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(nameRegion, "El nombre de la región no puede ser nulo");
        Objects.requireNonNull(codeRegion, "El código de la región no puede ser nulo");
        Objects.requireNonNull(countryId, "El país no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
