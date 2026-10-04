package com.tarea.infrastructure.citymunicipality.adapters.out.persistence.repositories;

import com.tarea.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.citymunicipality.port.repository.CityMunicipalityRepository;
import com.tarea.infrastructure.citymunicipality.adapters.out.persistence.entity.CityMunicipalityJpaEntity;
import com.tarea.infrastructure.citymunicipality.adapters.out.persistence.mappers.CityMunicipalityPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class CityMunicipalityRepositoryAdapter implements CityMunicipalityRepository {

    private final CityMunicipalityJpaRepository cityMunicipalityJpaRepository;
    private final CityMunicipalityPersistenceMapper mapper;

    public CityMunicipalityRepositoryAdapter(CityMunicipalityJpaRepository cityMunicipalityJpaRepository, CityMunicipalityPersistenceMapper mapper) {
        this.cityMunicipalityJpaRepository = cityMunicipalityJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public CityMunicipality save(CityMunicipality cityMunicipality) {
        CityMunicipalityJpaEntity entity = mapper.toJpa(cityMunicipality);
        CityMunicipalityJpaEntity saved = cityMunicipalityJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<CityMunicipality> findById(CityMunicipalityId id) {
        return cityMunicipalityJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<CityMunicipality> findAll() {
        return cityMunicipalityJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(CityMunicipality cityMunicipality) {
        cityMunicipalityJpaRepository.deleteById(cityMunicipality.id().value());
    }
}
