package com.tarea.domain.stateregion.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.stateregion.event.StateRegionDeletedEvent;
import com.tarea.domain.stateregion.event.StateRegionRegisteredEvent;
import com.tarea.domain.stateregion.event.StateRegionUpdatedEvent;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;

import java.time.LocalDateTime;
import java.util.Objects;

public class StateRegion extends AggregateRoot {
    private final StateRegionId id;
    private String nameRegion;
    private String codeRegion;
    private String description;
    private boolean active;
    private CountryId countryId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private StateRegion(StateRegionId id, String nameRegion, String codeRegion, String description,
                        boolean active, CountryId countryId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.nameRegion = Objects.requireNonNull(nameRegion, "El nombre de la región no puede ser nulo");
        this.codeRegion = Objects.requireNonNull(codeRegion, "El código de la región no puede ser nulo");
        this.description = description;
        this.active = active;
        this.countryId = Objects.requireNonNull(countryId, "El país no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static StateRegion register(String nameRegion, String codeRegion, String description,
                                       Boolean active, CountryId countryId) {
        StateRegionId id = StateRegionId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        StateRegion stateRegion = new StateRegion(id, nameRegion, codeRegion, description, activeValue, countryId, now, null);
        stateRegion.recordEvent(new StateRegionRegisteredEvent(id, now));
        return stateRegion;
    }

    public static StateRegion restore(StateRegionId id, String nameRegion, String codeRegion,
                                      String description, boolean active, CountryId countryId,
                                      LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new StateRegion(id, nameRegion, codeRegion, description, active, countryId, createdAt, updatedAt);
    }

    public void update(String nameRegion, String codeRegion, String description, Boolean active,
                       CountryId countryId) {
        this.nameRegion = Objects.requireNonNull(nameRegion, "El nombre de la región no puede ser nulo");
        this.codeRegion = Objects.requireNonNull(codeRegion, "El código de la región no puede ser nulo");
        this.description = description;
        if (active != null) {
            this.active = active;
        }
        this.countryId = Objects.requireNonNull(countryId, "El país no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new StateRegionUpdatedEvent(this.id, this.nameRegion, this.codeRegion, this.countryId, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new StateRegionDeletedEvent(this.id, LocalDateTime.now()));
    }

    public StateRegionId id() { return id; }
    public String nameRegion() { return nameRegion; }
    public String codeRegion() { return codeRegion; }
    public String description() { return description; }
    public boolean active() { return active; }
    public CountryId countryId() { return countryId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
