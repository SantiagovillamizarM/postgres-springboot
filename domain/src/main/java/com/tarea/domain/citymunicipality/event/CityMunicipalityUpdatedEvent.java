package com.tarea.domain.citymunicipality.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;

import java.time.LocalDateTime;
import java.util.Objects;

public record CityMunicipalityUpdatedEvent(
        CityMunicipalityId id,
        String nameCity,
        String codeCity,
        StateRegionId regionId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public CityMunicipalityUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(nameCity, "El nombre de la ciudad no puede ser nulo");
        Objects.requireNonNull(codeCity, "El código de la ciudad no puede ser nulo");
        Objects.requireNonNull(regionId, "La región no puede ser nula");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
