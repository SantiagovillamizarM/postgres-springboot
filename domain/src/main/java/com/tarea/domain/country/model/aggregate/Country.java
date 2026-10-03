package com.tarea.domain.country.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.country.event.CountryDeletedEvent;
import com.tarea.domain.country.event.CountryRegisteredEvent;
import com.tarea.domain.country.event.CountryUpdatedEvent;
import com.tarea.domain.country.model.valueobject.CountryId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Country extends AggregateRoot {
    private final CountryId id;
    private String nameCountry;
    private String codeCountry;
    private String description;
    private boolean isActive;
    private String telephonePrefix;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Country(CountryId id, String nameCountry, String codeCountry, String description,
                    boolean isActive, String telephonePrefix, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.nameCountry = Objects.requireNonNull(nameCountry, "El nombre del país no puede ser nulo");
        this.codeCountry = Objects.requireNonNull(codeCountry, "El código del país no puede ser nulo");
        this.description = description;
        this.isActive = isActive;
        this.telephonePrefix = telephonePrefix;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static Country register(String nameCountry, String codeCountry, String description,
                                   Boolean isActive, String telephonePrefix) {
        CountryId id = CountryId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean active = isActive != null ? isActive : true;

        Country country = new Country(id, nameCountry, codeCountry, description, active, telephonePrefix, now, null);
        country.recordEvent(new CountryRegisteredEvent(id, now));
        return country;
    }

    public static Country restore(CountryId id, String nameCountry, String codeCountry, String description,
                                  boolean isActive, String telephonePrefix, LocalDateTime createdAt,
                                  LocalDateTime updatedAt) {
        return new Country(id, nameCountry, codeCountry, description, isActive, telephonePrefix, createdAt, updatedAt);
    }

    public void update(String nameCountry, String codeCountry, String description,
                       Boolean isActive, String telephonePrefix) {
        this.nameCountry = Objects.requireNonNull(nameCountry, "El nombre del país no puede ser nulo");
        this.codeCountry = Objects.requireNonNull(codeCountry, "El código del país no puede ser nulo");
        this.description = description;
        if (isActive != null) {
            this.isActive = isActive;
        }
        this.telephonePrefix = telephonePrefix;
        this.updatedAt = LocalDateTime.now();

        recordEvent(new CountryUpdatedEvent(this.id, this.nameCountry, this.codeCountry, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new CountryDeletedEvent(this.id, LocalDateTime.now()));
    }

    public CountryId id() { return id; }
    public String nameCountry() { return nameCountry; }
    public String codeCountry() { return codeCountry; }
    public String description() { return description; }
    public boolean isActive() { return isActive; }
    public String telephonePrefix() { return telephonePrefix; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
