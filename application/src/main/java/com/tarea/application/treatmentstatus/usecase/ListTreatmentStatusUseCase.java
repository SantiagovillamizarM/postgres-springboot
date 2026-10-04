package com.tarea.application.treatmentstatus.usecase;

import com.tarea.application.treatmentstatus.dto.TreatmentStatusResponse;
import com.tarea.domain.treatmentstatus.port.repository.TreatmentStatusRepository;

import java.util.List;

public class ListTreatmentStatusUseCase {

    private final TreatmentStatusRepository treatmentStatusRepository;

    public ListTreatmentStatusUseCase(TreatmentStatusRepository treatmentStatusRepository) {
        this.treatmentStatusRepository = treatmentStatusRepository;
    }

    public List<TreatmentStatusResponse> execute() {
        return treatmentStatusRepository.findAll().stream()
                .map(treatmentStatus -> new TreatmentStatusResponse(
                    treatmentStatus.id().value(),
                    treatmentStatus.code(),
                    treatmentStatus.name(),
                    treatmentStatus.active(),
                    treatmentStatus.createdAt(),
                    treatmentStatus.updatedAt()
                ))
                .toList();
    }
}
