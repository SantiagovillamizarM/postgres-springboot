package com.tarea.application.gender.usecase;

import com.tarea.application.gender.dto.GenderResponse;
import com.tarea.application.gender.exception.GenderNotFoundApplicationException;
import com.tarea.domain.gender.model.valueobject.GenderId;
import com.tarea.domain.gender.port.repository.GenderRepository;

public class GetGenderByIdUseCase {

    private final GenderRepository genderRepository;

    public GetGenderByIdUseCase(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public GenderResponse execute(GenderId id) {
        var gender = genderRepository.findById(id)
                .orElseThrow(() -> new GenderNotFoundApplicationException(id.value().toString()));

        return new GenderResponse(
            gender.id().value(),
            gender.description(),
            gender.createdAt(),
            gender.updatedAt()
        );
    }
}
