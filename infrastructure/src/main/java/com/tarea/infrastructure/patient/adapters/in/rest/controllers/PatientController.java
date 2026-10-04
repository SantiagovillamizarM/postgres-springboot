package com.tarea.infrastructure.patient.adapters.in.rest.controllers;

import com.tarea.application.patient.command.RegisterPatientCommand;
import com.tarea.application.patient.command.UpdatePatientCommand;
import com.tarea.application.patient.dto.PatientResponse;
import com.tarea.application.patient.usecase.DeletePatientUseCase;
import com.tarea.application.patient.usecase.GetPatientByIdUseCase;
import com.tarea.application.patient.usecase.ListPatientUseCase;
import com.tarea.application.patient.usecase.RegisterPatientUseCase;
import com.tarea.application.patient.usecase.UpdatePatientUseCase;
import com.tarea.domain.citymunicipality.model.valueobject.CityMunicipalityId;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;
import com.tarea.domain.gender.model.valueobject.GenderId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.infrastructure.patient.adapters.in.rest.dtos.CreatePatientRequest;
import com.tarea.infrastructure.patient.adapters.in.rest.dtos.UpdatePatientRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final RegisterPatientUseCase registerUseCase;
    private final GetPatientByIdUseCase getByIdUseCase;
    private final ListPatientUseCase listUseCase;
    private final UpdatePatientUseCase updateUseCase;
    private final DeletePatientUseCase deleteUseCase;

    public PatientController(RegisterPatientUseCase registerUseCase,
            GetPatientByIdUseCase getByIdUseCase,
            ListPatientUseCase listUseCase,
            UpdatePatientUseCase updateUseCase,
            DeletePatientUseCase deleteUseCase) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<PatientResponse> create(@Valid @RequestBody CreatePatientRequest request) {
        var command = new RegisterPatientCommand(
                new DocumentTypeId(request.documentTypeId()),
                request.documentNumber(),
                request.firstName(),
                request.middleName(),
                request.lastName(),
                request.secondLastName(),
                request.birthDate(),
                new GenderId(request.biologicalSexId()),
                new GenderId(request.genderIdentityId()),
                request.email(),
                request.phone(),
                request.address(),
                request.active(),
                request.createdBy() != null ? new ProfessionalId(request.createdBy()) : null,
                request.updatedBy() != null ? new ProfessionalId(request.updatedBy()) : null,
                new CityMunicipalityId(request.cityId())
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerUseCase.execute(command));
    }

    @GetMapping
    public ResponseEntity<List<PatientResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new PatientId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> update(@PathVariable UUID id,
            @Valid @RequestBody UpdatePatientRequest request) {
        var command = new UpdatePatientCommand(
                new PatientId(id),
                new DocumentTypeId(request.documentTypeId()),
                request.documentNumber(),
                request.firstName(),
                request.middleName(),
                request.lastName(),
                request.secondLastName(),
                request.birthDate(),
                new GenderId(request.biologicalSexId()),
                new GenderId(request.genderIdentityId()),
                request.email(),
                request.phone(),
                request.address(),
                request.active(),
                request.updatedBy() != null ? new ProfessionalId(request.updatedBy()) : null,
                new CityMunicipalityId(request.cityId())
        );

        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new PatientId(id));
        return ResponseEntity.noContent().build();
    }
}
