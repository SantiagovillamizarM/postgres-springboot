package com.tarea.infrastructure.auth.adapters.out.persistence.repositories;

import com.tarea.domain.auth.model.aggregate.User;
import com.tarea.domain.auth.model.valueobject.Role;
import com.tarea.domain.auth.model.valueobject.UserId;
import com.tarea.domain.auth.port.repository.UserRepository;
import com.tarea.infrastructure.auth.adapters.out.persistence.entity.UserJpaEntity;
import com.tarea.infrastructure.auth.adapters.out.persistence.mappers.UserPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class UserRepositoryAdapter implements UserRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserPersistenceMapper mapper;

    public UserRepositoryAdapter(UserJpaRepository userJpaRepository, UserPersistenceMapper mapper) {
        this.userJpaRepository = userJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public User save(User user) {
        UserJpaEntity entity = mapper.toJpa(user);
        UserJpaEntity saved = userJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<User> findById(UserId id) {
        return userJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .map(mapper::toDomain);
    }

    @Override
    public List<User> findAll() {
        return userJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByRole(Role role) {
        return userJpaRepository.existsByRole(role.name());
    }
}
