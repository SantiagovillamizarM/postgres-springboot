package com.tarea.application.mentalstatusexam.usecase;

import com.tarea.application.mentalstatusexam.exception.MentalStatusExamNotFoundApplicationException;
import com.tarea.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;
import com.tarea.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

public class DeleteMentalStatusExamUseCase {

    private final MentalStatusExamRepository mentalStatusExamRepository;

    public DeleteMentalStatusExamUseCase(MentalStatusExamRepository mentalStatusExamRepository) {
        this.mentalStatusExamRepository = mentalStatusExamRepository;
    }

    public void execute(MentalStatusExamId id) {
        var mentalStatusExam = mentalStatusExamRepository.findById(id)
                .orElseThrow(() -> new MentalStatusExamNotFoundApplicationException(id.value().toString()));

        mentalStatusExam.markAsDeleted();
        mentalStatusExamRepository.delete(mentalStatusExam);
    }
}
