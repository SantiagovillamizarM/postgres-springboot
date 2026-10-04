package com.tarea.domain.professionalstudy.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.study.model.valueobject.StudyId;
import com.tarea.domain.professionalstudy.event.ProfessionalStudyDeletedEvent;
import com.tarea.domain.professionalstudy.event.ProfessionalStudyRegisteredEvent;
import com.tarea.domain.professionalstudy.event.ProfessionalStudyUpdatedEvent;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProfessionalStudy extends AggregateRoot {
    private final ProfessionalStudyId id;
    private StudyId studyId;
    private ProfessionalId professionalId;
    private String title;
    private String university;
    private boolean valid;
    private String resolutionNumber;
    private CountryId countryId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ProfessionalStudy(ProfessionalStudyId id, StudyId studyId, ProfessionalId professionalId,
                              String title, String university, boolean valid, String resolutionNumber,
                              CountryId countryId, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.studyId = Objects.requireNonNull(studyId, "El estudio no puede ser nulo");
        this.professionalId = Objects.requireNonNull(professionalId, "El profesional no puede ser nulo");
        this.title = title;
        this.university = university;
        this.valid = valid;
        this.resolutionNumber = resolutionNumber;
        this.countryId = Objects.requireNonNull(countryId, "El país no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static ProfessionalStudy register(StudyId studyId, ProfessionalId professionalId, String title,
                                             String university, Boolean valid, String resolutionNumber,
                                             CountryId countryId) {
        ProfessionalStudyId id = ProfessionalStudyId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean validValue = valid != null ? valid : false;

        ProfessionalStudy professionalStudy = new ProfessionalStudy(id, studyId, professionalId, title,
                                                                    university, validValue, resolutionNumber,
                                                                    countryId, now, null);
        professionalStudy.recordEvent(new ProfessionalStudyRegisteredEvent(id, now));
        return professionalStudy;
    }

    public static ProfessionalStudy restore(ProfessionalStudyId id, StudyId studyId,
                                            ProfessionalId professionalId, String title, String university,
                                            boolean valid, String resolutionNumber, CountryId countryId,
                                            LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ProfessionalStudy(id, studyId, professionalId, title, university, valid, resolutionNumber,
                                     countryId, createdAt, updatedAt);
    }

    public void update(StudyId studyId, ProfessionalId professionalId, String title, String university,
                       Boolean valid, String resolutionNumber, CountryId countryId) {
        this.studyId = Objects.requireNonNull(studyId, "El estudio no puede ser nulo");
        this.professionalId = Objects.requireNonNull(professionalId, "El profesional no puede ser nulo");
        this.title = title;
        this.university = university;
        if (valid != null) {
            this.valid = valid;
        }
        this.resolutionNumber = resolutionNumber;
        this.countryId = Objects.requireNonNull(countryId, "El país no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new ProfessionalStudyUpdatedEvent(this.id, this.studyId, this.professionalId,
                                                      this.countryId, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new ProfessionalStudyDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ProfessionalStudyId id() { return id; }
    public StudyId studyId() { return studyId; }
    public ProfessionalId professionalId() { return professionalId; }
    public String title() { return title; }
    public String university() { return university; }
    public boolean valid() { return valid; }
    public String resolutionNumber() { return resolutionNumber; }
    public CountryId countryId() { return countryId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
