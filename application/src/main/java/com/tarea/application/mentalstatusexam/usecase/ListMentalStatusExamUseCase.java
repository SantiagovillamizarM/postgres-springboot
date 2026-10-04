package com.tarea.application.mentalstatusexam.usecase;

import com.tarea.application.mentalstatusexam.dto.MentalStatusExamResponse;
import com.tarea.domain.mentalstatusexam.port.repository.MentalStatusExamRepository;

import java.util.List;

public class ListMentalStatusExamUseCase {

    private final MentalStatusExamRepository mentalStatusExamRepository;

    public ListMentalStatusExamUseCase(MentalStatusExamRepository mentalStatusExamRepository) {
        this.mentalStatusExamRepository = mentalStatusExamRepository;
    }

    public List<MentalStatusExamResponse> execute() {
        return mentalStatusExamRepository.findAll().stream()
                .map(mentalStatusExam -> new MentalStatusExamResponse(
                    mentalStatusExam.id().value(),
                    mentalStatusExam.encounterId().value(),
                    mentalStatusExam.appearance(),
                    mentalStatusExam.behavior(),
                    mentalStatusExam.attitude(),
                    mentalStatusExam.consciousness(),
                    mentalStatusExam.orientation(),
                    mentalStatusExam.attention(),
                    mentalStatusExam.memory(),
                    mentalStatusExam.speech(),
                    mentalStatusExam.mood(),
                    mentalStatusExam.affect(),
                    mentalStatusExam.thoughtProcess(),
                    mentalStatusExam.thoughtContent(),
                    mentalStatusExam.perception(),
                    mentalStatusExam.judgment(),
                    mentalStatusExam.insight(),
                    mentalStatusExam.psychomotorActivity(),
                    mentalStatusExam.observations(),
                    mentalStatusExam.createdBy().value(),
                    mentalStatusExam.createdAt()
                ))
                .toList();
    }
}
