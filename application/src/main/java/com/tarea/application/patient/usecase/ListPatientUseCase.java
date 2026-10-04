package com.tarea.application.patient.usecase;

import com.tarea.application.patient.dto.PatientResponse;
import com.tarea.domain.patient.port.repository.PatientRepository;

import java.util.List;

public class ListPatientUseCase {

    private final PatientRepository patientRepository;

    public ListPatientUseCase(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponse> execute() {
        return patientRepository.findAll().stream()
                .map(patient -> new PatientResponse(
                    patient.id().value(),
                    patient.documentTypeId().value(),
                    patient.documentNumber(),
                    patient.firstName(),
                    patient.middleName(),
                    patient.lastName(),
                    patient.secondLastName(),
                    patient.birthDate(),
                    patient.biologicalSexId().value(),
                    patient.genderIdentityId().value(),
                    patient.email(),
                    patient.phone(),
                    patient.address(),
                    patient.active(),
                    patient.createdBy() != null ? patient.createdBy().value() : null,
                    patient.updatedBy() != null ? patient.updatedBy().value() : null,
                    patient.cityId().value(),
                    patient.createdAt(),
                    patient.updatedAt()
                ))
                .toList();
    }
}
