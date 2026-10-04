package com.tarea.application.patientallergy.usecase;

import com.tarea.application.patientallergy.dto.PatientAllergyResponse;
import com.tarea.domain.patientallergy.port.repository.PatientAllergyRepository;

import java.util.List;

public class ListPatientAllergyUseCase {

    private final PatientAllergyRepository patientAllergyRepository;

    public ListPatientAllergyUseCase(PatientAllergyRepository patientAllergyRepository) {
        this.patientAllergyRepository = patientAllergyRepository;
    }

    public List<PatientAllergyResponse> execute() {
        return patientAllergyRepository.findAll().stream()
                .map(patientAllergy -> new PatientAllergyResponse(
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
                ))
                .toList();
    }
}
