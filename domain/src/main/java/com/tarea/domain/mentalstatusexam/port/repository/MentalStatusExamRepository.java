package com.tarea.domain.mentalstatusexam.port.repository;

import com.tarea.domain.mentalstatusexam.model.aggregate.MentalStatusExam;
import com.tarea.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;

import java.util.List;
import java.util.Optional;

public interface MentalStatusExamRepository {
    MentalStatusExam save(MentalStatusExam mentalStatusExam);
    Optional<MentalStatusExam> findById(MentalStatusExamId id);
    List<MentalStatusExam> findAll();
    void delete(MentalStatusExam mentalStatusExam);
}
