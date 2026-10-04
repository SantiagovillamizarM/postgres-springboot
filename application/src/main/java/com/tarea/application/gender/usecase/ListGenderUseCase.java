package com.tarea.application.gender.usecase;

import com.tarea.application.gender.dto.GenderResponse;
import com.tarea.domain.gender.port.repository.GenderRepository;

import java.util.List;

public class ListGenderUseCase {

    private final GenderRepository genderRepository;

    public ListGenderUseCase(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public List<GenderResponse> execute() {
        return genderRepository.findAll().stream()
                .map(gender -> new GenderResponse(
                    gender.id().value(),
                    gender.description(),
                    gender.createdAt(),
                    gender.updatedAt()
                ))
                .toList();
    }
}
