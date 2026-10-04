package com.tarea.application.stateregion.command;

import com.tarea.domain.country.model.valueobject.CountryId;

public record RegisterStateRegionCommand(
        String nameRegion,
        String codeRegion,
        String description,
        Boolean active,
        CountryId countryId
) {
}
