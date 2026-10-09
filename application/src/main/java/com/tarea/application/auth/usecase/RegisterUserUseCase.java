package com.tarea.application.auth.usecase;

import com.tarea.application.auth.command.RegisterUserCommand;
import com.tarea.application.auth.dto.UserResponse;
import com.tarea.application.auth.exception.EmailAlreadyRegisteredApplicationException;
import com.tarea.domain.auth.model.aggregate.User;
import com.tarea.domain.auth.port.repository.UserRepository;
import com.tarea.domain.auth.port.security.PasswordService;

public class RegisterUserUseCase {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public RegisterUserUseCase(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    public UserResponse execute(RegisterUserCommand command) {
        String email = User.normalizeEmail(command.email());
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyRegisteredApplicationException(email);
        }

        User user = User.register(
                email,
                passwordService.hash(command.password()),
                command.role(),
                command.professionalId()
        );

        return UserResponse.from(userRepository.save(user));
    }
}
