package com.tarea.application.stateregion.command;

import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;

public record UpdateStateRegionCommand(
        StateRegionId id,
        String nameRegion,
        String codeRegion,
        String description,
        Boolean active,
        CountryId countryId
) {
}
