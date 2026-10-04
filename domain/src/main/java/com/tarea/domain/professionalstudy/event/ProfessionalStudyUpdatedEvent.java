package com.tarea.domain.professionalstudy.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.study.model.valueobject.StudyId;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProfessionalStudyUpdatedEvent(
        ProfessionalStudyId id,
        StudyId studyId,
        ProfessionalId professionalId,
        CountryId countryId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ProfessionalStudyUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(studyId, "El estudio no puede ser nulo");
        Objects.requireNonNull(professionalId, "El profesional no puede ser nulo");
        Objects.requireNonNull(countryId, "El país no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
