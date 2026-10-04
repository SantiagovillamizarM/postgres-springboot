package com.tarea.application.risklevel.command;

import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;

public record UpdateRiskLevelCommand(
        RiskLevelId id,
        String code,
        String name,
        Boolean active,
        Integer severity
) {
}
