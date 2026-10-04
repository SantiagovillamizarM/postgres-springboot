package com.tarea.infrastructure.contact.adapters.out.persistence.repositories;

import com.tarea.domain.contact.model.aggregate.Contact;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.contact.port.repository.ContactRepository;
import com.tarea.infrastructure.contact.adapters.out.persistence.entity.ContactJpaEntity;
import com.tarea.infrastructure.contact.adapters.out.persistence.mappers.ContactPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ContactRepositoryAdapter implements ContactRepository {

    private final ContactJpaRepository contactJpaRepository;
    private final ContactPersistenceMapper mapper;

    public ContactRepositoryAdapter(ContactJpaRepository contactJpaRepository, ContactPersistenceMapper mapper) {
        this.contactJpaRepository = contactJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Contact save(Contact contact) {
        ContactJpaEntity entity = mapper.toJpa(contact);
        ContactJpaEntity saved = contactJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Contact> findById(ContactId id) {
        return contactJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<Contact> findAll() {
        return contactJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(Contact contact) {
        contactJpaRepository.deleteById(contact.id().value());
    }
}
