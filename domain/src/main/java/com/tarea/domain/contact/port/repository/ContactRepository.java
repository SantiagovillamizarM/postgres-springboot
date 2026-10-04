package com.tarea.domain.contact.port.repository;

import com.tarea.domain.contact.model.aggregate.Contact;
import com.tarea.domain.contact.model.valueobject.ContactId;

import java.util.List;
import java.util.Optional;

public interface ContactRepository {
    Contact save(Contact contact);
    Optional<Contact> findById(ContactId id);
    List<Contact> findAll();
    void delete(Contact contact);
}
