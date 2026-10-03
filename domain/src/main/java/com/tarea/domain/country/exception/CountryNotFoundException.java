package com.tarea.domain.country.exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String id){
        super("pais no encontrado con el identificador: "+id);
    }
    
}
