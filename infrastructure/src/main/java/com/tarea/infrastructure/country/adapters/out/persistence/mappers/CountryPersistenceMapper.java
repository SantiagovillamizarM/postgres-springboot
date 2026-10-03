package com.tarea.infrastructure.country.adapters.out.persistence.mappers;

import com.tarea.domain.country.model.aggregate.Country;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.infrastructure.country.adapters.out.persistence.entity.CountryJpaEntity;

public class CountryPersistenceMapper {

    public CountryJpaEntity toJpa(Country domain) {
        if (domain == null) {
            return null;
        }

        CountryJpaEntity jpa = new CountryJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setNameCountry(domain.nameCountry());
        jpa.setCodeCountry(domain.codeCountry());
        jpa.setDescription(domain.description());
        jpa.setActive(domain.isActive());
        jpa.setTelephonePrefix(domain.telephonePrefix());
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public Country toDomain(CountryJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return Country.restore(
                new CountryId(jpa.getId()),
                jpa.getNameCountry(),
                jpa.getCodeCountry(),
                jpa.getDescription(),
                jpa.getActive() != null ? jpa.getActive() : true,
                jpa.getTelephonePrefix(),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
