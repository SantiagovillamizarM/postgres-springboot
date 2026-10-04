package com.tarea.infrastructure.medicationroute.adapters.out.persistence.repositories;

import com.tarea.domain.medicationroute.model.aggregate.MedicationRoute;
import com.tarea.domain.medicationroute.model.valueobject.MedicationRouteId;
import com.tarea.domain.medicationroute.port.repository.MedicationRouteRepository;
import com.tarea.infrastructure.medicationroute.adapters.out.persistence.entity.MedicationRouteJpaEntity;
import com.tarea.infrastructure.medicationroute.adapters.out.persistence.mappers.MedicationRoutePersistenceMapper;

import java.util.List;
import java.util.Optional;

public class MedicationRouteRepositoryAdapter implements MedicationRouteRepository {

    private final MedicationRouteJpaRepository medicationRouteJpaRepository;
    private final MedicationRoutePersistenceMapper mapper;

    public MedicationRouteRepositoryAdapter(MedicationRouteJpaRepository medicationRouteJpaRepository, MedicationRoutePersistenceMapper mapper) {
        this.medicationRouteJpaRepository = medicationRouteJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public MedicationRoute save(MedicationRoute medicationRoute) {
        MedicationRouteJpaEntity entity = mapper.toJpa(medicationRoute);
        MedicationRouteJpaEntity saved = medicationRouteJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<MedicationRoute> findById(MedicationRouteId id) {
        return medicationRouteJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<MedicationRoute> findAll() {
        return medicationRouteJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return medicationRouteJpaRepository.existsByCode(code);
    }

    @Override
    public void delete(MedicationRoute medicationRoute) {
        medicationRouteJpaRepository.deleteById(medicationRoute.id().value());
    }
}
