package com.tarea.domain.risklevel.port.repository;

import com.tarea.domain.risklevel.model.aggregate.RiskLevel;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;

import java.util.List;
import java.util.Optional;

public interface RiskLevelRepository {
    RiskLevel save(RiskLevel riskLevel);
    Optional<RiskLevel> findById(RiskLevelId id);
    List<RiskLevel> findAll();
    boolean existsByCode(String code);
    void delete(RiskLevel riskLevel);
}
