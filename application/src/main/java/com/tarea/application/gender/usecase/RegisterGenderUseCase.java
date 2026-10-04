package com.tarea.application.gender.usecase;

import com.tarea.application.gender.command.RegisterGenderCommand;
import com.tarea.application.gender.dto.GenderResponse;
import com.tarea.domain.gender.model.aggregate.Gender;
import com.tarea.domain.gender.port.repository.GenderRepository;

public class RegisterGenderUseCase {

    private final GenderRepository genderRepository;

    public RegisterGenderUseCase(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    public GenderResponse execute(RegisterGenderCommand command) {
        Gender gender = Gender.register(
                command.description()
        );

        Gender saved = genderRepository.save(gender);

        return new GenderResponse(
            saved.id().value(),
            saved.description(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
