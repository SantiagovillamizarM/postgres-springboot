package com.tarea.infrastructure.country.adapters.out.persistence.repositories;

import com.tarea.infrastructure.country.adapters.out.persistence.entity.CountryJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CountryJpaRepository extends JpaRepository<CountryJpaEntity, UUID> {
    boolean existsByCodeCountry(String codeCountry);
}
