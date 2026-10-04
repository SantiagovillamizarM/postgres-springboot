package com.tarea.domain.chatairunmetric.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatAiRunMetricUpdatedEvent(
        ChatAiRunMetricId id,
        ChatAiRunId aiRunId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ChatAiRunMetricUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(aiRunId, "La ejecución de IA no puede ser nula");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
