package com.tarea.domain.chatairunmetric.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatAiRunMetricDeletedEvent(ChatAiRunMetricId id, LocalDateTime occurredOn) implements DomainEvent {
    public ChatAiRunMetricDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
