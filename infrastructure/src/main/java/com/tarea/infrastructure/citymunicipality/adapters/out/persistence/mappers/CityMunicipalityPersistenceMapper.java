package com.tarea.infrastructure.citymunicipality.adapters.out.persistence.mappers;

import com.tarea.domain.stateregion.model.valueobject.StateRegionId;
import com.tarea.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.infrastructure.citymunicipality.adapters.out.persistence.entity.CityMunicipalityJpaEntity;

public class CityMunicipalityPersistenceMapper {

    public CityMunicipalityJpaEntity toJpa(CityMunicipality domain) {
        if (domain == null) {
            return null;
        }

        CityMunicipalityJpaEntity jpa = new CityMunicipalityJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setNameCity(domain.nameCity());
        jpa.setCodeCity(domain.codeCity());
        jpa.setDescription(domain.description());
        jpa.setActive(domain.active());
        jpa.setRegionId(domain.regionId().value());
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public CityMunicipality toDomain(CityMunicipalityJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return CityMunicipality.restore(
                new CityMunicipalityId(jpa.getId()),
                jpa.getNameCity(),
                jpa.getCodeCity(),
                jpa.getDescription(),
                jpa.getActive() != null ? jpa.getActive() : true,
                new StateRegionId(jpa.getRegionId()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
