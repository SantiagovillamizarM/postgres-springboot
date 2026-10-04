package com.tarea.application.priority.usecase;

import com.tarea.application.priority.dto.PriorityResponse;
import com.tarea.domain.priority.port.repository.PriorityRepository;

import java.util.List;

public class ListPriorityUseCase {

    private final PriorityRepository priorityRepository;

    public ListPriorityUseCase(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }

    public List<PriorityResponse> execute() {
        return priorityRepository.findAll().stream()
                .map(priority -> new PriorityResponse(
                    priority.id().value(),
                    priority.namePriority(),
                    priority.createdAt(),
                    priority.updatedAt()
                ))
                .toList();
    }
}
