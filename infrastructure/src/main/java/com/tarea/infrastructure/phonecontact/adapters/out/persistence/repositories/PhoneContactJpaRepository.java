package com.tarea.infrastructure.phonecontact.adapters.out.persistence.repositories;

import com.tarea.infrastructure.phonecontact.adapters.out.persistence.entity.PhoneContactJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhoneContactJpaRepository extends JpaRepository<PhoneContactJpaEntity, UUID> {}
