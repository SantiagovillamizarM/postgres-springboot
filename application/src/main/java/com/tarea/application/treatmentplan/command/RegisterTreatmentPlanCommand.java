package com.tarea.application.treatmentplan.command;

import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

import java.time.LocalDate;

public record RegisterTreatmentPlanCommand(
        EncounterId encounterId,
        ProfessionalId professionalId,
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        TreatmentStatusId treatmentStatusId
) {
}
