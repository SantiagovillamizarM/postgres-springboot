package com.tarea.application.treatmentgoalstatus.usecase;

import com.tarea.application.treatmentgoalstatus.command.UpdateTreatmentGoalStatusCommand;
import com.tarea.application.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.tarea.application.treatmentgoalstatus.exception.TreatmentGoalStatusNotFoundApplicationException;
import com.tarea.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

public class UpdateTreatmentGoalStatusUseCase {

    private final TreatmentGoalStatusRepository treatmentGoalStatusRepository;

    public UpdateTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        this.treatmentGoalStatusRepository = treatmentGoalStatusRepository;
    }

    public TreatmentGoalStatusResponse execute(UpdateTreatmentGoalStatusCommand command) {
        var treatmentGoalStatus = treatmentGoalStatusRepository.findById(command.id())
                .orElseThrow(() -> new TreatmentGoalStatusNotFoundApplicationException(command.id().value().toString()));

        treatmentGoalStatus.update(
                command.code(),
                command.name(),
                command.active()
        );

        var updated = treatmentGoalStatusRepository.save(treatmentGoalStatus);

        return new TreatmentGoalStatusResponse(
            updated.id().value(),
            updated.code(),
            updated.name(),
            updated.active(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
