package com.tarea.application.country.usecase;

import com.tarea.application.country.command.UpdateCountryCommand;
import com.tarea.application.country.dto.CountryResponse;
import com.tarea.application.country.exception.CountryNotFoundApplicationException;
import com.tarea.domain.country.port.repository.CountryRepository;

public class UpdateCountryUseCase {

    private final CountryRepository countryRepository;

    public UpdateCountryUseCase(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryResponse execute(UpdateCountryCommand command) {
        var country = countryRepository.findById(command.id())
                .orElseThrow(() -> new CountryNotFoundApplicationException(command.id().value().toString()));

        country.update(
                command.nameCountry(),
                command.codeCountry(),
                command.description(),
                command.isActive(),
                command.telephonePrefix()
        );

        var updated = countryRepository.save(country);

        return new CountryResponse(
                updated.id().value(),
                updated.nameCountry(),
                updated.codeCountry(),
                updated.description(),
                updated.isActive(),
                updated.telephonePrefix(),
                updated.createdAt(),
                updated.updatedAt()
        );
    }
}