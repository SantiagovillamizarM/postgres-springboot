package com.tarea.domain.country.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record CountryId(UUID value) {
    public CountryId{
        Objects.requireNonNull(value, "El valor de CountryId no puede ser nulo");
    }    
    public static CountryId generate(){
        return new CountryId(UUID.randomUUID());
    }
}
