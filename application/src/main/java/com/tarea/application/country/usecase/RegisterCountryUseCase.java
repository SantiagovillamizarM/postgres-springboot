package com.tarea.application.country.usecase;

import com.tarea.application.country.command.RegisterCountryCommand;
import com.tarea.application.country.dto.CountryResponse;
import com.tarea.domain.country.model.aggregate.Country;
import com.tarea.domain.country.port.repository.CountryRepository;

public class RegisterCountryUseCase {

    private final CountryRepository countryRepository;

    public RegisterCountryUseCase(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public CountryResponse execute(RegisterCountryCommand command) {
        Country country = Country.register(
                command.nameCountry(),
                command.codeCountry(),
                command.description(),
                command.isActive(),
                command.telephonePrefix()
        );

        Country saved = countryRepository.save(country);

        return new CountryResponse(
                saved.id().value(),
                saved.nameCountry(),
                saved.codeCountry(),
                saved.description(),
                saved.isActive(),
                saved.telephonePrefix(),
                saved.createdAt(),
                saved.updatedAt()
        );
    }
}