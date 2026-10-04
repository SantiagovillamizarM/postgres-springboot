package com.tarea.domain.clinicalnote.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.clinicalnote.event.ClinicalNoteDeletedEvent;
import com.tarea.domain.clinicalnote.event.ClinicalNoteRegisteredEvent;
import com.tarea.domain.clinicalnote.event.ClinicalNoteUpdatedEvent;
import com.tarea.domain.clinicalnote.model.valueobject.ClinicalNoteId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ClinicalNote extends AggregateRoot {
    private final ClinicalNoteId id;
    private EncounterId encounterId;
    private ProfessionalId professionalId;
    private String subjective;
    private String objective;
    private String assessment;
    private String plan;
    private String additionalNotes;
    private LocalDateTime signedAt;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ClinicalNote(ClinicalNoteId id, EncounterId encounterId, ProfessionalId professionalId,
                         String subjective, String objective, String assessment, String plan,
                         String additionalNotes, LocalDateTime signedAt, LocalDateTime createdAt,
                         LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.encounterId = Objects.requireNonNull(encounterId, "El encuentro no puede ser nulo");
        this.professionalId = Objects.requireNonNull(professionalId, "El profesional no puede ser nulo");
        this.subjective = subjective;
        this.objective = objective;
        this.assessment = assessment;
        this.plan = plan;
        this.additionalNotes = additionalNotes;
        this.signedAt = signedAt;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static ClinicalNote register(EncounterId encounterId, ProfessionalId professionalId,
                                        String subjective, String objective, String assessment, String plan,
                                        String additionalNotes, LocalDateTime signedAt) {
        ClinicalNoteId id = ClinicalNoteId.generate();
        LocalDateTime now = LocalDateTime.now();

        ClinicalNote clinicalNote = new ClinicalNote(id, encounterId, professionalId, subjective, objective,
                                                     assessment, plan, additionalNotes, signedAt, now, null);
        clinicalNote.recordEvent(new ClinicalNoteRegisteredEvent(id, now));
        return clinicalNote;
    }

    public static ClinicalNote restore(ClinicalNoteId id, EncounterId encounterId,
                                       ProfessionalId professionalId, String subjective, String objective,
                                       String assessment, String plan, String additionalNotes,
                                       LocalDateTime signedAt, LocalDateTime createdAt,
                                       LocalDateTime updatedAt) {
        return new ClinicalNote(id, encounterId, professionalId, subjective, objective, assessment, plan,
                                additionalNotes, signedAt, createdAt, updatedAt);
    }

    public void update(EncounterId encounterId, ProfessionalId professionalId, String subjective,
                       String objective, String assessment, String plan, String additionalNotes,
                       LocalDateTime signedAt) {
        this.encounterId = Objects.requireNonNull(encounterId, "El encuentro no puede ser nulo");
        this.professionalId = Objects.requireNonNull(professionalId, "El profesional no puede ser nulo");
        this.subjective = subjective;
        this.objective = objective;
        this.assessment = assessment;
        this.plan = plan;
        this.additionalNotes = additionalNotes;
        this.signedAt = signedAt;
        this.updatedAt = LocalDateTime.now();

        recordEvent(new ClinicalNoteUpdatedEvent(this.id, this.encounterId, this.professionalId,
                                                 this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new ClinicalNoteDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ClinicalNoteId id() { return id; }
    public EncounterId encounterId() { return encounterId; }
    public ProfessionalId professionalId() { return professionalId; }
    public String subjective() { return subjective; }
    public String objective() { return objective; }
    public String assessment() { return assessment; }
    public String plan() { return plan; }
    public String additionalNotes() { return additionalNotes; }
    public LocalDateTime signedAt() { return signedAt; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
