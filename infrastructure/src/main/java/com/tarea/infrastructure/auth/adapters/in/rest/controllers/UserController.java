package com.tarea.infrastructure.auth.adapters.in.rest.controllers;

import com.tarea.application.auth.command.RegisterUserCommand;
import com.tarea.application.auth.dto.UserResponse;
import com.tarea.application.auth.usecase.ListUserUseCase;
import com.tarea.application.auth.usecase.RegisterUserUseCase;
import com.tarea.domain.auth.model.valueobject.Role;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.infrastructure.auth.adapters.in.rest.dtos.CreateUserRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Solo ADMIN (regla en SecurityConfig): no hay registro público, el admin crea las cuentas
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final RegisterUserUseCase registerUseCase;
    private final ListUserUseCase listUseCase;

    public UserController(RegisterUserUseCase registerUseCase, ListUserUseCase listUseCase) {
        this.registerUseCase = registerUseCase;
        this.listUseCase = listUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody CreateUserRequest request) {
        var command = new RegisterUserCommand(
                request.email(),
                request.password(),
                Role.valueOf(request.role()),
                request.professionalId() != null ? new ProfessionalId(request.professionalId()) : null
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerUseCase.execute(command));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }
}
