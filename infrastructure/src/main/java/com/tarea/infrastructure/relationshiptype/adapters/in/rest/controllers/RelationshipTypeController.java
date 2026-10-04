package com.tarea.infrastructure.relationshiptype.adapters.in.rest.controllers;

import com.tarea.application.relationshiptype.command.RegisterRelationshipTypeCommand;
import com.tarea.application.relationshiptype.command.UpdateRelationshipTypeCommand;
import com.tarea.application.relationshiptype.dto.RelationshipTypeResponse;
import com.tarea.application.relationshiptype.usecase.DeleteRelationshipTypeUseCase;
import com.tarea.application.relationshiptype.usecase.GetRelationshipTypeByIdUseCase;
import com.tarea.application.relationshiptype.usecase.ListRelationshipTypeUseCase;
import com.tarea.application.relationshiptype.usecase.RegisterRelationshipTypeUseCase;
import com.tarea.application.relationshiptype.usecase.UpdateRelationshipTypeUseCase;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.tarea.infrastructure.relationshiptype.adapters.in.rest.dtos.CreateRelationshipTypeRequest;
import com.tarea.infrastructure.relationshiptype.adapters.in.rest.dtos.UpdateRelationshipTypeRequest;
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
@RequestMapping("/api/relationship-types")
public class RelationshipTypeController {

    private final RegisterRelationshipTypeUseCase registerUseCase;
    private final GetRelationshipTypeByIdUseCase getByIdUseCase;
    private final ListRelationshipTypeUseCase listUseCase;
    private final UpdateRelationshipTypeUseCase updateUseCase;
    private final DeleteRelationshipTypeUseCase deleteUseCase;

    public RelationshipTypeController(RegisterRelationshipTypeUseCase registerUseCase,
            GetRelationshipTypeByIdUseCase getByIdUseCase,
            ListRelationshipTypeUseCase listUseCase,
            UpdateRelationshipTypeUseCase updateUseCase,
            DeleteRelationshipTypeUseCase deleteUseCase) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<RelationshipTypeResponse> create(@Valid @RequestBody CreateRelationshipTypeRequest request) {
        var command = new RegisterRelationshipTypeCommand(
                request.description()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerUseCase.execute(command));
    }

    @GetMapping
    public ResponseEntity<List<RelationshipTypeResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RelationshipTypeResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new RelationshipTypeId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RelationshipTypeResponse> update(@PathVariable UUID id,
            @Valid @RequestBody UpdateRelationshipTypeRequest request) {
        var command = new UpdateRelationshipTypeCommand(
                new RelationshipTypeId(id),
                request.description()
        );

        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new RelationshipTypeId(id));
        return ResponseEntity.noContent().build();
    }
}
