package com.tarea.application.risklevel.usecase;

import com.tarea.application.risklevel.dto.RiskLevelResponse;
import com.tarea.application.risklevel.exception.RiskLevelNotFoundApplicationException;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;
import com.tarea.domain.risklevel.port.repository.RiskLevelRepository;

public class GetRiskLevelByIdUseCase {

    private final RiskLevelRepository riskLevelRepository;

    public GetRiskLevelByIdUseCase(RiskLevelRepository riskLevelRepository) {
        this.riskLevelRepository = riskLevelRepository;
    }

    public RiskLevelResponse execute(RiskLevelId id) {
        var riskLevel = riskLevelRepository.findById(id)
                .orElseThrow(() -> new RiskLevelNotFoundApplicationException(id.value().toString()));

        return new RiskLevelResponse(
            riskLevel.id().value(),
            riskLevel.code(),
            riskLevel.name(),
            riskLevel.active(),
            riskLevel.severity(),
            riskLevel.createdAt(),
            riskLevel.updatedAt()
        );
    }
}
