package com.tarea.domain.chatairunmetric.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.domain.chatairunmetric.event.ChatAiRunMetricDeletedEvent;
import com.tarea.domain.chatairunmetric.event.ChatAiRunMetricRegisteredEvent;
import com.tarea.domain.chatairunmetric.event.ChatAiRunMetricUpdatedEvent;
import com.tarea.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class ChatAiRunMetric extends AggregateRoot {
    private final ChatAiRunMetricId id;
    private ChatAiRunId aiRunId;
    private Integer promptTokens;
    private Integer completionTokens;
    private Integer totalTokens;
    private BigDecimal cost;
    private final LocalDateTime createdAt;

    private ChatAiRunMetric(ChatAiRunMetricId id, ChatAiRunId aiRunId, Integer promptTokens,
                            Integer completionTokens, Integer totalTokens, BigDecimal cost,
                            LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.aiRunId = Objects.requireNonNull(aiRunId, "La ejecución de IA no puede ser nula");
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
        this.cost = cost;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
    }

    public static ChatAiRunMetric register(ChatAiRunId aiRunId, Integer promptTokens,
                                           Integer completionTokens, Integer totalTokens, BigDecimal cost) {
        ChatAiRunMetricId id = ChatAiRunMetricId.generate();
        LocalDateTime now = LocalDateTime.now();

        ChatAiRunMetric chatAiRunMetric = new ChatAiRunMetric(id, aiRunId, promptTokens, completionTokens,
                                                              totalTokens, cost, now);
        chatAiRunMetric.recordEvent(new ChatAiRunMetricRegisteredEvent(id, now));
        return chatAiRunMetric;
    }

    public static ChatAiRunMetric restore(ChatAiRunMetricId id, ChatAiRunId aiRunId, Integer promptTokens,
                                          Integer completionTokens, Integer totalTokens, BigDecimal cost,
                                          LocalDateTime createdAt) {
        return new ChatAiRunMetric(id, aiRunId, promptTokens, completionTokens, totalTokens, cost, createdAt);
    }

    public void update(ChatAiRunId aiRunId, Integer promptTokens, Integer completionTokens,
                       Integer totalTokens, BigDecimal cost) {
        this.aiRunId = Objects.requireNonNull(aiRunId, "La ejecución de IA no puede ser nula");
        this.promptTokens = promptTokens;
        this.completionTokens = completionTokens;
        this.totalTokens = totalTokens;
        this.cost = cost;

        recordEvent(new ChatAiRunMetricUpdatedEvent(this.id, this.aiRunId, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatAiRunMetricDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ChatAiRunMetricId id() { return id; }
    public ChatAiRunId aiRunId() { return aiRunId; }
    public Integer promptTokens() { return promptTokens; }
    public Integer completionTokens() { return completionTokens; }
    public Integer totalTokens() { return totalTokens; }
    public BigDecimal cost() { return cost; }
    public LocalDateTime createdAt() { return createdAt; }
}
