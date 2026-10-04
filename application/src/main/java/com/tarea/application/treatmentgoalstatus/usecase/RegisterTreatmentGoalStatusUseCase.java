package com.tarea.application.treatmentgoalstatus.usecase;

import com.tarea.application.treatmentgoalstatus.command.RegisterTreatmentGoalStatusCommand;
import com.tarea.application.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.tarea.domain.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;
import com.tarea.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class RegisterTreatmentGoalStatusUseCase {

    private final TreatmentGoalStatusRepository treatmentGoalStatusRepository;

    public RegisterTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        this.treatmentGoalStatusRepository = treatmentGoalStatusRepository;
    }

    public TreatmentGoalStatusResponse execute(RegisterTreatmentGoalStatusCommand command) {
        TreatmentGoalStatus treatmentGoalStatus = TreatmentGoalStatus.register(
                command.code(),
                command.name(),
                command.active()
        );

        TreatmentGoalStatus saved = treatmentGoalStatusRepository.save(treatmentGoalStatus);

        return new TreatmentGoalStatusResponse(
            saved.id().value(),
            saved.code(),
            saved.name(),
            saved.active(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
