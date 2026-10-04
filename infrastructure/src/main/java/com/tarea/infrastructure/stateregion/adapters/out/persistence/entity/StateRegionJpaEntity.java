package com.tarea.infrastructure.stateregion.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "state_regions")
public class StateRegionJpaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name_region", length = 50)
    private String nameRegion;

    @Column(name = "code_region", length = 10)
    private String codeRegion;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "is_active")
    private Boolean active;

    @Column(name = "country_id", nullable = false)
    private UUID countryId;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public StateRegionJpaEntity() {
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getNameRegion() { return nameRegion; }
    public void setNameRegion(String nameRegion) { this.nameRegion = nameRegion; }

    public String getCodeRegion() { return codeRegion; }
    public void setCodeRegion(String codeRegion) { this.codeRegion = codeRegion; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public UUID getCountryId() { return countryId; }
    public void setCountryId(UUID countryId) { this.countryId = countryId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
