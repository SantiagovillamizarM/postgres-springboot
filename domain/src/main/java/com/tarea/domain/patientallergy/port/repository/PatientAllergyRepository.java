package com.tarea.domain.patientallergy.port.repository;

import com.tarea.domain.patientallergy.model.aggregate.PatientAllergy;
import com.tarea.domain.patientallergy.model.valueobject.PatientAllergyId;

import java.util.List;
import java.util.Optional;

public interface PatientAllergyRepository {
    PatientAllergy save(PatientAllergy patientAllergy);
    Optional<PatientAllergy> findById(PatientAllergyId id);
    List<PatientAllergy> findAll();
    void delete(PatientAllergy patientAllergy);
}
