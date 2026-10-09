package com.tarea.application.auth.usecase;

import com.tarea.application.auth.dto.UserResponse;
import com.tarea.domain.auth.port.repository.UserRepository;

import java.util.List;

public class ListUserUseCase {

    private final UserRepository userRepository;

    public ListUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> execute() {
        return userRepository.findAll().stream()
                .map(UserResponse::from)
                .toList();
    }
}
