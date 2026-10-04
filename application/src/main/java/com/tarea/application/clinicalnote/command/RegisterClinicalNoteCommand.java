package com.tarea.application.clinicalnote.command;

import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;

public record RegisterClinicalNoteCommand(
        EncounterId encounterId,
        ProfessionalId professionalId,
        String subjective,
        String objective,
        String assessment,
        String plan,
        String additionalNotes,
        LocalDateTime signedAt
) {
}
