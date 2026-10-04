package com.tarea.domain.professionalstudy.port.repository;

import com.tarea.domain.professionalstudy.model.aggregate.ProfessionalStudy;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;

import java.util.List;
import java.util.Optional;

public interface ProfessionalStudyRepository {
    ProfessionalStudy save(ProfessionalStudy professionalStudy);
    Optional<ProfessionalStudy> findById(ProfessionalStudyId id);
    List<ProfessionalStudy> findAll();
    void delete(ProfessionalStudy professionalStudy);
}
