package com.tarea.domain.study.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record StudyId(UUID value) {
    public StudyId{
        Objects.requireNonNull(value, "El valor de StudyId no puede ser nulo");
    }
    public static StudyId generate(){
        return new StudyId(UUID.randomUUID());
    }    
}
