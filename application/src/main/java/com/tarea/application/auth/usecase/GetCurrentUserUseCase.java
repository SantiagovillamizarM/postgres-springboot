package com.tarea.application.auth.usecase;

import com.tarea.application.auth.dto.UserResponse;
import com.tarea.application.auth.exception.UserNotFoundApplicationException;
import com.tarea.domain.auth.model.valueobject.UserId;
import com.tarea.domain.auth.port.repository.UserRepository;

public class GetCurrentUserUseCase {

    private final UserRepository userRepository;

    public GetCurrentUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse execute(UserId id) {
        return userRepository.findById(id)
                .map(UserResponse::from)
                .orElseThrow(() -> new UserNotFoundApplicationException(id.value().toString()));
    }
}
