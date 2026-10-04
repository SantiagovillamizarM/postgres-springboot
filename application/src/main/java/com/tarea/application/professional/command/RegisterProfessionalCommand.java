package com.tarea.application.professional.command;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;

public record RegisterProfessionalCommand(
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
