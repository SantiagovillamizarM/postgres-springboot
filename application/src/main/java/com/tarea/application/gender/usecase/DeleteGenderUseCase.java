package com.tarea.application.gender.usecase;

import com.tarea.application.gender.exception.GenderNotFoundApplicationException;
import com.tarea.domain.gender.model.valueobject.GenderId;
import com.tarea.domain.gender.port.repository.GenderRepository;

public class DeleteGenderUseCase {

    private final GenderRepository genderRepository;

    public DeleteGenderUseCase(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public void execute(GenderId id) {
        var gender = genderRepository.findById(id)
                .orElseThrow(() -> new GenderNotFoundApplicationException(id.value().toString()));

        gender.markAsDeleted();
        genderRepository.delete(gender);
    }
}
