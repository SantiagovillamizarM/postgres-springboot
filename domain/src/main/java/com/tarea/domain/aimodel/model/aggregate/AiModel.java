package com.tarea.domain.aimodel.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.tarea.domain.aimodel.event.AiModelDeletedEvent;
import com.tarea.domain.aimodel.event.AiModelRegisteredEvent;
import com.tarea.domain.aimodel.event.AiModelUpdatedEvent;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class AiModel extends AggregateRoot {
    private final AiModelId id;
    private ProviderModelAiId providerModelId;
    private String nameModel;
    private String modelKey;
    private BigDecimal inputTokenPrice;
    private BigDecimal outputTokenPrice;
    private Integer maxTokens;
    private Integer contextWindow;
    private boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private AiModel(AiModelId id, ProviderModelAiId providerModelId, String nameModel, String modelKey,
                    BigDecimal inputTokenPrice, BigDecimal outputTokenPrice, Integer maxTokens,
                    Integer contextWindow, boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.providerModelId = Objects.requireNonNull(providerModelId, "El proveedor no puede ser nulo");
        this.nameModel = nameModel;
        this.modelKey = modelKey;
        this.inputTokenPrice = inputTokenPrice;
        this.outputTokenPrice = outputTokenPrice;
        this.maxTokens = maxTokens;
        this.contextWindow = contextWindow;
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static AiModel register(ProviderModelAiId providerModelId, String nameModel, String modelKey,
                                   BigDecimal inputTokenPrice, BigDecimal outputTokenPrice, Integer maxTokens,
                                   Integer contextWindow, Boolean active) {
        AiModelId id = AiModelId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        AiModel aiModel = new AiModel(id, providerModelId, nameModel, modelKey, inputTokenPrice,
                                      outputTokenPrice, maxTokens, contextWindow, activeValue, now, null);
        aiModel.recordEvent(new AiModelRegisteredEvent(id, now));
        return aiModel;
    }

    public static AiModel restore(AiModelId id, ProviderModelAiId providerModelId, String nameModel,
                                  String modelKey, BigDecimal inputTokenPrice, BigDecimal outputTokenPrice,
                                  Integer maxTokens, Integer contextWindow, boolean active,
                                  LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new AiModel(id, providerModelId, nameModel, modelKey, inputTokenPrice, outputTokenPrice,
                           maxTokens, contextWindow, active, createdAt, updatedAt);
    }

    public void update(ProviderModelAiId providerModelId, String nameModel, String modelKey,
                       BigDecimal inputTokenPrice, BigDecimal outputTokenPrice, Integer maxTokens,
                       Integer contextWindow, Boolean active) {
        this.providerModelId = Objects.requireNonNull(providerModelId, "El proveedor no puede ser nulo");
        this.nameModel = nameModel;
        this.modelKey = modelKey;
        this.inputTokenPrice = inputTokenPrice;
        this.outputTokenPrice = outputTokenPrice;
        this.maxTokens = maxTokens;
        this.contextWindow = contextWindow;
        if (active != null) {
            this.active = active;
        }
        this.updatedAt = LocalDateTime.now();

        recordEvent(new AiModelUpdatedEvent(this.id, this.providerModelId, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new AiModelDeletedEvent(this.id, LocalDateTime.now()));
    }

    public AiModelId id() { return id; }
    public ProviderModelAiId providerModelId() { return providerModelId; }
    public String nameModel() { return nameModel; }
    public String modelKey() { return modelKey; }
    public BigDecimal inputTokenPrice() { return inputTokenPrice; }
    public BigDecimal outputTokenPrice() { return outputTokenPrice; }
    public Integer maxTokens() { return maxTokens; }
    public Integer contextWindow() { return contextWindow; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
