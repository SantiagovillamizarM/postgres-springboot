package com.tarea.application.country.usecase;

import com.tarea.application.country.exception.CountryNotFoundApplicationException;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.country.port.repository.CountryRepository;

public class DeleteCountryUseCase {

    private final CountryRepository countryRepository;

    public DeleteCountryUseCase(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void execute(CountryId id) {
        var country = countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundApplicationException(id.value().toString()));

        country.markAsDeleted();
        countryRepository.delete(country);
    }
}