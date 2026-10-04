package com.tarea.domain.citymunicipality.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;
import com.tarea.domain.citymunicipality.event.CityMunicipalityDeletedEvent;
import com.tarea.domain.citymunicipality.event.CityMunicipalityRegisteredEvent;
import com.tarea.domain.citymunicipality.event.CityMunicipalityUpdatedEvent;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;

import java.time.LocalDateTime;
import java.util.Objects;

public class CityMunicipality extends AggregateRoot {
    private final CityMunicipalityId id;
    private String nameCity;
    private String codeCity;
    private String description;
    private boolean active;
    private StateRegionId regionId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private CityMunicipality(CityMunicipalityId id, String nameCity, String codeCity, String description,
                             boolean active, StateRegionId regionId, LocalDateTime createdAt,
                             LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.nameCity = Objects.requireNonNull(nameCity, "El nombre de la ciudad no puede ser nulo");
        this.codeCity = Objects.requireNonNull(codeCity, "El código de la ciudad no puede ser nulo");
        this.description = description;
        this.active = active;
        this.regionId = Objects.requireNonNull(regionId, "La región no puede ser nula");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static CityMunicipality register(String nameCity, String codeCity, String description,
                                            Boolean active, StateRegionId regionId) {
        CityMunicipalityId id = CityMunicipalityId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        CityMunicipality cityMunicipality = new CityMunicipality(id, nameCity, codeCity, description, activeValue, regionId, now, null);
        cityMunicipality.recordEvent(new CityMunicipalityRegisteredEvent(id, now));
        return cityMunicipality;
    }

    public static CityMunicipality restore(CityMunicipalityId id, String nameCity, String codeCity,
                                           String description, boolean active, StateRegionId regionId,
                                           LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new CityMunicipality(id, nameCity, codeCity, description, active, regionId, createdAt, updatedAt);
    }

    public void update(String nameCity, String codeCity, String description, Boolean active,
                       StateRegionId regionId) {
        this.nameCity = Objects.requireNonNull(nameCity, "El nombre de la ciudad no puede ser nulo");
        this.codeCity = Objects.requireNonNull(codeCity, "El código de la ciudad no puede ser nulo");
        this.description = description;
        if (active != null) {
            this.active = active;
        }
        this.regionId = Objects.requireNonNull(regionId, "La región no puede ser nula");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new CityMunicipalityUpdatedEvent(this.id, this.nameCity, this.codeCity, this.regionId, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new CityMunicipalityDeletedEvent(this.id, LocalDateTime.now()));
    }

    public CityMunicipalityId id() { return id; }
    public String nameCity() { return nameCity; }
    public String codeCity() { return codeCity; }
    public String description() { return description; }
    public boolean active() { return active; }
    public StateRegionId regionId() { return regionId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
