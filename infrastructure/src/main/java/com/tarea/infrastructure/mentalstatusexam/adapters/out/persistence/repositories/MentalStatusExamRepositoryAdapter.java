package com.tarea.infrastructure.mentalstatusexam.adapters.out.persistence.repositories;

import com.tarea.domain.mentalstatusexam.model.aggregate.MentalStatusExam;
import com.tarea.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.tarea.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;
import com.tarea.infrastructure.mentalstatusexam.adapters.out.persistence.entity.MentalStatusExamJpaEntity;
import com.tarea.infrastructure.mentalstatusexam.adapters.out.persistence.mappers.MentalStatusExamPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class MentalStatusExamRepositoryAdapter implements MentalStatusExamRepository {

    private final MentalStatusExamJpaRepository mentalStatusExamJpaRepository;
    private final MentalStatusExamPersistenceMapper mapper;

    public MentalStatusExamRepositoryAdapter(MentalStatusExamJpaRepository mentalStatusExamJpaRepository, MentalStatusExamPersistenceMapper mapper) {
        this.mentalStatusExamJpaRepository = mentalStatusExamJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public MentalStatusExam save(MentalStatusExam mentalStatusExam) {
        MentalStatusExamJpaEntity entity = mapper.toJpa(mentalStatusExam);
        MentalStatusExamJpaEntity saved = mentalStatusExamJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<MentalStatusExam> findById(MentalStatusExamId id) {
        return mentalStatusExamJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<MentalStatusExam> findAll() {
        return mentalStatusExamJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(MentalStatusExam mentalStatusExam) {
        mentalStatusExamJpaRepository.deleteById(mentalStatusExam.id().value());
    }
}
