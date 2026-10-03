package com.tarea.application.country.usecase;

import com.tarea.application.country.dto.CountryResponse;
import com.tarea.application.country.exception.CountryNotFoundApplicationException;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.country.port.repository.CountryRepository;

public class GetCountryByIdUseCase {

    private final CountryRepository countryRepository;

    public GetCountryByIdUseCase(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryResponse execute(CountryId id) {
        var country = countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundApplicationException(id.value().toString()));

        return new CountryResponse(
                country.id().value(),
                country.nameCountry(),
                country.codeCountry(),
                country.description(),
                country.isActive(),
                country.telephonePrefix(),
                country.createdAt(),
                country.updatedAt()
        );
    }
}