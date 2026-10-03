package com.tarea.infrastructure.country.config;

import com.tarea.application.country.usecase.DeleteCountryUseCase;
import com.tarea.application.country.usecase.GetCountryByIdUseCase;
import com.tarea.application.country.usecase.ListCountryUseCase;
import com.tarea.application.country.usecase.RegisterCountryUseCase;
import com.tarea.application.country.usecase.UpdateCountryUseCase;
import com.tarea.domain.country.port.repository.CountryRepository;
import com.tarea.infrastructure.country.adapters.out.persistence.mappers.CountryPersistenceMapper;
import com.tarea.infrastructure.country.adapters.out.persistence.repositories.CountryJpaRepository;
import com.tarea.infrastructure.country.adapters.out.persistence.repositories.CountryRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CountryBeansConfig {

    @Bean
    public CountryPersistenceMapper countryPersistenceMapper() {
        return new CountryPersistenceMapper();
    }

    @Bean
    public CountryRepository countryRepository(CountryJpaRepository repository, CountryPersistenceMapper mapper) {
        return new CountryRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterCountryUseCase registerCountryUseCase(CountryRepository repository) {
        return new RegisterCountryUseCase(repository);
    }

    @Bean
    public GetCountryByIdUseCase getCountryByIdUseCase(CountryRepository repository) {
        return new GetCountryByIdUseCase(repository);
    }

    @Bean
    public ListCountryUseCase listCountryUseCase(CountryRepository repository) {
        return new ListCountryUseCase(repository);
    }

    @Bean
    public UpdateCountryUseCase updateCountryUseCase(CountryRepository repository) {
        return new UpdateCountryUseCase(repository);
    }

    @Bean
    public DeleteCountryUseCase deleteCountryUseCase(CountryRepository repository) {
        return new DeleteCountryUseCase(repository);
    }
}
