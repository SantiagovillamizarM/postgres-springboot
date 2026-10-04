package com.tarea.domain.riskassessment.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;
import com.tarea.domain.riskassessment.event.RiskAssessmentDeletedEvent;
import com.tarea.domain.riskassessment.event.RiskAssessmentRegisteredEvent;
import com.tarea.domain.riskassessment.event.RiskAssessmentUpdatedEvent;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;

import java.time.LocalDateTime;
import java.util.Objects;

public class RiskAssessment extends AggregateRoot {
    private final RiskAssessmentId id;
    private EncounterId encounterId;
    private RiskLevelId riskLevelId;
    private boolean suicidalIdeation;
    private boolean suicidePlan;
    private boolean suicideIntent;
    private boolean selfHarm;
    private boolean harmToOthers;
    private String riskFactors;
    private String protectiveFactors;
    private String clinicalActions;
    private String observations;
    private LocalDateTime assessedAt;
    private ProfessionalId assessedBy;

    private RiskAssessment(RiskAssessmentId id, EncounterId encounterId, RiskLevelId riskLevelId,
                           boolean suicidalIdeation, boolean suicidePlan, boolean suicideIntent,
                           boolean selfHarm, boolean harmToOthers, String riskFactors,
                           String protectiveFactors, String clinicalActions, String observations,
                           LocalDateTime assessedAt, ProfessionalId assessedBy) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.encounterId = Objects.requireNonNull(encounterId, "El encuentro no puede ser nulo");
        this.riskLevelId = Objects.requireNonNull(riskLevelId, "El nivel de riesgo no puede ser nulo");
        this.suicidalIdeation = suicidalIdeation;
        this.suicidePlan = suicidePlan;
        this.suicideIntent = suicideIntent;
        this.selfHarm = selfHarm;
        this.harmToOthers = harmToOthers;
        this.riskFactors = riskFactors;
        this.protectiveFactors = protectiveFactors;
        this.clinicalActions = clinicalActions;
        this.observations = observations;
        this.assessedAt = assessedAt;
        this.assessedBy = Objects.requireNonNull(assessedBy, "El profesional que evalúa no puede ser nulo");
    }

    public static RiskAssessment register(EncounterId encounterId, RiskLevelId riskLevelId,
                                          Boolean suicidalIdeation, Boolean suicidePlan,
                                          Boolean suicideIntent, Boolean selfHarm, Boolean harmToOthers,
                                          String riskFactors, String protectiveFactors,
                                          String clinicalActions, String observations,
                                          LocalDateTime assessedAt, ProfessionalId assessedBy) {
        RiskAssessmentId id = RiskAssessmentId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean suicidalIdeationValue = suicidalIdeation != null ? suicidalIdeation : false;
        boolean suicidePlanValue = suicidePlan != null ? suicidePlan : false;
        boolean suicideIntentValue = suicideIntent != null ? suicideIntent : false;
        boolean selfHarmValue = selfHarm != null ? selfHarm : false;
        boolean harmToOthersValue = harmToOthers != null ? harmToOthers : false;

        RiskAssessment riskAssessment = new RiskAssessment(id, encounterId, riskLevelId,
                                                           suicidalIdeationValue, suicidePlanValue,
                                                           suicideIntentValue, selfHarmValue,
                                                           harmToOthersValue, riskFactors, protectiveFactors,
                                                           clinicalActions, observations, assessedAt,
                                                           assessedBy);
        riskAssessment.recordEvent(new RiskAssessmentRegisteredEvent(id, now));
        return riskAssessment;
    }

    public static RiskAssessment restore(RiskAssessmentId id, EncounterId encounterId,
                                         RiskLevelId riskLevelId, boolean suicidalIdeation,
                                         boolean suicidePlan, boolean suicideIntent, boolean selfHarm,
                                         boolean harmToOthers, String riskFactors, String protectiveFactors,
                                         String clinicalActions, String observations,
                                         LocalDateTime assessedAt, ProfessionalId assessedBy) {
        return new RiskAssessment(id, encounterId, riskLevelId, suicidalIdeation, suicidePlan, suicideIntent,
                                  selfHarm, harmToOthers, riskFactors, protectiveFactors, clinicalActions,
                                  observations, assessedAt, assessedBy);
    }

    public void update(EncounterId encounterId, RiskLevelId riskLevelId, Boolean suicidalIdeation,
                       Boolean suicidePlan, Boolean suicideIntent, Boolean selfHarm, Boolean harmToOthers,
                       String riskFactors, String protectiveFactors, String clinicalActions,
                       String observations, LocalDateTime assessedAt, ProfessionalId assessedBy) {
        this.encounterId = Objects.requireNonNull(encounterId, "El encuentro no puede ser nulo");
        this.riskLevelId = Objects.requireNonNull(riskLevelId, "El nivel de riesgo no puede ser nulo");
        if (suicidalIdeation != null) {
            this.suicidalIdeation = suicidalIdeation;
        }
        if (suicidePlan != null) {
            this.suicidePlan = suicidePlan;
        }
        if (suicideIntent != null) {
            this.suicideIntent = suicideIntent;
        }
        if (selfHarm != null) {
            this.selfHarm = selfHarm;
        }
        if (harmToOthers != null) {
            this.harmToOthers = harmToOthers;
        }
        this.riskFactors = riskFactors;
        this.protectiveFactors = protectiveFactors;
        this.clinicalActions = clinicalActions;
        this.observations = observations;
        this.assessedAt = assessedAt;
        this.assessedBy = Objects.requireNonNull(assessedBy, "El profesional que evalúa no puede ser nulo");

        recordEvent(new RiskAssessmentUpdatedEvent(this.id, this.encounterId, this.riskLevelId,
                                                   this.assessedBy, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new RiskAssessmentDeletedEvent(this.id, LocalDateTime.now()));
    }

    public RiskAssessmentId id() { return id; }
    public EncounterId encounterId() { return encounterId; }
    public RiskLevelId riskLevelId() { return riskLevelId; }
    public boolean suicidalIdeation() { return suicidalIdeation; }
    public boolean suicidePlan() { return suicidePlan; }
    public boolean suicideIntent() { return suicideIntent; }
    public boolean selfHarm() { return selfHarm; }
    public boolean harmToOthers() { return harmToOthers; }
    public String riskFactors() { return riskFactors; }
    public String protectiveFactors() { return protectiveFactors; }
    public String clinicalActions() { return clinicalActions; }
    public String observations() { return observations; }
    public LocalDateTime assessedAt() { return assessedAt; }
    public ProfessionalId assessedBy() { return assessedBy; }
}
