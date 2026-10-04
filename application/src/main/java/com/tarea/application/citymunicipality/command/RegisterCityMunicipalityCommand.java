package com.tarea.application.citymunicipality.command;

import com.tarea.domain.stateregion.model.valueobject.StateRegionId;

public record RegisterCityMunicipalityCommand(
        String nameCity,
        String codeCity,
        String description,
        Boolean active,
        StateRegionId regionId
) {
}
