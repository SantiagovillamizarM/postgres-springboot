package com.tarea.infrastructure.auth.config;

import com.tarea.application.auth.usecase.ChangePasswordUseCase;
import com.tarea.application.auth.usecase.GetCurrentUserUseCase;
import com.tarea.application.auth.usecase.ListUserUseCase;
import com.tarea.application.auth.usecase.LoginUseCase;
import com.tarea.application.auth.usecase.LogoutUseCase;
import com.tarea.application.auth.usecase.RefreshTokenUseCase;
import com.tarea.application.auth.usecase.RegisterUserUseCase;
import com.tarea.application.auth.usecase.TokenIssuer;
import com.tarea.domain.auth.port.repository.RefreshTokenRepository;
import com.tarea.domain.auth.port.repository.UserRepository;
import com.tarea.domain.auth.port.security.PasswordService;
import com.tarea.domain.auth.port.security.TokenService;
import com.tarea.infrastructure.auth.adapters.out.persistence.mappers.RefreshTokenPersistenceMapper;
import com.tarea.infrastructure.auth.adapters.out.persistence.mappers.UserPersistenceMapper;
import com.tarea.infrastructure.auth.adapters.out.persistence.repositories.RefreshTokenJpaRepository;
import com.tarea.infrastructure.auth.adapters.out.persistence.repositories.RefreshTokenRepositoryAdapter;
import com.tarea.infrastructure.auth.adapters.out.persistence.repositories.UserJpaRepository;
import com.tarea.infrastructure.auth.adapters.out.persistence.repositories.UserRepositoryAdapter;
import com.tarea.infrastructure.auth.adapters.out.security.BCryptPasswordService;
import com.tarea.infrastructure.auth.adapters.out.security.JwtTokenService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;

import java.time.Duration;

@Configuration
public class AuthBeansConfig {

    @Bean
    public UserPersistenceMapper userPersistenceMapper() {
        return new UserPersistenceMapper();
    }

    @Bean
    public RefreshTokenPersistenceMapper refreshTokenPersistenceMapper() {
        return new RefreshTokenPersistenceMapper();
    }

    @Bean
    public UserRepository userRepository(UserJpaRepository repository, UserPersistenceMapper mapper) {
        return new UserRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RefreshTokenRepository refreshTokenRepository(RefreshTokenJpaRepository repository,
                                                         RefreshTokenPersistenceMapper mapper) {
        return new RefreshTokenRepositoryAdapter(repository, mapper);
    }

    @Bean
    public PasswordService passwordService(PasswordEncoder passwordEncoder) {
        return new BCryptPasswordService(passwordEncoder);
    }

    @Bean
    public TokenService tokenService(JwtEncoder jwtEncoder,
                                     @Value("${jwt.access-token-expiration}") Duration accessTokenExpiration,
                                     @Value("${jwt.refresh-token-expiration}") Duration refreshTokenExpiration) {
        return new JwtTokenService(jwtEncoder, accessTokenExpiration, refreshTokenExpiration);
    }

    @Bean
    public TokenIssuer tokenIssuer(TokenService tokenService, RefreshTokenRepository refreshTokenRepository) {
        return new TokenIssuer(tokenService, refreshTokenRepository);
    }

    @Bean
    public LoginUseCase loginUseCase(UserRepository userRepository, PasswordService passwordService,
                                     TokenIssuer tokenIssuer) {
        return new LoginUseCase(userRepository, passwordService, tokenIssuer);
    }

    @Bean
    public RefreshTokenUseCase refreshTokenUseCase(RefreshTokenRepository refreshTokenRepository,
                                                   UserRepository userRepository, TokenIssuer tokenIssuer) {
        return new RefreshTokenUseCase(refreshTokenRepository, userRepository, tokenIssuer);
    }

    @Bean
    public LogoutUseCase logoutUseCase(RefreshTokenRepository refreshTokenRepository) {
        return new LogoutUseCase(refreshTokenRepository);
    }

    @Bean
    public GetCurrentUserUseCase getCurrentUserUseCase(UserRepository userRepository) {
        return new GetCurrentUserUseCase(userRepository);
    }

    @Bean
    public ChangePasswordUseCase changePasswordUseCase(UserRepository userRepository,
                                                       RefreshTokenRepository refreshTokenRepository,
                                                       PasswordService passwordService) {
        return new ChangePasswordUseCase(userRepository, refreshTokenRepository, passwordService);
    }

    @Bean
    public RegisterUserUseCase registerUserUseCase(UserRepository userRepository, PasswordService passwordService) {
        return new RegisterUserUseCase(userRepository, passwordService);
    }

    @Bean
    public ListUserUseCase listUserUseCase(UserRepository userRepository) {
        return new ListUserUseCase(userRepository);
    }
}
