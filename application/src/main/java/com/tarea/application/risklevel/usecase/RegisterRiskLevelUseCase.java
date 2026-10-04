package com.tarea.application.risklevel.usecase;

import com.tarea.application.risklevel.command.RegisterRiskLevelCommand;
import com.tarea.application.risklevel.dto.RiskLevelResponse;
import com.tarea.domain.risklevel.model.aggregate.RiskLevel;
import com.tarea.domain.risklevel.port.repository.RiskLevelRepository;

public class RegisterRiskLevelUseCase {

    private final RiskLevelRepository riskLevelRepository;

    public RegisterRiskLevelUseCase(RiskLevelRepository riskLevelRepository) {
        this.riskLevelRepository = riskLevelRepository;
    }

    public RiskLevelResponse execute(RegisterRiskLevelCommand command) {
        RiskLevel riskLevel = RiskLevel.register(
                command.code(),
                command.name(),
                command.active(),
                command.severity()
        );

        RiskLevel saved = riskLevelRepository.save(riskLevel);

        return new RiskLevelResponse(
            saved.id().value(),
            saved.code(),
            saved.name(),
            saved.active(),
            saved.severity(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
