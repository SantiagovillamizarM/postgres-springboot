package com.tarea.infrastructure.providermodelai.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "provider_models_ai")
public class ProviderModelAiJpaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name_provider_ai", length = 100)
    private String nameProviderAi;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "sitio_web", columnDefinition = "TEXT")
    private String sitioWeb;

    @Column(name = "is_active")
    private Boolean active;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public ProviderModelAiJpaEntity() {
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNameProviderAi() { return nameProviderAi; }
    public void setNameProviderAi(String nameProviderAi) { this.nameProviderAi = nameProviderAi; }

    public String getRazonSocial() { return razonSocial; }
    public void setRazonSocial(String razonSocial) { this.razonSocial = razonSocial; }

    public String getSitioWeb() { return sitioWeb; }
    public void setSitioWeb(String sitioWeb) { this.sitioWeb = sitioWeb; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
