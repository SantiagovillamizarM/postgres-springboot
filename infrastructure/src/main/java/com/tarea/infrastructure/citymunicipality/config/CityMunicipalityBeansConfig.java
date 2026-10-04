package com.tarea.infrastructure.citymunicipality.config;

import com.tarea.application.citymunicipality.usecase.DeleteCityMunicipalityUseCase;
import com.tarea.application.citymunicipality.usecase.GetCityMunicipalityByIdUseCase;
import com.tarea.application.citymunicipality.usecase.ListCityMunicipalityUseCase;
import com.tarea.application.citymunicipality.usecase.RegisterCityMunicipalityUseCase;
import com.tarea.application.citymunicipality.usecase.UpdateCityMunicipalityUseCase;
import com.tarea.domain.citymunicipality.port.repository.CityMunicipalityRepository;
import com.tarea.infrastructure.citymunicipality.adapters.out.persistence.mappers.CityMunicipalityPersistenceMapper;
import com.tarea.infrastructure.citymunicipality.adapters.out.persistence.repositories.CityMunicipalityJpaRepository;
import com.tarea.infrastructure.citymunicipality.adapters.out.persistence.repositories.CityMunicipalityRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CityMunicipalityBeansConfig {

    @Bean
    public CityMunicipalityPersistenceMapper cityMunicipalityPersistenceMapper() {
        return new CityMunicipalityPersistenceMapper();
    }

    @Bean
    public CityMunicipalityRepository cityMunicipalityRepository(CityMunicipalityJpaRepository repository, CityMunicipalityPersistenceMapper mapper) {
        return new CityMunicipalityRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterCityMunicipalityUseCase registerCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        return new RegisterCityMunicipalityUseCase(repository);
    }

    @Bean
    public GetCityMunicipalityByIdUseCase getCityMunicipalityByIdUseCase(CityMunicipalityRepository repository) {
        return new GetCityMunicipalityByIdUseCase(repository);
    }

    @Bean
    public ListCityMunicipalityUseCase listCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        return new ListCityMunicipalityUseCase(repository);
    }

    @Bean
    public UpdateCityMunicipalityUseCase updateCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        return new UpdateCityMunicipalityUseCase(repository);
    }

    @Bean
    public DeleteCityMunicipalityUseCase deleteCityMunicipalityUseCase(CityMunicipalityRepository repository) {
        return new DeleteCityMunicipalityUseCase(repository);
    }
}
