package com.tarea.application.risklevel.usecase;

import com.tarea.application.risklevel.command.UpdateRiskLevelCommand;
import com.tarea.application.risklevel.dto.RiskLevelResponse;
import com.tarea.application.risklevel.exception.RiskLevelNotFoundApplicationException;
import com.tarea.domain.risklevel.port.repository.RiskLevelRepository;

public class UpdateRiskLevelUseCase {

    private final RiskLevelRepository riskLevelRepository;

    public UpdateRiskLevelUseCase(RiskLevelRepository riskLevelRepository) {
        this.riskLevelRepository = riskLevelRepository;
    }

    public RiskLevelResponse execute(UpdateRiskLevelCommand command) {
        var riskLevel = riskLevelRepository.findById(command.id())
                .orElseThrow(() -> new RiskLevelNotFoundApplicationException(command.id().value().toString()));

        riskLevel.update(
                command.code(),
                command.name(),
                command.active(),
                command.severity()
        );

        var updated = riskLevelRepository.save(riskLevel);

        return new RiskLevelResponse(
            updated.id().value(),
            updated.code(),
            updated.name(),
            updated.active(),
            updated.severity(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
