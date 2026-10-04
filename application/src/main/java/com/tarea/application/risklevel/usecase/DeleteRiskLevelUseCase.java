package com.tarea.application.risklevel.usecase;

import com.tarea.application.risklevel.exception.RiskLevelNotFoundApplicationException;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;
import com.tarea.domain.risklevel.port.repository.RiskLevelRepository;

public class DeleteRiskLevelUseCase {

    private final RiskLevelRepository riskLevelRepository;

    public DeleteRiskLevelUseCase(RiskLevelRepository riskLevelRepository) {
        this.riskLevelRepository = riskLevelRepository;
    }

    public void execute(RiskLevelId id) {
        var riskLevel = riskLevelRepository.findById(id)
                .orElseThrow(() -> new RiskLevelNotFoundApplicationException(id.value().toString()));

        riskLevel.markAsDeleted();
        riskLevelRepository.delete(riskLevel);
    }
}
