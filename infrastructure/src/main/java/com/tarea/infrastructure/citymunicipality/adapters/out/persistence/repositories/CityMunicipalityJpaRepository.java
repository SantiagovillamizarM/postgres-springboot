package com.tarea.infrastructure.citymunicipality.adapters.out.persistence.repositories;

import com.tarea.infrastructure.citymunicipality.adapters.out.persistence.entity.CityMunicipalityJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CityMunicipalityJpaRepository extends JpaRepository<CityMunicipalityJpaEntity, UUID> {}
