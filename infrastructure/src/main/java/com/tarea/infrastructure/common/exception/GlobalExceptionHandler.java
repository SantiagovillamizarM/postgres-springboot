package com.tarea.infrastructure.common.exception;

import com.tarea.application.citymunicipality.exception.CityMunicipalityNotFoundApplicationException;
import com.tarea.application.clinicalrecordstatus.exception.ClinicalRecordStatusNotFoundApplicationException;
import com.tarea.application.country.exception.CountryNotFoundApplicationException;
import com.tarea.application.documenttype.exception.DocumentTypeNotFoundApplicationException;
import com.tarea.application.encountermodality.exception.EncounterModalityNotFoundApplicationException;
import com.tarea.application.encountertype.exception.EncounterTypeNotFoundApplicationException;
import com.tarea.application.gender.exception.GenderNotFoundApplicationException;
import com.tarea.application.professionaltype.exception.ProfessionalTypeNotFoundApplicationException;
import com.tarea.application.relationshiptype.exception.RelationshipTypeNotFoundApplicationException;
import com.tarea.application.stateregion.exception.StateRegionNotFoundApplicationException;
import com.tarea.application.study.exception.StudyNotFoundApplicationException;
import com.tarea.application.encounterstatus.exception.EncounterStatusNotFoundApplicationException;
import com.tarea.application.risklevel.exception.RiskLevelNotFoundApplicationException;
import com.tarea.application.treatmentstatus.exception.TreatmentStatusNotFoundApplicationException;
import com.tarea.application.treatmentgoalstatus.exception.TreatmentGoalStatusNotFoundApplicationException;
import com.tarea.application.medicationroute.exception.MedicationRouteNotFoundApplicationException;
import com.tarea.application.assessmenttype.exception.AssessmentTypeNotFoundApplicationException;
import com.tarea.application.consenttype.exception.ConsentTypeNotFoundApplicationException;
import com.tarea.application.diagnosticsystem.exception.DiagnosticSystemNotFoundApplicationException;
import com.tarea.application.sendertype.exception.SenderTypeNotFoundApplicationException;
import com.tarea.application.priority.exception.PriorityNotFoundApplicationException;
import com.tarea.application.conversationstatus.exception.ConversationStatusNotFoundApplicationException;
import com.tarea.application.messagetype.exception.MessageTypeNotFoundApplicationException;
import com.tarea.application.airunstatus.exception.AiRunStatusNotFoundApplicationException;
import com.tarea.application.escalationstatus.exception.EscalationStatusNotFoundApplicationException;
import com.tarea.application.providermodelai.exception.ProviderModelAiNotFoundApplicationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Agregar aquí la NotFoundApplicationException de cada tabla nueva
    @ExceptionHandler({
            CountryNotFoundApplicationException.class,
            StateRegionNotFoundApplicationException.class,
            CityMunicipalityNotFoundApplicationException.class,
            DocumentTypeNotFoundApplicationException.class,
            GenderNotFoundApplicationException.class,
            RelationshipTypeNotFoundApplicationException.class,
            ProfessionalTypeNotFoundApplicationException.class,
            StudyNotFoundApplicationException.class,
            ClinicalRecordStatusNotFoundApplicationException.class,
            EncounterTypeNotFoundApplicationException.class,
            EncounterModalityNotFoundApplicationException.class,
            EncounterStatusNotFoundApplicationException.class,
            RiskLevelNotFoundApplicationException.class,
            TreatmentStatusNotFoundApplicationException.class,
            TreatmentGoalStatusNotFoundApplicationException.class,
            MedicationRouteNotFoundApplicationException.class,
            AssessmentTypeNotFoundApplicationException.class,
            ConsentTypeNotFoundApplicationException.class,
            DiagnosticSystemNotFoundApplicationException.class,
            SenderTypeNotFoundApplicationException.class,
            PriorityNotFoundApplicationException.class,
            ConversationStatusNotFoundApplicationException.class,
            MessageTypeNotFoundApplicationException.class,
            AiRunStatusNotFoundApplicationException.class,
            EscalationStatusNotFoundApplicationException.class,
            ProviderModelAiNotFoundApplicationException.class
    })
    public ResponseEntity<Map<String, String>> handleNotFound(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    // La BD rechazó el dato: llave foránea que no existe, valor UNIQUE repetido
    // o borrar un registro que otras tablas todavía usan
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrity(DataIntegrityViolationException ex) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Map.of("error", "La operación viola una restricción de la base de datos "
                        + "(llave foránea inexistente, valor duplicado o registro en uso)"));
    }
}
