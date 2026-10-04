package com.tarea.application.patientallergy.usecase;

import com.tarea.application.patientallergy.command.RegisterPatientAllergyCommand;
import com.tarea.application.patientallergy.dto.PatientAllergyResponse;
import com.tarea.domain.patientallergy.model.aggregate.PatientAllergy;
import com.tarea.domain.patientallergy.port.repository.PatientAllergyRepository;

public class RegisterPatientAllergyUseCase {

    private final PatientAllergyRepository patientAllergyRepository;

    public RegisterPatientAllergyUseCase(PatientAllergyRepository patientAllergyRepository) {
        this.patientAllergyRepository = patientAllergyRepository;
    }

    public PatientAllergyResponse execute(RegisterPatientAllergyCommand command) {
        PatientAllergy patientAllergy = PatientAllergy.register(
                command.patientId(),
                command.substance(),
                command.reaction(),
                command.severity(),
                command.active(),
                command.recordedAt(),
                command.recordedBy()
        );

        PatientAllergy saved = patientAllergyRepository.save(patientAllergy);

        return new PatientAllergyResponse(
            saved.id().value(),
            saved.patientId().value(),
            saved.substance(),
            saved.reaction(),
            saved.severity(),
            saved.active(),
            saved.recordedAt(),
            saved.recordedBy() != null ? saved.recordedBy().value() : null,
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
