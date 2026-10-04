package com.tarea.application.patient.usecase;

import com.tarea.application.patient.command.UpdatePatientCommand;
import com.tarea.application.patient.dto.PatientResponse;
import com.tarea.application.patient.exception.PatientNotFoundApplicationException;
import com.tarea.domain.patient.port.repository.PatientRepository;

public class UpdatePatientUseCase {

    private final PatientRepository patientRepository;

    public UpdatePatientUseCase(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponse execute(UpdatePatientCommand command) {
        var patient = patientRepository.findById(command.id())
                .orElseThrow(() -> new PatientNotFoundApplicationException(command.id().value().toString()));

        patient.update(
                command.documentTypeId(),
                command.documentNumber(),
                command.firstName(),
                command.middleName(),
                command.lastName(),
                command.secondLastName(),
                command.birthDate(),
                command.biologicalSexId(),
                command.genderIdentityId(),
                command.email(),
                command.phone(),
                command.address(),
                command.active(),
                command.updatedBy(),
                command.cityId()
        );

        var updated = patientRepository.save(patient);

        return new PatientResponse(
            updated.id().value(),
            updated.documentTypeId().value(),
            updated.documentNumber(),
            updated.firstName(),
            updated.middleName(),
            updated.lastName(),
            updated.secondLastName(),
            updated.birthDate(),
            updated.biologicalSexId().value(),
            updated.genderIdentityId().value(),
            updated.email(),
            updated.phone(),
            updated.address(),
            updated.active(),
            updated.createdBy() != null ? updated.createdBy().value() : null,
            updated.updatedBy() != null ? updated.updatedBy().value() : null,
            updated.cityId().value(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
