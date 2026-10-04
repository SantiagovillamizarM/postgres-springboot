package com.tarea.infrastructure.citymunicipality.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "city_municipalities")
public class CityMunicipalityJpaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name_city", length = 50)
    private String nameCity;

    @Column(name = "code_city", length = 10)
    private String codeCity;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "is_active")
    private Boolean active;

    @Column(name = "region_id", nullable = false)
    private UUID regionId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CityMunicipalityJpaEntity() {
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNameCity() { return nameCity; }
    public void setNameCity(String nameCity) { this.nameCity = nameCity; }

    public String getCodeCity() { return codeCity; }
    public void setCodeCity(String codeCity) { this.codeCity = codeCity; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public UUID getRegionId() { return regionId; }
    public void setRegionId(UUID regionId) { this.regionId = regionId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
