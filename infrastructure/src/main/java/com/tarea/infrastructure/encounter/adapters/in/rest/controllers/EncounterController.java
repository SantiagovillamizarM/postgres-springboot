package com.tarea.infrastructure.encounter.adapters.in.rest.controllers;

import com.tarea.application.encounter.command.RegisterEncounterCommand;
import com.tarea.application.encounter.command.UpdateEncounterCommand;
import com.tarea.application.encounter.dto.EncounterResponse;
import com.tarea.application.encounter.usecase.DeleteEncounterUseCase;
import com.tarea.application.encounter.usecase.GetEncounterByIdUseCase;
import com.tarea.application.encounter.usecase.ListEncounterUseCase;
import com.tarea.application.encounter.usecase.RegisterEncounterUseCase;
import com.tarea.application.encounter.usecase.UpdateEncounterUseCase;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.infrastructure.encounter.adapters.in.rest.dtos.CreateEncounterRequest;
import com.tarea.infrastructure.encounter.adapters.in.rest.dtos.UpdateEncounterRequest;
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
@RequestMapping("/api/encounters")
public class EncounterController {

    private final RegisterEncounterUseCase registerUseCase;
    private final GetEncounterByIdUseCase getByIdUseCase;
    private final ListEncounterUseCase listUseCase;
    private final UpdateEncounterUseCase updateUseCase;
    private final DeleteEncounterUseCase deleteUseCase;

    public EncounterController(RegisterEncounterUseCase registerUseCase,
            GetEncounterByIdUseCase getByIdUseCase,
            ListEncounterUseCase listUseCase,
            UpdateEncounterUseCase updateUseCase,
            DeleteEncounterUseCase deleteUseCase) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<EncounterResponse> create(@Valid @RequestBody CreateEncounterRequest request) {
        var command = new RegisterEncounterCommand(
                new ClinicalRecordId(request.clinicalRecordId()),
                new ProfessionalId(request.professionalId()),
                new EncounterTypeId(request.encounterTypeId()),
                request.startedAt(),
                request.endedAt(),
                request.reasonForVisit(),
                request.currentCondition(),
                new EncounterModalityId(request.modalityId()),
                new EncounterStatusId(request.statusId()),
                request.createdBy() != null ? new ProfessionalId(request.createdBy()) : null,
                request.updatedBy() != null ? new ProfessionalId(request.updatedBy()) : null
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerUseCase.execute(command));
    }

    @GetMapping
    public ResponseEntity<List<EncounterResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EncounterResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new EncounterId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EncounterResponse> update(@PathVariable UUID id,
            @Valid @RequestBody UpdateEncounterRequest request) {
        var command = new UpdateEncounterCommand(
                new EncounterId(id),
                new ClinicalRecordId(request.clinicalRecordId()),
                new ProfessionalId(request.professionalId()),
                new EncounterTypeId(request.encounterTypeId()),
                request.startedAt(),
                request.endedAt(),
                request.reasonForVisit(),
                request.currentCondition(),
                new EncounterModalityId(request.modalityId()),
                new EncounterStatusId(request.statusId()),
                request.updatedBy() != null ? new ProfessionalId(request.updatedBy()) : null
        );

        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new EncounterId(id));
        return ResponseEntity.noContent().build();
    }
}
