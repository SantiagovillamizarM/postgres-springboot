package com.tarea.application.auth.usecase;

import com.tarea.application.auth.command.ChangePasswordCommand;
import com.tarea.application.auth.exception.InvalidCredentialsApplicationException;
import com.tarea.application.auth.exception.UserNotFoundApplicationException;
import com.tarea.domain.auth.model.aggregate.User;
import com.tarea.domain.auth.port.repository.RefreshTokenRepository;
import com.tarea.domain.auth.port.repository.UserRepository;
import com.tarea.domain.auth.port.security.PasswordService;

public class ChangePasswordUseCase {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordService passwordService;

    public ChangePasswordUseCase(UserRepository userRepository, RefreshTokenRepository refreshTokenRepository,
                                 PasswordService passwordService) {
        this.userRepository = userRepository;
        this.refreshTokenRepository = refreshTokenRepository;
        this.passwordService = passwordService;
    }

    public void execute(ChangePasswordCommand command) {
        User user = userRepository.findById(command.userId())
                .orElseThrow(() -> new UserNotFoundApplicationException(command.userId().value().toString()));

        if (!passwordService.matches(command.currentPassword(), user.passwordHash())) {
            throw new InvalidCredentialsApplicationException();
        }

        user.changePassword(passwordService.hash(command.newPassword()));
        userRepository.save(user);

        // Cierra las sesiones abiertas en otros dispositivos
        refreshTokenRepository.revokeAllByUserId(user.id());
    }
}
