package com.tarea.infrastructure.relationshiptype.adapters.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "relationship_types")
public class RelationshipTypeJpaEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "description", length = 50, nullable = false, unique = true)
    private String description;

    public RelationshipTypeJpaEntity() {
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
