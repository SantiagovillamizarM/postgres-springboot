package com.tarea.infrastructure.medicationroute.config;

import com.tarea.application.medicationroute.usecase.DeleteMedicationRouteUseCase;
import com.tarea.application.medicationroute.usecase.GetMedicationRouteByIdUseCase;
import com.tarea.application.medicationroute.usecase.ListMedicationRouteUseCase;
import com.tarea.application.medicationroute.usecase.RegisterMedicationRouteUseCase;
import com.tarea.application.medicationroute.usecase.UpdateMedicationRouteUseCase;
import com.tarea.domain.medicationroute.port.repository.MedicationRouteRepository;
import com.tarea.infrastructure.medicationroute.adapters.out.persistence.mappers.MedicationRoutePersistenceMapper;
import com.tarea.infrastructure.medicationroute.adapters.out.persistence.repositories.MedicationRouteJpaRepository;
import com.tarea.infrastructure.medicationroute.adapters.out.persistence.repositories.MedicationRouteRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MedicationRouteBeansConfig {

    @Bean
    public MedicationRoutePersistenceMapper medicationRoutePersistenceMapper() {
        return new MedicationRoutePersistenceMapper();
    }

    @Bean
    public MedicationRouteRepository medicationRouteRepository(MedicationRouteJpaRepository repository, MedicationRoutePersistenceMapper mapper) {
        return new MedicationRouteRepositoryAdapter(repository, mapper);
    }

    @Bean
    public RegisterMedicationRouteUseCase registerMedicationRouteUseCase(MedicationRouteRepository repository) {
        return new RegisterMedicationRouteUseCase(repository);
    }

    @Bean
    public GetMedicationRouteByIdUseCase getMedicationRouteByIdUseCase(MedicationRouteRepository repository) {
        return new GetMedicationRouteByIdUseCase(repository);
    }

    @Bean
    public ListMedicationRouteUseCase listMedicationRouteUseCase(MedicationRouteRepository repository) {
        return new ListMedicationRouteUseCase(repository);
    }

    @Bean
    public UpdateMedicationRouteUseCase updateMedicationRouteUseCase(MedicationRouteRepository repository) {
        return new UpdateMedicationRouteUseCase(repository);
    }

    @Bean
    public DeleteMedicationRouteUseCase deleteMedicationRouteUseCase(MedicationRouteRepository repository) {
        return new DeleteMedicationRouteUseCase(repository);
    }
}
