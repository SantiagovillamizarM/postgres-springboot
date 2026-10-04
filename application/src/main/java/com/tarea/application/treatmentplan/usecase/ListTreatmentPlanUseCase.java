package com.tarea.application.treatmentplan.usecase;

import com.tarea.application.treatmentplan.dto.TreatmentPlanResponse;
import com.tarea.domain.treatmentplan.port.repository.TreatmentPlanRepository;

import java.util.List;

public class ListTreatmentPlanUseCase {

    private final TreatmentPlanRepository treatmentPlanRepository;

    public ListTreatmentPlanUseCase(TreatmentPlanRepository treatmentPlanRepository) {
        this.treatmentPlanRepository = treatmentPlanRepository;
    }

    public List<TreatmentPlanResponse> execute() {
        return treatmentPlanRepository.findAll().stream()
                .map(treatmentPlan -> new TreatmentPlanResponse(
                    treatmentPlan.id().value(),
                    treatmentPlan.encounterId().value(),
                    treatmentPlan.professionalId().value(),
                    treatmentPlan.title(),
                    treatmentPlan.description(),
                    treatmentPlan.startDate(),
                    treatmentPlan.endDate(),
                    treatmentPlan.treatmentStatusId().value(),
                    treatmentPlan.createdAt(),
                    treatmentPlan.updatedAt()
                ))
                .toList();
    }
}
