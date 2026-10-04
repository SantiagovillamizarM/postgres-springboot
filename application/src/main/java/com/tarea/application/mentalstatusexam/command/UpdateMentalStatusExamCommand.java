package com.tarea.application.mentalstatusexam.command;

import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;

public record UpdateMentalStatusExamCommand(
        MentalStatusExamId id,
        EncounterId encounterId,
        String appearance,
        String behavior,
        String attitude,
        String consciousness,
        String orientation,
        String attention,
        String memory,
        String speech,
        String mood,
        String affect,
        String thoughtProcess,
        String thoughtContent,
        String perception,
        String judgment,
        String insight,
        String psychomotorActivity,
        String observations
) {
}
