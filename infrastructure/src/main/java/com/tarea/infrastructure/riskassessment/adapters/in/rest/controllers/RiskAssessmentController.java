package com.tarea.infrastructure.riskassessment.adapters.in.rest.controllers;

import com.tarea.application.riskassessment.command.RegisterRiskAssessmentCommand;
import com.tarea.application.riskassessment.command.UpdateRiskAssessmentCommand;
import com.tarea.application.riskassessment.dto.RiskAssessmentResponse;
import com.tarea.application.riskassessment.usecase.DeleteRiskAssessmentUseCase;
import com.tarea.application.riskassessment.usecase.GetRiskAssessmentByIdUseCase;
import com.tarea.application.riskassessment.usecase.ListRiskAssessmentUseCase;
import com.tarea.application.riskassessment.usecase.RegisterRiskAssessmentUseCase;
import com.tarea.application.riskassessment.usecase.UpdateRiskAssessmentUseCase;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.tarea.infrastructure.riskassessment.adapters.in.rest.dtos.CreateRiskAssessmentRequest;
import com.tarea.infrastructure.riskassessment.adapters.in.rest.dtos.UpdateRiskAssessmentRequest;
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
@RequestMapping("/api/risk-assessments")
public class RiskAssessmentController {

    private final RegisterRiskAssessmentUseCase registerUseCase;
    private final GetRiskAssessmentByIdUseCase getByIdUseCase;
    private final ListRiskAssessmentUseCase listUseCase;
    private final UpdateRiskAssessmentUseCase updateUseCase;
    private final DeleteRiskAssessmentUseCase deleteUseCase;

    public RiskAssessmentController(RegisterRiskAssessmentUseCase registerUseCase,
            GetRiskAssessmentByIdUseCase getByIdUseCase,
            ListRiskAssessmentUseCase listUseCase,
            UpdateRiskAssessmentUseCase updateUseCase,
            DeleteRiskAssessmentUseCase deleteUseCase) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<RiskAssessmentResponse> create(@Valid @RequestBody CreateRiskAssessmentRequest request) {
        var command = new RegisterRiskAssessmentCommand(
                new EncounterId(request.encounterId()),
                new RiskLevelId(request.riskLevelId()),
                request.suicidalIdeation(),
                request.suicidePlan(),
                request.suicideIntent(),
                request.selfHarm(),
                request.harmToOthers(),
                request.riskFactors(),
                request.protectiveFactors(),
                request.clinicalActions(),
                request.observations(),
                request.assessedAt(),
                new ProfessionalId(request.assessedBy())
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerUseCase.execute(command));
    }

    @GetMapping
    public ResponseEntity<List<RiskAssessmentResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskAssessmentResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new RiskAssessmentId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RiskAssessmentResponse> update(@PathVariable UUID id,
            @Valid @RequestBody UpdateRiskAssessmentRequest request) {
        var command = new UpdateRiskAssessmentCommand(
                new RiskAssessmentId(id),
                new EncounterId(request.encounterId()),
                new RiskLevelId(request.riskLevelId()),
                request.suicidalIdeation(),
                request.suicidePlan(),
                request.suicideIntent(),
                request.selfHarm(),
                request.harmToOthers(),
                request.riskFactors(),
                request.protectiveFactors(),
                request.clinicalActions(),
                request.observations(),
                request.assessedAt(),
                new ProfessionalId(request.assessedBy())
        );

        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new RiskAssessmentId(id));
        return ResponseEntity.noContent().build();
    }
}
