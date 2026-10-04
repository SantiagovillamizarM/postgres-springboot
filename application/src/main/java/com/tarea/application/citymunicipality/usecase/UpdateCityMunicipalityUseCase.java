package com.tarea.application.citymunicipality.usecase;

import com.tarea.application.citymunicipality.command.UpdateCityMunicipalityCommand;
import com.tarea.application.citymunicipality.dto.CityMunicipalityResponse;
import com.tarea.application.citymunicipality.exception.CityMunicipalityNotFoundApplicationException;
import com.tarea.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class UpdateCityMunicipalityUseCase {

    private final CityMunicipalityRepository cityMunicipalityRepository;

    public UpdateCityMunicipalityUseCase(CityMunicipalityRepository cityMunicipalityRepository) {
        this.cityMunicipalityRepository = cityMunicipalityRepository;
    }

    public CityMunicipalityResponse execute(UpdateCityMunicipalityCommand command) {
        var cityMunicipality = cityMunicipalityRepository.findById(command.id())
                .orElseThrow(() -> new CityMunicipalityNotFoundApplicationException(command.id().value().toString()));

        cityMunicipality.update(
                command.nameCity(),
                command.codeCity(),
                command.description(),
                command.active(),
                command.regionId()
        );

        var updated = cityMunicipalityRepository.save(cityMunicipality);

        return new CityMunicipalityResponse(
            updated.id().value(),
            updated.nameCity(),
            updated.codeCity(),
            updated.description(),
            updated.active(),
            updated.regionId().value(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
