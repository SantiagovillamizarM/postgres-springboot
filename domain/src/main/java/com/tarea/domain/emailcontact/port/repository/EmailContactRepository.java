package com.tarea.domain.emailcontact.port.repository;

import com.tarea.domain.emailcontact.model.aggregate.EmailContact;
import com.tarea.domain.emailcontact.model.valueobject.EmailContactId;

import java.util.List;
import java.util.Optional;

public interface EmailContactRepository {
    EmailContact save(EmailContact emailContact);
    Optional<EmailContact> findById(EmailContactId id);
    List<EmailContact> findAll();
    boolean existsByEmail(String email);
    void delete(EmailContact emailContact);
}
