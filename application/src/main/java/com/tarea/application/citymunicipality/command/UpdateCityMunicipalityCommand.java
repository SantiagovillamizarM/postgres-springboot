package com.tarea.application.citymunicipality.command;

import com.tarea.domain.stateregion.model.valueobject.StateRegionId;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;

public record UpdateCityMunicipalityCommand(
        CityMunicipalityId id,
        String nameCity,
        String codeCity,
        String description,
        Boolean active,
        StateRegionId regionId
) {
}
