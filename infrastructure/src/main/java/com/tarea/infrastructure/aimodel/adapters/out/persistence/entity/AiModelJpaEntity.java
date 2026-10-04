package com.tarea.infrastructure.aimodel.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "ai_models")
public class AiModelJpaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "provider_model_id", nullable = false)
    private UUID providerModelId;

    @Column(name = "name_model", length = 100)
    private String nameModel;

    @Column(name = "model_key", length = 120)
    private String modelKey;

    @Column(name = "input_token_price", precision = 12, scale = 8)
    private BigDecimal inputTokenPrice;

    @Column(name = "output_token_price", precision = 12, scale = 8)
    private BigDecimal outputTokenPrice;

    @Column(name = "max_tokens")
    private Integer maxTokens;

    @Column(name = "context_window")
    private Integer contextWindow;

    @Column(name = "is_active")
    private Boolean active;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public AiModelJpaEntity() {
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getProviderModelId() { return providerModelId; }
    public void setProviderModelId(UUID providerModelId) { this.providerModelId = providerModelId; }

    public String getNameModel() { return nameModel; }
    public void setNameModel(String nameModel) { this.nameModel = nameModel; }

    public String getModelKey() { return modelKey; }
    public void setModelKey(String modelKey) { this.modelKey = modelKey; }

    public BigDecimal getInputTokenPrice() { return inputTokenPrice; }
    public void setInputTokenPrice(BigDecimal inputTokenPrice) { this.inputTokenPrice = inputTokenPrice; }

    public BigDecimal getOutputTokenPrice() { return outputTokenPrice; }
    public void setOutputTokenPrice(BigDecimal outputTokenPrice) { this.outputTokenPrice = outputTokenPrice; }

    public Integer getMaxTokens() { return maxTokens; }
    public void setMaxTokens(Integer maxTokens) { this.maxTokens = maxTokens; }

    public Integer getContextWindow() { return contextWindow; }
    public void setContextWindow(Integer contextWindow) { this.contextWindow = contextWindow; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
