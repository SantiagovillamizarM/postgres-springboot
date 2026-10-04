package com.tarea.domain.citymunicipality.exception;

public class CityMunicipalityNotFoundException extends RuntimeException {
    public CityMunicipalityNotFoundException(String id) {
        super("Ciudad o municipio no encontrado con el ID: " + id);
    }
}
