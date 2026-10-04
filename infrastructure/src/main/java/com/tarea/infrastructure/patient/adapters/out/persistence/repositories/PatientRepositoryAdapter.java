package com.tarea.infrastructure.patient.adapters.out.persistence.repositories;

import com.tarea.domain.patient.model.aggregate.Patient;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.patient.port.repository.PatientRepository;
import com.tarea.infrastructure.patient.adapters.out.persistence.entity.PatientJpaEntity;
import com.tarea.infrastructure.patient.adapters.out.persistence.mappers.PatientPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class PatientRepositoryAdapter implements PatientRepository {

    private final PatientJpaRepository patientJpaRepository;
    private final PatientPersistenceMapper mapper;

    public PatientRepositoryAdapter(PatientJpaRepository patientJpaRepository, PatientPersistenceMapper mapper) {
        this.patientJpaRepository = patientJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Patient save(Patient patient) {
        PatientJpaEntity entity = mapper.toJpa(patient);
        PatientJpaEntity saved = patientJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Patient> findById(PatientId id) {
        return patientJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<Patient> findAll() {
        return patientJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByEmail(String email) {
        return patientJpaRepository.existsByEmail(email);
    }

    @Override
    public void delete(Patient patient) {
        patientJpaRepository.deleteById(patient.id().value());
    }
}
