package com.tarea.infrastructure.auth.adapters.in.rest.controllers;

import com.tarea.application.auth.command.ChangePasswordCommand;
import com.tarea.application.auth.command.LoginCommand;
import com.tarea.application.auth.dto.AuthResponse;
import com.tarea.application.auth.dto.UserResponse;
import com.tarea.application.auth.usecase.ChangePasswordUseCase;
import com.tarea.application.auth.usecase.GetCurrentUserUseCase;
import com.tarea.application.auth.usecase.LoginUseCase;
import com.tarea.application.auth.usecase.LogoutUseCase;
import com.tarea.application.auth.usecase.RefreshTokenUseCase;
import com.tarea.domain.auth.model.valueobject.UserId;
import com.tarea.infrastructure.auth.adapters.in.rest.dtos.ChangePasswordRequest;
import com.tarea.infrastructure.auth.adapters.in.rest.dtos.LoginRequest;
import com.tarea.infrastructure.auth.adapters.in.rest.dtos.RefreshTokenRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final LoginUseCase loginUseCase;
    private final RefreshTokenUseCase refreshTokenUseCase;
    private final LogoutUseCase logoutUseCase;
    private final GetCurrentUserUseCase getCurrentUserUseCase;
    private final ChangePasswordUseCase changePasswordUseCase;

    public AuthController(LoginUseCase loginUseCase,
                          RefreshTokenUseCase refreshTokenUseCase,
                          LogoutUseCase logoutUseCase,
                          GetCurrentUserUseCase getCurrentUserUseCase,
                          ChangePasswordUseCase changePasswordUseCase) {
        this.loginUseCase = loginUseCase;
        this.refreshTokenUseCase = refreshTokenUseCase;
        this.logoutUseCase = logoutUseCase;
        this.getCurrentUserUseCase = getCurrentUserUseCase;
        this.changePasswordUseCase = changePasswordUseCase;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(loginUseCase.execute(new LoginCommand(request.email(), request.password())));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthResponse> refresh(@Valid @RequestBody RefreshTokenRequest request) {
        return ResponseEntity.ok(refreshTokenUseCase.execute(request.refreshToken()));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@Valid @RequestBody RefreshTokenRequest request) {
        logoutUseCase.execute(request.refreshToken());
        return ResponseEntity.noContent().build();
    }

    // El "sub" del JWT es el id del usuario
    @GetMapping("/me")
    public ResponseEntity<UserResponse> me(@AuthenticationPrincipal Jwt jwt) {
        return ResponseEntity.ok(getCurrentUserUseCase.execute(currentUserId(jwt)));
    }

    @PutMapping("/change-password")
    public ResponseEntity<Void> changePassword(@AuthenticationPrincipal Jwt jwt,
                                               @Valid @RequestBody ChangePasswordRequest request) {
        changePasswordUseCase.execute(new ChangePasswordCommand(
                currentUserId(jwt),
                request.currentPassword(),
                request.newPassword()
        ));
        return ResponseEntity.noContent().build();
    }

    private UserId currentUserId(Jwt jwt) {
        return new UserId(UUID.fromString(jwt.getSubject()));
    }
}
