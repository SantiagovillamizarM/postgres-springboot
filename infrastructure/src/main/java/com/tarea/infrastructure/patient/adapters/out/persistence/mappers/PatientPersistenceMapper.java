package com.tarea.infrastructure.patient.adapters.out.persistence.mappers;

import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.gender.model.valueobject.GenderId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.patient.model.aggregate.Patient;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.infrastructure.patient.adapters.out.persistence.entity.PatientJpaEntity;

public class PatientPersistenceMapper {

    public PatientJpaEntity toJpa(Patient domain) {
        if (domain == null) {
            return null;
        }

        PatientJpaEntity jpa = new PatientJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setDocumentTypeId(domain.documentTypeId().value());
        jpa.setDocumentNumber(domain.documentNumber());
        jpa.setFirstName(domain.firstName());
        jpa.setMiddleName(domain.middleName());
        jpa.setLastName(domain.lastName());
        jpa.setSecondLastName(domain.secondLastName());
        jpa.setBirthDate(domain.birthDate());
        jpa.setBiologicalSexId(domain.biologicalSexId().value());
        jpa.setGenderIdentityId(domain.genderIdentityId().value());
        jpa.setEmail(domain.email());
        jpa.setPhone(domain.phone());
        jpa.setAddress(domain.address());
        jpa.setActive(domain.active());
        jpa.setCreatedBy(domain.createdBy() != null ? domain.createdBy().value() : null);
        jpa.setUpdatedBy(domain.updatedBy() != null ? domain.updatedBy().value() : null);
        jpa.setCityId(domain.cityId().value());
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public Patient toDomain(PatientJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return Patient.restore(
                new PatientId(jpa.getId()),
                new DocumentTypeId(jpa.getDocumentTypeId()),
                jpa.getDocumentNumber(),
                jpa.getFirstName(),
                jpa.getMiddleName(),
                jpa.getLastName(),
                jpa.getSecondLastName(),
                jpa.getBirthDate(),
                new GenderId(jpa.getBiologicalSexId()),
                new GenderId(jpa.getGenderIdentityId()),
                jpa.getEmail(),
                jpa.getPhone(),
                jpa.getAddress(),
                jpa.getActive() != null ? jpa.getActive() : true,
                jpa.getCreatedBy() != null ? new ProfessionalId(jpa.getCreatedBy()) : null,
                jpa.getUpdatedBy() != null ? new ProfessionalId(jpa.getUpdatedBy()) : null,
                new CityMunicipalityId(jpa.getCityId()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
