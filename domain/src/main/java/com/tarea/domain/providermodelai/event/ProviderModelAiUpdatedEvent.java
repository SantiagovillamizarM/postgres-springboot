package com.tarea.domain.providermodelai.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProviderModelAiUpdatedEvent(
        ProviderModelAiId id,
        String nameProviderAi,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ProviderModelAiUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(nameProviderAi, "El nombre del proveedor no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
