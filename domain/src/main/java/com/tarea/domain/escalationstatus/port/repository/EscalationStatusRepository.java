package com.tarea.domain.escalationstatus.port.repository;

import com.tarea.domain.escalationstatus.model.aggregate.EscalationStatus;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;

import java.util.List;
import java.util.Optional;

public interface EscalationStatusRepository {
    EscalationStatus save(EscalationStatus escalationStatus);
    Optional<EscalationStatus> findById(EscalationStatusId id);
    List<EscalationStatus> findAll();
    void delete(EscalationStatus escalationStatus);
}
