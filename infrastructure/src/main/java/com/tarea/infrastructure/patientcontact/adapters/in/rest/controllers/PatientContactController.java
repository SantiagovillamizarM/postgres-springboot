package com.tarea.infrastructure.patientcontact.adapters.in.rest.controllers;

import com.tarea.application.patientcontact.command.RegisterPatientContactCommand;
import com.tarea.application.patientcontact.command.UpdatePatientContactCommand;
import com.tarea.application.patientcontact.dto.PatientContactResponse;
import com.tarea.application.patientcontact.usecase.DeletePatientContactUseCase;
import com.tarea.application.patientcontact.usecase.GetPatientContactByIdUseCase;
import com.tarea.application.patientcontact.usecase.ListPatientContactUseCase;
import com.tarea.application.patientcontact.usecase.RegisterPatientContactUseCase;
import com.tarea.application.patientcontact.usecase.UpdatePatientContactUseCase;
import com.tarea.domain.contact.model.valueobject.ContactId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.tarea.domain.patientcontact.model.valueobject.PatientContactId;
import com.tarea.infrastructure.patientcontact.adapters.in.rest.dtos.CreatePatientContactRequest;
import com.tarea.infrastructure.patientcontact.adapters.in.rest.dtos.UpdatePatientContactRequest;
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
@RequestMapping("/api/patient-contacts")
public class PatientContactController {

    private final RegisterPatientContactUseCase registerUseCase;
    private final GetPatientContactByIdUseCase getByIdUseCase;
    private final ListPatientContactUseCase listUseCase;
    private final UpdatePatientContactUseCase updateUseCase;
    private final DeletePatientContactUseCase deleteUseCase;

    public PatientContactController(RegisterPatientContactUseCase registerUseCase,
            GetPatientContactByIdUseCase getByIdUseCase,
            ListPatientContactUseCase listUseCase,
            UpdatePatientContactUseCase updateUseCase,
            DeletePatientContactUseCase deleteUseCase) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<PatientContactResponse> create(@Valid @RequestBody CreatePatientContactRequest request) {
        var command = new RegisterPatientContactCommand(
                new ContactId(request.contactId()),
                new PatientId(request.patientId()),
                request.primaryContact(),
                request.emergencyContact(),
                new RelationshipTypeId(request.relationshipTypeId())
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerUseCase.execute(command));
    }

    @GetMapping
    public ResponseEntity<List<PatientContactResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientContactResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new PatientContactId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PatientContactResponse> update(@PathVariable UUID id,
            @Valid @RequestBody UpdatePatientContactRequest request) {
        var command = new UpdatePatientContactCommand(
                new PatientContactId(id),
                new ContactId(request.contactId()),
                new PatientId(request.patientId()),
                request.primaryContact(),
                request.emergencyContact(),
                new RelationshipTypeId(request.relationshipTypeId())
        );

        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new PatientContactId(id));
        return ResponseEntity.noContent().build();
    }
}
