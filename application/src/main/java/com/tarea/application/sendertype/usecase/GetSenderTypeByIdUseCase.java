package com.tarea.application.sendertype.usecase;

import com.tarea.application.sendertype.dto.SenderTypeResponse;
import com.tarea.application.sendertype.exception.SenderTypeNotFoundApplicationException;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;
import com.tarea.domain.sendertype.port.repository.SenderTypeRepository;

public class GetSenderTypeByIdUseCase {

    private final SenderTypeRepository senderTypeRepository;

    public GetSenderTypeByIdUseCase(SenderTypeRepository senderTypeRepository) {
        this.senderTypeRepository = senderTypeRepository;
    }

    public SenderTypeResponse execute(SenderTypeId id) {
        var senderType = senderTypeRepository.findById(id)
                .orElseThrow(() -> new SenderTypeNotFoundApplicationException(id.value().toString()));

        return new SenderTypeResponse(
            senderType.id().value(),
            senderType.nameType(),
            senderType.createdAt(),
            senderType.updatedAt()
        );
    }
}
