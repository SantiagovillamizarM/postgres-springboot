package com.tarea.application.patientallergy.usecase;

import com.tarea.application.patientallergy.dto.PatientAllergyResponse;
import com.tarea.application.patientallergy.exception.PatientAllergyNotFoundApplicationException;
import com.tarea.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.tarea.domain.patientallergy.port.repository.PatientAllergyRepository;

public class GetPatientAllergyByIdUseCase {

    private final PatientAllergyRepository patientAllergyRepository;

    public GetPatientAllergyByIdUseCase(PatientAllergyRepository patientAllergyRepository) {
        this.patientAllergyRepository = patientAllergyRepository;
    }

    public PatientAllergyResponse execute(PatientAllergyId id) {
        var patientAllergy = patientAllergyRepository.findById(id)
                .orElseThrow(() -> new PatientAllergyNotFoundApplicationException(id.value().toString()));

        return new PatientAllergyResponse(
            patientAllergy.id().value(),
            patientAllergy.patientId().value(),
            patientAllergy.substance(),
            patientAllergy.reaction(),
            patientAllergy.severity(),
            patientAllergy.active(),
            patientAllergy.recordedAt(),
            patientAllergy.recordedBy() != null ? patientAllergy.recordedBy().value() : null,
            patientAllergy.createdAt(),
            patientAllergy.updatedAt()
        );
    }
}
