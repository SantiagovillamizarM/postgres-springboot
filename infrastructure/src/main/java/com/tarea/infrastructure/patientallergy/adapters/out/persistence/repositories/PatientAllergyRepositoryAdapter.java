package com.tarea.infrastructure.patientallergy.adapters.out.persistence.repositories;

import com.tarea.domain.patientallergy.model.aggregate.PatientAllergy;
import com.tarea.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.tarea.domain.patientallergy.port.repository.PatientAllergyRepository;
import com.tarea.infrastructure.patientallergy.adapters.out.persistence.entity.PatientAllergyJpaEntity;
import com.tarea.infrastructure.patientallergy.adapters.out.persistence.mappers.PatientAllergyPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class PatientAllergyRepositoryAdapter implements PatientAllergyRepository {

    private final PatientAllergyJpaRepository patientAllergyJpaRepository;
    private final PatientAllergyPersistenceMapper mapper;

    public PatientAllergyRepositoryAdapter(PatientAllergyJpaRepository patientAllergyJpaRepository, PatientAllergyPersistenceMapper mapper) {
        this.patientAllergyJpaRepository = patientAllergyJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public PatientAllergy save(PatientAllergy patientAllergy) {
        PatientAllergyJpaEntity entity = mapper.toJpa(patientAllergy);
        PatientAllergyJpaEntity saved = patientAllergyJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<PatientAllergy> findById(PatientAllergyId id) {
        return patientAllergyJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<PatientAllergy> findAll() {
        return patientAllergyJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(PatientAllergy patientAllergy) {
        patientAllergyJpaRepository.deleteById(patientAllergy.id().value());
    }
}
