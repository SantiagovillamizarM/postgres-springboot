package com.tarea.application.patient.usecase;

import com.tarea.application.patient.command.RegisterPatientCommand;
import com.tarea.application.patient.dto.PatientResponse;
import com.tarea.domain.patient.model.aggregate.Patient;
import com.tarea.domain.patient.port.repository.PatientRepository;

public class RegisterPatientUseCase {

    private final PatientRepository patientRepository;

    public RegisterPatientUseCase(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponse execute(RegisterPatientCommand command) {
        Patient patient = Patient.register(
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
                command.createdBy(),
                command.updatedBy(),
                command.cityId()
        );

        Patient saved = patientRepository.save(patient);

        return new PatientResponse(
            saved.id().value(),
            saved.documentTypeId().value(),
            saved.documentNumber(),
            saved.firstName(),
            saved.middleName(),
            saved.lastName(),
            saved.secondLastName(),
            saved.birthDate(),
            saved.biologicalSexId().value(),
            saved.genderIdentityId().value(),
            saved.email(),
            saved.phone(),
            saved.address(),
            saved.active(),
            saved.createdBy() != null ? saved.createdBy().value() : null,
            saved.updatedBy() != null ? saved.updatedBy().value() : null,
            saved.cityId().value(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
