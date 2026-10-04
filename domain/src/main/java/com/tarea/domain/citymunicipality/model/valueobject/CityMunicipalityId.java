package com.tarea.domain.citymunicipality.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record CityMunicipalityId(UUID value) {
    public CityMunicipalityId {
        Objects.requireNonNull(value, "El valor de CityMunicipalityId no puede ser nulo");
    }

    public static CityMunicipalityId generate() {
        return new CityMunicipalityId(UUID.randomUUID());
    }
}
