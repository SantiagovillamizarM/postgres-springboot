package com.tarea.application.priority.usecase;

import com.tarea.application.priority.command.RegisterPriorityCommand;
import com.tarea.application.priority.dto.PriorityResponse;
import com.tarea.domain.priority.model.aggregate.Priority;
import com.tarea.domain.priority.port.repository.PriorityRepository;

public class RegisterPriorityUseCase {

    private final PriorityRepository priorityRepository;

    public RegisterPriorityUseCase(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public PriorityResponse execute(RegisterPriorityCommand command) {
        Priority priority = Priority.register(
                command.namePriority()
        );

        Priority saved = priorityRepository.save(priority);

        return new PriorityResponse(
            saved.id().value(),
            saved.namePriority(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
