package com.tarea.domain.auth.port.security;

import com.tarea.domain.auth.model.aggregate.User;

import java.time.Duration;

// Puerto: el dominio no sabe que por debajo se usa JWT ni Spring Security
public interface TokenService {
    String generateAccessToken(User user);
    Duration accessTokenValidity();
    Duration refreshTokenValidity();
}
