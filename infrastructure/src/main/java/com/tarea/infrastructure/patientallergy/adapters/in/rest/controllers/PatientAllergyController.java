package com.tarea.infrastructure.patientallergy.adapters.in.rest.controllers;

import com.tarea.application.patientallergy.command.RegisterPatientAllergyCommand;
import com.tarea.application.patientallergy.command.UpdatePatientAllergyCommand;
import com.tarea.application.patientallergy.dto.PatientAllergyResponse;
import com.tarea.application.patientallergy.usecase.DeletePatientAllergyUseCase;
import com.tarea.application.patientallergy.usecase.GetPatientAllergyByIdUseCase;
import com.tarea.application.patientallergy.usecase.ListPatientAllergyUseCase;
import com.tarea.application.patientallergy.usecase.RegisterPatientAllergyUseCase;
import com.tarea.application.patientallergy.usecase.UpdatePatientAllergyUseCase;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.patientallergy.model.valueobject.PatientAllergyId;
import com.tarea.infrastructure.patientallergy.adapters.in.rest.dtos.CreatePatientAllergyRequest;
import com.tarea.infrastructure.patientallergy.adapters.in.rest.dtos.UpdatePatientAllergyRequest;
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
@RequestMapping("/api/patient-allergies")
public class PatientAllergyController {

    private final RegisterPatientAllergyUseCase registerUseCase;
    private final GetPatientAllergyByIdUseCase getByIdUseCase;
    private final ListPatientAllergyUseCase listUseCase;
    private final UpdatePatientAllergyUseCase updateUseCase;
    private final DeletePatientAllergyUseCase deleteUseCase;

    public PatientAllergyController(RegisterPatientAllergyUseCase registerUseCase,
            GetPatientAllergyByIdUseCase getByIdUseCase,
            ListPatientAllergyUseCase listUseCase,
            UpdatePatientAllergyUseCase updateUseCase,
            DeletePatientAllergyUseCase deleteUseCase) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<PatientAllergyResponse> create(@Valid @RequestBody CreatePatientAllergyRequest request) {
        var command = new RegisterPatientAllergyCommand(
                new PatientId(request.patientId()),
                request.substance(),
                request.reaction(),
                request.severity(),
                request.active(),
                request.recordedAt(),
                request.recordedBy() != null ? new ProfessionalId(request.recordedBy()) : null
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerUseCase.execute(command));
    }

    @GetMapping
    public ResponseEntity<List<PatientAllergyResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientAllergyResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new PatientAllergyId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientAllergyResponse> update(@PathVariable UUID id,
            @Valid @RequestBody UpdatePatientAllergyRequest request) {
        var command = new UpdatePatientAllergyCommand(
                new PatientAllergyId(id),
                new PatientId(request.patientId()),
                request.substance(),
                request.reaction(),
                request.severity(),
                request.active(),
                request.recordedAt(),
                request.recordedBy() != null ? new ProfessionalId(request.recordedBy()) : null
        );

        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new PatientAllergyId(id));
        return ResponseEntity.noContent().build();
    }
}
