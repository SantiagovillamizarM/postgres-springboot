package com.tarea.application.citymunicipality.exception;

import com.tarea.application.common.exception.ApplicationException;

public class CityMunicipalityNotFoundApplicationException extends ApplicationException {

    public CityMunicipalityNotFoundApplicationException(String id) {
        super("Ciudad o municipio no encontrado con el ID: " + id);
    }
}
