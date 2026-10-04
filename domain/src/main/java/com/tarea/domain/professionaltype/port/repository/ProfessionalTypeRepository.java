package com.tarea.domain.professionaltype.port.repository;

import com.tarea.domain.professionaltype.model.aggregate.ProfessionalType;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;

import java.util.List;
import java.util.Optional;

public interface ProfessionalTypeRepository {
    ProfessionalType save(ProfessionalType professionalType);
    Optional<ProfessionalType> findById(ProfessionalTypeId id);
    List<ProfessionalType> findAll();
    boolean existsByName(String name);
    void delete(ProfessionalType professionalType);
}
