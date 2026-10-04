package com.tarea.domain.medicationroute.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.medicationroute.event.MedicationRouteDeletedEvent;
import com.tarea.domain.medicationroute.event.MedicationRouteRegisteredEvent;
import com.tarea.domain.medicationroute.event.MedicationRouteUpdatedEvent;
import com.tarea.domain.medicationroute.model.valueobject.MedicationRouteId;

import java.time.LocalDateTime;
import java.util.Objects;

public class MedicationRoute extends AggregateRoot {
    private final MedicationRouteId id;
    private String code;
    private String name;
    private boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private MedicationRoute(MedicationRouteId id, String code, String name, boolean active,
                            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static MedicationRoute register(String code, String name, Boolean active) {
        MedicationRouteId id = MedicationRouteId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        MedicationRoute medicationRoute = new MedicationRoute(id, code, name, activeValue, now, null);
        medicationRoute.recordEvent(new MedicationRouteRegisteredEvent(id, now));
        return medicationRoute;
    }

    public static MedicationRoute restore(MedicationRouteId id, String code, String name, boolean active,
                                          LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new MedicationRoute(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name, Boolean active) {
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        if (active != null) {
            this.active = active;
        }
        this.updatedAt = LocalDateTime.now();

        recordEvent(new MedicationRouteUpdatedEvent(this.id, this.code, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new MedicationRouteDeletedEvent(this.id, LocalDateTime.now()));
    }

    public MedicationRouteId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
