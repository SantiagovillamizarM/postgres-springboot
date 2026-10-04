package com.tarea.application.priority.usecase;

import com.tarea.application.priority.exception.PriorityNotFoundApplicationException;
import com.tarea.domain.priority.model.valueobject.PriorityId;
import com.tarea.domain.priority.port.repository.PriorityRepository;

public class DeletePriorityUseCase {

    private final PriorityRepository priorityRepository;

    public DeletePriorityUseCase(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public void execute(PriorityId id) {
        var priority = priorityRepository.findById(id)
                .orElseThrow(() -> new PriorityNotFoundApplicationException(id.value().toString()));

        priority.markAsDeleted();
        priorityRepository.delete(priority);
    }
}
