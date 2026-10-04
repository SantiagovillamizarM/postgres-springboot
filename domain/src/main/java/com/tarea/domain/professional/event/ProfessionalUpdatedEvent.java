package com.tarea.domain.professional.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProfessionalUpdatedEvent(
        ProfessionalId id,
        DocumentTypeId documentTypeId,
        String documentNumber,
        ProfessionalTypeId professionalTypeId,
        String licenseNumber,
        CityMunicipalityId cityId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ProfessionalUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(documentTypeId, "El tipo de documento no puede ser nulo");
        Objects.requireNonNull(documentNumber, "El número de documento no puede ser nulo");
        Objects.requireNonNull(professionalTypeId, "El tipo de profesional no puede ser nulo");
        Objects.requireNonNull(licenseNumber, "El número de licencia no puede ser nulo");
        Objects.requireNonNull(cityId, "La ciudad no puede ser nula");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
