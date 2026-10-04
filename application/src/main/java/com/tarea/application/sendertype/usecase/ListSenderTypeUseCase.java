package com.tarea.application.sendertype.usecase;

import com.tarea.application.sendertype.dto.SenderTypeResponse;
import com.tarea.domain.sendertype.port.repository.SenderTypeRepository;

import java.util.List;

public class ListSenderTypeUseCase {

    private final SenderTypeRepository senderTypeRepository;

    public ListSenderTypeUseCase(SenderTypeRepository senderTypeRepository) {
        this.senderTypeRepository = senderTypeRepository;
    }

    public List<SenderTypeResponse> execute() {
        return senderTypeRepository.findAll().stream()
                .map(senderType -> new SenderTypeResponse(
                    senderType.id().value(),
                    senderType.nameType(),
                    senderType.createdAt(),
                    senderType.updatedAt()
                ))
                .toList();
    }
}
