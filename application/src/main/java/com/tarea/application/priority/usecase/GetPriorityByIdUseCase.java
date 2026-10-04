package com.tarea.application.priority.usecase;

import com.tarea.application.priority.dto.PriorityResponse;
import com.tarea.application.priority.exception.PriorityNotFoundApplicationException;
import com.tarea.domain.priority.model.valueobject.PriorityId;
import com.tarea.domain.priority.port.repository.PriorityRepository;

public class GetPriorityByIdUseCase {

    private final PriorityRepository priorityRepository;

    public GetPriorityByIdUseCase(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public PriorityResponse execute(PriorityId id) {
        var priority = priorityRepository.findById(id)
                .orElseThrow(() -> new PriorityNotFoundApplicationException(id.value().toString()));

        return new PriorityResponse(
            priority.id().value(),
            priority.namePriority(),
            priority.createdAt(),
            priority.updatedAt()
        );
    }
}
