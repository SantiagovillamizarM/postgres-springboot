package com.tarea.application.citymunicipality.usecase;

import com.tarea.application.citymunicipality.exception.CityMunicipalityNotFoundApplicationException;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.citymunicipality.port.repository.CityMunicipalityRepository;

public class DeleteCityMunicipalityUseCase {

    private final CityMunicipalityRepository cityMunicipalityRepository;

    public DeleteCityMunicipalityUseCase(CityMunicipalityRepository cityMunicipalityRepository) {
        this.cityMunicipalityRepository = cityMunicipalityRepository;
    }

    public void execute(CityMunicipalityId id) {
        var cityMunicipality = cityMunicipalityRepository.findById(id)
                .orElseThrow(() -> new CityMunicipalityNotFoundApplicationException(id.value().toString()));

        cityMunicipality.markAsDeleted();
        cityMunicipalityRepository.delete(cityMunicipality);
    }
}
