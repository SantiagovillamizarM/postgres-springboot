package com.tarea.application.patientallergy.usecase;

import com.tarea.application.patientallergy.exception.PatientAllergyNotFoundApplicationException;
import com.tarea.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.tarea.domain.patientallergy.port.repository.PatientAllergyRepository;

public class DeletePatientAllergyUseCase {

    private final PatientAllergyRepository patientAllergyRepository;

    public DeletePatientAllergyUseCase(PatientAllergyRepository patientAllergyRepository) {
        this.patientAllergyRepository = patientAllergyRepository;
    }

    public void execute(PatientAllergyId id) {
        var patientAllergy = patientAllergyRepository.findById(id)
                .orElseThrow(() -> new PatientAllergyNotFoundApplicationException(id.value().toString()));

        patientAllergy.markAsDeleted();
        patientAllergyRepository.delete(patientAllergy);
    }
}
