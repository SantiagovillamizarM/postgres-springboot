package com.tarea.domain.auth.port.repository;

import com.tarea.domain.auth.model.aggregate.User;
import com.tarea.domain.auth.model.valueobject.Role;
import com.tarea.domain.auth.model.valueobject.UserId;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UserId id);
    Optional<User> findByEmail(String email);
    List<User> findAll();
    boolean existsByEmail(String email);
    boolean existsByRole(Role role);
}
