package com.tarea.infrastructure.professional.adapters.out.persistence.mappers;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.tarea.domain.professional.model.aggregate.Professional;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.infrastructure.professional.adapters.out.persistence.entity.ProfessionalJpaEntity;

public class ProfessionalPersistenceMapper {

    public ProfessionalJpaEntity toJpa(Professional domain) {
        if (domain == null) {
            return null;
        }

        ProfessionalJpaEntity jpa = new ProfessionalJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setDocumentTypeId(domain.documentTypeId().value());
        jpa.setDocumentNumber(domain.documentNumber());
        jpa.setFirstName(domain.firstName());
        jpa.setLastName(domain.lastName());
        jpa.setProfessionalTypeId(domain.professionalTypeId().value());
        jpa.setLicenseNumber(domain.licenseNumber());
        jpa.setActive(domain.active());
        jpa.setCityId(domain.cityId().value());
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public Professional toDomain(ProfessionalJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return Professional.restore(
                new ProfessionalId(jpa.getId()),
                new DocumentTypeId(jpa.getDocumentTypeId()),
                jpa.getDocumentNumber(),
                jpa.getFirstName(),
                jpa.getLastName(),
                new ProfessionalTypeId(jpa.getProfessionalTypeId()),
                jpa.getLicenseNumber(),
                jpa.getActive() != null ? jpa.getActive() : true,
                new CityMunicipalityId(jpa.getCityId()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
