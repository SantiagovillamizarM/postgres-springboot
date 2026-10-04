package com.tarea.domain.risklevel.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.risklevel.event.RiskLevelDeletedEvent;
import com.tarea.domain.risklevel.event.RiskLevelRegisteredEvent;
import com.tarea.domain.risklevel.event.RiskLevelUpdatedEvent;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;

import java.time.LocalDateTime;
import java.util.Objects;

public class RiskLevel extends AggregateRoot {
    private final RiskLevelId id;
    private String code;
    private String name;
    private boolean active;
    private Integer severity;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private RiskLevel(RiskLevelId id, String code, String name, boolean active, Integer severity,
                      LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        this.active = active;
        this.severity = severity;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static RiskLevel register(String code, String name, Boolean active, Integer severity) {
        RiskLevelId id = RiskLevelId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        RiskLevel riskLevel = new RiskLevel(id, code, name, activeValue, severity, now, null);
        riskLevel.recordEvent(new RiskLevelRegisteredEvent(id, now));
        return riskLevel;
    }

    public static RiskLevel restore(RiskLevelId id, String code, String name, boolean active,
                                    Integer severity, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new RiskLevel(id, code, name, active, severity, createdAt, updatedAt);
    }

    public void update(String code, String name, Boolean active, Integer severity) {
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        if (active != null) {
            this.active = active;
        }
        this.severity = severity;
        this.updatedAt = LocalDateTime.now();

        recordEvent(new RiskLevelUpdatedEvent(this.id, this.code, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new RiskLevelDeletedEvent(this.id, LocalDateTime.now()));
    }

    public RiskLevelId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public Integer severity() { return severity; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
