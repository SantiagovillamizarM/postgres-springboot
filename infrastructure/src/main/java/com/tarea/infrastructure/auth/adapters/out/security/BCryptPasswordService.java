package com.tarea.infrastructure.auth.adapters.out.security;

import com.tarea.domain.auth.port.security.PasswordService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class BCryptPasswordService implements PasswordService {

    private final PasswordEncoder passwordEncoder;

    public BCryptPasswordService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String hash(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String passwordHash) {
        return passwordEncoder.matches(rawPassword, passwordHash);
    }
}
