package com.tarea.application.priority.usecase;

import com.tarea.application.priority.command.UpdatePriorityCommand;
import com.tarea.application.priority.dto.PriorityResponse;
import com.tarea.application.priority.exception.PriorityNotFoundApplicationException;
import com.tarea.domain.priority.port.repository.PriorityRepository;

public class UpdatePriorityUseCase {

    private final PriorityRepository priorityRepository;

    public UpdatePriorityUseCase(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public PriorityResponse execute(UpdatePriorityCommand command) {
        var priority = priorityRepository.findById(command.id())
                .orElseThrow(() -> new PriorityNotFoundApplicationException(command.id().value().toString()));

        priority.update(
                command.namePriority()
        );

        var updated = priorityRepository.save(priority);

        return new PriorityResponse(
            updated.id().value(),
            updated.namePriority(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
