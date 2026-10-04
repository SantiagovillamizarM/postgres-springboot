package com.tarea.application.patient.command;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.gender.model.valueobject.GenderId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.patient.model.valueobject.PatientId;

import java.time.LocalDate;

public record UpdatePatientCommand(
        PatientId id,
        DocumentTypeId documentTypeId,
        String documentNumber,
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        LocalDate birthDate,
        GenderId biologicalSexId,
        GenderId genderIdentityId,
        String email,
        String phone,
        String address,
        Boolean active,
        ProfessionalId updatedBy,
        CityMunicipalityId cityId
) {
}
