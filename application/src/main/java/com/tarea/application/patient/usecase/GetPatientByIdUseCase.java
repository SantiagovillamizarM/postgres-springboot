package com.tarea.application.patient.usecase;

import com.tarea.application.patient.dto.PatientResponse;
import com.tarea.application.patient.exception.PatientNotFoundApplicationException;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.patient.port.repository.PatientRepository;

public class GetPatientByIdUseCase {

    private final PatientRepository patientRepository;

    public GetPatientByIdUseCase(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponse execute(PatientId id) {
        var patient = patientRepository.findById(id)
                .orElseThrow(() -> new PatientNotFoundApplicationException(id.value().toString()));

        return new PatientResponse(
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
        );
    }
}
