package com.tarea.application.contact.command;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

public record RegisterContactCommand(
        String fullName,
        String email,
        String notes,
        CityMunicipalityId cityId,
        ProfessionalId createdBy,
        ProfessionalId updatedBy
) {
}
