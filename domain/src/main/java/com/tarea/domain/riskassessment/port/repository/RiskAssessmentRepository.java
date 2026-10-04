package com.tarea.domain.riskassessment.port.repository;

import com.tarea.domain.riskassessment.model.aggregate.RiskAssessment;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;

import java.util.List;
import java.util.Optional;

public interface RiskAssessmentRepository {
    RiskAssessment save(RiskAssessment riskAssessment);
    Optional<RiskAssessment> findById(RiskAssessmentId id);
    List<RiskAssessment> findAll();
    void delete(RiskAssessment riskAssessment);
}
