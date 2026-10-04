package com.tarea.domain.consenttype.port.repository;

import com.tarea.domain.consenttype.model.aggregate.ConsentType;
import com.tarea.domain.consenttype.model.valueobject.ConsentTypeId;

import java.util.List;
import java.util.Optional;

public interface ConsentTypeRepository {
    ConsentType save(ConsentType consentType);
    Optional<ConsentType> findById(ConsentTypeId id);
    List<ConsentType> findAll();
    boolean existsByCode(String code);
    void delete(ConsentType consentType);
}
