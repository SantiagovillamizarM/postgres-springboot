package com.tarea.domain.patient.port.repository;

import com.tarea.domain.patient.model.aggregate.Patient;
import com.tarea.domain.patient.model.valueobject.PatientId;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {
    Patient save(Patient patient);
    Optional<Patient> findById(PatientId id);
    List<Patient> findAll();
    boolean existsByEmail(String email);
    void delete(Patient patient);
}
