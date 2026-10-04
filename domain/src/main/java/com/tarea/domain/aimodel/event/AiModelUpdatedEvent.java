package com.tarea.domain.aimodel.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;

import java.time.LocalDateTime;
import java.util.Objects;

public record AiModelUpdatedEvent(
        AiModelId id,
        ProviderModelAiId providerModelId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public AiModelUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(providerModelId, "El proveedor no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
