package com.tarea.domain.auth.port.security;

public interface PasswordService {
    String hash(String rawPassword);
    boolean matches(String rawPassword, String passwordHash);
}
