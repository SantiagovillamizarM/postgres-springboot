package com.tarea.application.citymunicipality.usecase;

import com.tarea.application.citymunicipality.command.RegisterCityMunicipalityCommand;
import com.tarea.application.citymunicipality.dto.CityMunicipalityResponse;
import com.tarea.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.tarea.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class RegisterCityMunicipalityUseCase {

    private final CityMunicipalityRepository cityMunicipalityRepository;

    public RegisterCityMunicipalityUseCase(CityMunicipalityRepository cityMunicipalityRepository) {
        this.cityMunicipalityRepository = cityMunicipalityRepository;
    }

    public CityMunicipalityResponse execute(RegisterCityMunicipalityCommand command) {
        CityMunicipality cityMunicipality = CityMunicipality.register(
                command.nameCity(),
                command.codeCity(),
                command.description(),
                command.active(),
                command.regionId()
        );

        CityMunicipality saved = cityMunicipalityRepository.save(cityMunicipality);

        return new CityMunicipalityResponse(
            saved.id().value(),
            saved.nameCity(),
            saved.codeCity(),
            saved.description(),
            saved.active(),
            saved.regionId().value(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
