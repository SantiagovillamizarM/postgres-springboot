package com.tarea.infrastructure.country.adapters.in.rest.controllers;

import com.tarea.application.country.command.RegisterCountryCommand;
import com.tarea.application.country.command.UpdateCountryCommand;
import com.tarea.application.country.dto.CountryResponse;
import com.tarea.application.country.usecase.DeleteCountryUseCase;
import com.tarea.application.country.usecase.GetCountryByIdUseCase;
import com.tarea.application.country.usecase.ListCountryUseCase;
import com.tarea.application.country.usecase.RegisterCountryUseCase;
import com.tarea.application.country.usecase.UpdateCountryUseCase;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.infrastructure.country.adapters.in.rest.dtos.CreateCountryRequest;
import com.tarea.infrastructure.country.adapters.in.rest.dtos.UpdateCountryRequest;
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
@RequestMapping("/api/countries")
public class CountryController {

    private final RegisterCountryUseCase registerUseCase;
    private final GetCountryByIdUseCase getByIdUseCase;
    private final ListCountryUseCase listUseCase;
    private final UpdateCountryUseCase updateUseCase;
    private final DeleteCountryUseCase deleteUseCase;

    public CountryController(RegisterCountryUseCase registerUseCase,
                             GetCountryByIdUseCase getByIdUseCase,
                             ListCountryUseCase listUseCase,
                             UpdateCountryUseCase updateUseCase,
                             DeleteCountryUseCase deleteUseCase) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<CountryResponse> create(@Valid @RequestBody CreateCountryRequest request) {
        var command = new RegisterCountryCommand(
                request.nameCountry(),
                request.codeCountry(),
                request.description(),
                request.isActive(),
                request.telephonePrefix()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerUseCase.execute(command));
    }

    @GetMapping
    public ResponseEntity<List<CountryResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CountryResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new CountryId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CountryResponse> update(@PathVariable UUID id,
                                                  @Valid @RequestBody UpdateCountryRequest request) {
        var command = new UpdateCountryCommand(
                new CountryId(id),
                request.nameCountry(),
                request.codeCountry(),
                request.description(),
                request.isActive(),
                request.telephonePrefix()
        );

        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new CountryId(id));
        return ResponseEntity.noContent().build();
    }
}
