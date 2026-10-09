package com.tarea.application.auth.usecase;

import com.tarea.application.auth.command.LoginCommand;
import com.tarea.application.auth.dto.AuthResponse;
import com.tarea.application.auth.exception.InvalidCredentialsApplicationException;
import com.tarea.domain.auth.model.aggregate.User;
import com.tarea.domain.auth.port.repository.UserRepository;
import com.tarea.domain.auth.port.security.PasswordService;

public class LoginUseCase {

    private final UserRepository userRepository;
    private final PasswordService passwordService;
    private final TokenIssuer tokenIssuer;

    public LoginUseCase(UserRepository userRepository, PasswordService passwordService, TokenIssuer tokenIssuer) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
        this.tokenIssuer = tokenIssuer;
    }

    public AuthResponse execute(LoginCommand command) {
        User user = userRepository.findByEmail(User.normalizeEmail(command.email()))
                .filter(User::isActive)
                .filter(u -> passwordService.matches(command.password(), u.passwordHash()))
                .orElseThrow(InvalidCredentialsApplicationException::new);

        return tokenIssuer.issue(user);
    }
}
