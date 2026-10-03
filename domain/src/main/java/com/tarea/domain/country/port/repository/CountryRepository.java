package com.tarea.domain.country.port.repository;

import com.tarea.domain.country.model.aggregate.Country;
import com.tarea.domain.country.model.valueobject.CountryId;

import java.util.List;
import java.util.Optional;

public interface CountryRepository {
    Country save(Country country);
    Optional<Country> findById(CountryId id);
    List<Country> findAll();
    boolean existsByCodeCountry(String codeCountry);
    void delete(Country country);
}