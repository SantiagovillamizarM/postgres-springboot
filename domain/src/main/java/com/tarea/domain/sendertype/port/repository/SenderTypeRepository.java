package com.tarea.domain.sendertype.port.repository;

import com.tarea.domain.sendertype.model.aggregate.SenderType;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;

import java.util.List;
import java.util.Optional;

public interface SenderTypeRepository {
    SenderType save(SenderType senderType);
    Optional<SenderType> findById(SenderTypeId id);
    List<SenderType> findAll();
    void delete(SenderType senderType);
}
