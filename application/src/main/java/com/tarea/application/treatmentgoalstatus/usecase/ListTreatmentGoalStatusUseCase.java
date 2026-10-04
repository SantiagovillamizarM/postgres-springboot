package com.tarea.application.treatmentgoalstatus.usecase;

import com.tarea.application.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.tarea.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;

import java.util.List;

public class ListTreatmentGoalStatusUseCase {

    private final TreatmentGoalStatusRepository treatmentGoalStatusRepository;

    public ListTreatmentGoalStatusUseCase(TreatmentGoalStatusRepository treatmentGoalStatusRepository) {
        this.treatmentGoalStatusRepository = treatmentGoalStatusRepository;
    }

    public List<TreatmentGoalStatusResponse> execute() {
        return treatmentGoalStatusRepository.findAll().stream()
                .map(treatmentGoalStatus -> new TreatmentGoalStatusResponse(
                    treatmentGoalStatus.id().value(),
                    treatmentGoalStatus.code(),
                    treatmentGoalStatus.name(),
                    treatmentGoalStatus.active(),
                    treatmentGoalStatus.createdAt(),
                    treatmentGoalStatus.updatedAt()
                ))
                .toList();
    }
}
