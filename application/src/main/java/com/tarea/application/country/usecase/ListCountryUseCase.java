package com.tarea.application.country.usecase;

import com.tarea.application.country.dto.CountryResponse;
import com.tarea.domain.country.port.repository.CountryRepository;

import java.util.List;

public class ListCountryUseCase {

    private final CountryRepository countryRepository;

    public ListCountryUseCase(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<CountryResponse> execute() {
        return countryRepository.findAll().stream()
                .map(country -> new CountryResponse(
                        country.id().value(),
                        country.nameCountry(),
                        country.codeCountry(),
                        country.description(),
                        country.isActive(),
                        country.telephonePrefix(),
                        country.createdAt(),
                        country.updatedAt()
                ))
                .toList();
    }
}