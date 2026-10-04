package com.tarea.application.treatmentgoal.command;

import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RegisterTreatmentGoalCommand(
        TreatmentPlanId treatmentPlanId,
        String description,
        LocalDate targetDate,
        LocalDateTime completedAt,
        String notes,
        TreatmentGoalStatusId goalStatusId
) {
}
