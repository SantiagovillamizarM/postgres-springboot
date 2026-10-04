package com.tarea.application.professional.command;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

public record UpdateProfessionalCommand(
        ProfessionalId id,
        DocumentTypeId documentTypeId,
        String documentNumber,
        String firstName,
        String lastName,
        ProfessionalTypeId professionalTypeId,
        String licenseNumber,
        Boolean active,
        CityMunicipalityId cityId
) {
}
