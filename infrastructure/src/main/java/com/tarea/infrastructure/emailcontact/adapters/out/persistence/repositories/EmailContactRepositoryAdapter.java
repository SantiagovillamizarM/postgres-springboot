package com.tarea.infrastructure.emailcontact.adapters.out.persistence.repositories;

import com.tarea.domain.emailcontact.model.aggregate.EmailContact;
import com.tarea.domain.emailcontact.model.valueobject.EmailContactId;
import com.tarea.domain.emailcontact.port.repository.EmailContactRepository;
import com.tarea.infrastructure.emailcontact.adapters.out.persistence.entity.EmailContactJpaEntity;
import com.tarea.infrastructure.emailcontact.adapters.out.persistence.mappers.EmailContactPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class EmailContactRepositoryAdapter implements EmailContactRepository {

    private final EmailContactJpaRepository emailContactJpaRepository;
    private final EmailContactPersistenceMapper mapper;

    public EmailContactRepositoryAdapter(EmailContactJpaRepository emailContactJpaRepository, EmailContactPersistenceMapper mapper) {
        this.emailContactJpaRepository = emailContactJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public EmailContact save(EmailContact emailContact) {
        EmailContactJpaEntity entity = mapper.toJpa(emailContact);
        EmailContactJpaEntity saved = emailContactJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EmailContact> findById(EmailContactId id) {
        return emailContactJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<EmailContact> findAll() {
        return emailContactJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByEmail(String email) {
        return emailContactJpaRepository.existsByEmail(email);
    }

    @Override
    public void delete(EmailContact emailContact) {
        emailContactJpaRepository.deleteById(emailContact.id().value());
    }
}
