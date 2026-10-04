package com.tarea.domain.phonecontact.port.repository;

import com.tarea.domain.phonecontact.model.aggregate.PhoneContact;
import com.tarea.domain.phonecontact.model.valueobject.PhoneContactId;

import java.util.List;
import java.util.Optional;

public interface PhoneContactRepository {
    PhoneContact save(PhoneContact phoneContact);
    Optional<PhoneContact> findById(PhoneContactId id);
    List<PhoneContact> findAll();
    void delete(PhoneContact phoneContact);
}
