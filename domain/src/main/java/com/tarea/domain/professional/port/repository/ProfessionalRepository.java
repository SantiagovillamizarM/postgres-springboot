package com.tarea.domain.professional.port.repository;

import com.tarea.domain.professional.model.aggregate.Professional;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.util.List;
import java.util.Optional;

public interface ProfessionalRepository {
    Professional save(Professional professional);
    Optional<Professional> findById(ProfessionalId id);
    List<Professional> findAll();
    boolean existsByDocumentNumber(String documentNumber);
    void delete(Professional professional);
}
