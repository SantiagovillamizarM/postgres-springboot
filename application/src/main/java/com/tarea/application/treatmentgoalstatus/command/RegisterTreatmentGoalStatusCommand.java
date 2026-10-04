package com.tarea.application.treatmentgoalstatus.command;

public record RegisterTreatmentGoalStatusCommand(
        String code,
        String name,
        Boolean active
) {
}
