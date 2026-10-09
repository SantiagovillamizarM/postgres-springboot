package com.tarea.infrastructure.auth.config;

import com.tarea.application.auth.command.RegisterUserCommand;
import com.tarea.application.auth.usecase.RegisterUserUseCase;
import com.tarea.domain.auth.model.valueobject.Role;
import com.tarea.domain.auth.port.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// Al arrancar crea el primer ADMIN con ADMIN_EMAIL y ADMIN_PASSWORD, solo si todavía no existe ninguno
@Component
public class AdminInitializer implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(AdminInitializer.class);

    private final UserRepository userRepository;
    private final RegisterUserUseCase registerUserUseCase;
    private final String adminEmail;
    private final String adminPassword;

    public AdminInitializer(UserRepository userRepository,
                            RegisterUserUseCase registerUserUseCase,
                            @Value("${app.admin.email}") String adminEmail,
                            @Value("${app.admin.password}") String adminPassword) {
        this.userRepository = userRepository;
        this.registerUserUseCase = registerUserUseCase;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (userRepository.existsByRole(Role.ADMIN)) {
            return;
        }
        if (adminEmail.isBlank() || adminPassword.isBlank()) {
            log.warn("No hay ningún ADMIN. Defina ADMIN_EMAIL y ADMIN_PASSWORD para crearlo al arrancar.");
            return;
        }

        registerUserUseCase.execute(new RegisterUserCommand(adminEmail, adminPassword, Role.ADMIN, null));
        log.info("Usuario ADMIN inicial creado: {}", adminEmail);
    }
}
