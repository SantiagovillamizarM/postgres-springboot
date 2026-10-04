package com.tarea.domain.mentalstatusexam.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.mentalstatusexam.event.MentalStatusExamDeletedEvent;
import com.tarea.domain.mentalstatusexam.event.MentalStatusExamRegisteredEvent;
import com.tarea.domain.mentalstatusexam.event.MentalStatusExamUpdatedEvent;
import com.tarea.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;

import java.time.LocalDateTime;
import java.util.Objects;

public class MentalStatusExam extends AggregateRoot {
    private final MentalStatusExamId id;
    private EncounterId encounterId;
    private String appearance;
    private String behavior;
    private String attitude;
    private String consciousness;
    private String orientation;
    private String attention;
    private String memory;
    private String speech;
    private String mood;
    private String affect;
    private String thoughtProcess;
    private String thoughtContent;
    private String perception;
    private String judgment;
    private String insight;
    private String psychomotorActivity;
    private String observations;
    private final ProfessionalId createdBy;
    private final LocalDateTime createdAt;

    private MentalStatusExam(MentalStatusExamId id, EncounterId encounterId, String appearance,
                             String behavior, String attitude, String consciousness, String orientation,
                             String attention, String memory, String speech, String mood, String affect,
                             String thoughtProcess, String thoughtContent, String perception, String judgment,
                             String insight, String psychomotorActivity, String observations,
                             ProfessionalId createdBy, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.encounterId = Objects.requireNonNull(encounterId, "El encuentro no puede ser nulo");
        this.appearance = appearance;
        this.behavior = behavior;
        this.attitude = attitude;
        this.consciousness = consciousness;
        this.orientation = orientation;
        this.attention = attention;
        this.memory = memory;
        this.speech = speech;
        this.mood = mood;
        this.affect = affect;
        this.thoughtProcess = thoughtProcess;
        this.thoughtContent = thoughtContent;
        this.perception = perception;
        this.judgment = judgment;
        this.insight = insight;
        this.psychomotorActivity = psychomotorActivity;
        this.observations = observations;
        this.createdBy = Objects.requireNonNull(createdBy, "El profesional que crea no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
    }

    public static MentalStatusExam register(EncounterId encounterId, String appearance, String behavior,
                                            String attitude, String consciousness, String orientation,
                                            String attention, String memory, String speech, String mood,
                                            String affect, String thoughtProcess, String thoughtContent,
                                            String perception, String judgment, String insight,
                                            String psychomotorActivity, String observations,
                                            ProfessionalId createdBy) {
        MentalStatusExamId id = MentalStatusExamId.generate();
        LocalDateTime now = LocalDateTime.now();

        MentalStatusExam mentalStatusExam = new MentalStatusExam(id, encounterId, appearance, behavior,
                                                                 attitude, consciousness, orientation,
                                                                 attention, memory, speech, mood, affect,
                                                                 thoughtProcess, thoughtContent, perception,
                                                                 judgment, insight, psychomotorActivity,
                                                                 observations, createdBy, now);
        mentalStatusExam.recordEvent(new MentalStatusExamRegisteredEvent(id, now));
        return mentalStatusExam;
    }

    public static MentalStatusExam restore(MentalStatusExamId id, EncounterId encounterId, String appearance,
                                           String behavior, String attitude, String consciousness,
                                           String orientation, String attention, String memory, String speech,
                                           String mood, String affect, String thoughtProcess,
                                           String thoughtContent, String perception, String judgment,
                                           String insight, String psychomotorActivity, String observations,
                                           ProfessionalId createdBy, LocalDateTime createdAt) {
        return new MentalStatusExam(id, encounterId, appearance, behavior, attitude, consciousness,
                                    orientation, attention, memory, speech, mood, affect, thoughtProcess,
                                    thoughtContent, perception, judgment, insight, psychomotorActivity,
                                    observations, createdBy, createdAt);
    }

    public void update(EncounterId encounterId, String appearance, String behavior, String attitude,
                       String consciousness, String orientation, String attention, String memory,
                       String speech, String mood, String affect, String thoughtProcess,
                       String thoughtContent, String perception, String judgment, String insight,
                       String psychomotorActivity, String observations) {
        this.encounterId = Objects.requireNonNull(encounterId, "El encuentro no puede ser nulo");
        this.appearance = appearance;
        this.behavior = behavior;
        this.attitude = attitude;
        this.consciousness = consciousness;
        this.orientation = orientation;
        this.attention = attention;
        this.memory = memory;
        this.speech = speech;
        this.mood = mood;
        this.affect = affect;
        this.thoughtProcess = thoughtProcess;
        this.thoughtContent = thoughtContent;
        this.perception = perception;
        this.judgment = judgment;
        this.insight = insight;
        this.psychomotorActivity = psychomotorActivity;
        this.observations = observations;

        recordEvent(new MentalStatusExamUpdatedEvent(this.id, this.encounterId, this.createdBy,
                                                     LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new MentalStatusExamDeletedEvent(this.id, LocalDateTime.now()));
    }

    public MentalStatusExamId id() { return id; }
    public EncounterId encounterId() { return encounterId; }
    public String appearance() { return appearance; }
    public String behavior() { return behavior; }
    public String attitude() { return attitude; }
    public String consciousness() { return consciousness; }
    public String orientation() { return orientation; }
    public String attention() { return attention; }
    public String memory() { return memory; }
    public String speech() { return speech; }
    public String mood() { return mood; }
    public String affect() { return affect; }
    public String thoughtProcess() { return thoughtProcess; }
    public String thoughtContent() { return thoughtContent; }
    public String perception() { return perception; }
    public String judgment() { return judgment; }
    public String insight() { return insight; }
    public String psychomotorActivity() { return psychomotorActivity; }
    public String observations() { return observations; }
    public ProfessionalId createdBy() { return createdBy; }
    public LocalDateTime createdAt() { return createdAt; }
}
