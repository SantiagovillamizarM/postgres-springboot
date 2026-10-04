package com.tarea.domain.patientcontact.port.repository;

import com.tarea.domain.patientcontact.model.aggregate.PatientContact;
import com.tarea.domain.patientcontact.model.valueobject.PatientContactId;

import java.util.List;
import java.util.Optional;

public interface PatientContactRepository {
    PatientContact save(PatientContact patientContact);
    Optional<PatientContact> findById(PatientContactId id);
    List<PatientContact> findAll();
    void delete(PatientContact patientContact);
}
