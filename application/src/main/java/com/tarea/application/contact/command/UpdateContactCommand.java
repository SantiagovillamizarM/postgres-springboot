package com.tarea.application.contact.command;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.contact.model.valueobject.ContactId;

public record UpdateContactCommand(
        ContactId id,
        String fullName,
        String email,
        String notes,
        CityMunicipalityId cityId,
        ProfessionalId updatedBy
) {
}
