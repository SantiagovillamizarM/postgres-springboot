package com.tarea.application.treatmentplan.usecase;

import com.tarea.application.treatmentplan.dto.TreatmentPlanResponse;
import com.tarea.application.treatmentplan.exception.TreatmentPlanNotFoundApplicationException;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.tarea.domain.treatmentplan.port.repository.TreatmentPlanRepository;

public class GetTreatmentPlanByIdUseCase {

    private final TreatmentPlanRepository treatmentPlanRepository;

    public GetTreatmentPlanByIdUseCase(TreatmentPlanRepository treatmentPlanRepository) {
        this.treatmentPlanRepository = treatmentPlanRepository;
    }

    public TreatmentPlanResponse execute(TreatmentPlanId id) {
        var treatmentPlan = treatmentPlanRepository.findById(id)
                .orElseThrow(() -> new TreatmentPlanNotFoundApplicationException(id.value().toString()));

        return new TreatmentPlanResponse(
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
        );
    }
}
