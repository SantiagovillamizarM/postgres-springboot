package com.tarea.application.risklevel.usecase;

import com.tarea.application.risklevel.dto.RiskLevelResponse;
import com.tarea.domain.risklevel.port.repository.RiskLevelRepository;

import java.util.List;

public class ListRiskLevelUseCase {

    private final RiskLevelRepository riskLevelRepository;

    public ListRiskLevelUseCase(RiskLevelRepository riskLevelRepository) {
        this.riskLevelRepository = riskLevelRepository;
    }

    public List<RiskLevelResponse> execute() {
        return riskLevelRepository.findAll().stream()
                .map(riskLevel -> new RiskLevelResponse(
                    riskLevel.id().value(),
                    riskLevel.code(),
                    riskLevel.name(),
                    riskLevel.active(),
                    riskLevel.severity(),
                    riskLevel.createdAt(),
                    riskLevel.updatedAt()
                ))
                .toList();
    }
}
