package com.tarea.application.citymunicipality.usecase;

import com.tarea.application.citymunicipality.dto.CityMunicipalityResponse;
import com.tarea.domain.citymunicipality.port.repository.CityMunicipalityRepository;

import java.util.List;

public class ListCityMunicipalityUseCase {

    private final CityMunicipalityRepository cityMunicipalityRepository;

    public ListCityMunicipalityUseCase(CityMunicipalityRepository cityMunicipalityRepository) {
        this.cityMunicipalityRepository = cityMunicipalityRepository;
    }

    public List<CityMunicipalityResponse> execute() {
        return cityMunicipalityRepository.findAll().stream()
                .map(cityMunicipality -> new CityMunicipalityResponse(
                    cityMunicipality.id().value(),
                    cityMunicipality.nameCity(),
                    cityMunicipality.codeCity(),
                    cityMunicipality.description(),
                    cityMunicipality.active(),
                    cityMunicipality.regionId().value(),
                    cityMunicipality.createdAt(),
                    cityMunicipality.updatedAt()
                ))
                .toList();
    }
}
