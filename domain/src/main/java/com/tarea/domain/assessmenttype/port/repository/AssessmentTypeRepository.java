package com.tarea.domain.assessmenttype.port.repository;

import com.tarea.domain.assessmenttype.model.aggregate.AssessmentType;
import com.tarea.domain.assessmenttype.model.valueobject.AssessmentTypeId;

import java.util.List;
import java.util.Optional;

public interface AssessmentTypeRepository {
    AssessmentType save(AssessmentType assessmentType);
    Optional<AssessmentType> findById(AssessmentTypeId id);
    List<AssessmentType> findAll();
    boolean existsByCode(String code);
    void delete(AssessmentType assessmentType);
}
