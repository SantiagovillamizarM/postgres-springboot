package com.tarea.infrastructure.treatmentgoalstatus.adapters.in.rest.controllers;

import com.tarea.application.treatmentgoalstatus.command.RegisterTreatmentGoalStatusCommand;
import com.tarea.application.treatmentgoalstatus.command.UpdateTreatmentGoalStatusCommand;
import com.tarea.application.treatmentgoalstatus.dto.TreatmentGoalStatusResponse;
import com.tarea.application.treatmentgoalstatus.usecase.DeleteTreatmentGoalStatusUseCase;
import com.tarea.application.treatmentgoalstatus.usecase.GetTreatmentGoalStatusByIdUseCase;
import com.tarea.application.treatmentgoalstatus.usecase.ListTreatmentGoalStatusUseCase;
import com.tarea.application.treatmentgoalstatus.usecase.RegisterTreatmentGoalStatusUseCase;
import com.tarea.application.treatmentgoalstatus.usecase.UpdateTreatmentGoalStatusUseCase;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.tarea.infrastructure.treatmentgoalstatus.adapters.in.rest.dtos.CreateTreatmentGoalStatusRequest;
import com.tarea.infrastructure.treatmentgoalstatus.adapters.in.rest.dtos.UpdateTreatmentGoalStatusRequest;
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
@RequestMapping("/api/treatment-goal-statuses")
public class TreatmentGoalStatusController {

    private final RegisterTreatmentGoalStatusUseCase registerUseCase;
    private final GetTreatmentGoalStatusByIdUseCase getByIdUseCase;
    private final ListTreatmentGoalStatusUseCase listUseCase;
    private final UpdateTreatmentGoalStatusUseCase updateUseCase;
    private final DeleteTreatmentGoalStatusUseCase deleteUseCase;

    public TreatmentGoalStatusController(RegisterTreatmentGoalStatusUseCase registerUseCase,
            GetTreatmentGoalStatusByIdUseCase getByIdUseCase,
            ListTreatmentGoalStatusUseCase listUseCase,
            UpdateTreatmentGoalStatusUseCase updateUseCase,
            DeleteTreatmentGoalStatusUseCase deleteUseCase) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<TreatmentGoalStatusResponse> create(@Valid @RequestBody CreateTreatmentGoalStatusRequest request) {
        var command = new RegisterTreatmentGoalStatusCommand(
                request.code(),
                request.name(),
                request.active()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerUseCase.execute(command));
    }

    @GetMapping
    public ResponseEntity<List<TreatmentGoalStatusResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentGoalStatusResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new TreatmentGoalStatusId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreatmentGoalStatusResponse> update(@PathVariable UUID id,
            @Valid @RequestBody UpdateTreatmentGoalStatusRequest request) {
        var command = new UpdateTreatmentGoalStatusCommand(
                new TreatmentGoalStatusId(id),
                request.code(),
                request.name(),
                request.active()
        );

        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new TreatmentGoalStatusId(id));
        return ResponseEntity.noContent().build();
    }
}
