package com.tarea.domain.citymunicipality.port.repository;

import com.tarea.domain.citymunicipality.model.aggregate.CityMunicipality;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;

import java.util.List;
import java.util.Optional;

public interface CityMunicipalityRepository {
    CityMunicipality save(CityMunicipality cityMunicipality);
    Optional<CityMunicipality> findById(CityMunicipalityId id);
    List<CityMunicipality> findAll();
    void delete(CityMunicipality cityMunicipality);
}
