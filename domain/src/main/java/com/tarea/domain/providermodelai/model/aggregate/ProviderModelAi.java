package com.tarea.domain.providermodelai.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.providermodelai.event.ProviderModelAiDeletedEvent;
import com.tarea.domain.providermodelai.event.ProviderModelAiRegisteredEvent;
import com.tarea.domain.providermodelai.event.ProviderModelAiUpdatedEvent;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProviderModelAi extends AggregateRoot {
    private final ProviderModelAiId id;
    private String nameProviderAi;
    private String razonSocial;
    private String sitioWeb;
    private boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ProviderModelAi(ProviderModelAiId id, String nameProviderAi, String razonSocial, String sitioWeb,
                            boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.nameProviderAi = Objects.requireNonNull(nameProviderAi, "El nombre del proveedor no puede ser nulo");
        this.razonSocial = razonSocial;
        this.sitioWeb = sitioWeb;
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static ProviderModelAi register(String nameProviderAi, String razonSocial, String sitioWeb,
                                           Boolean active) {
        ProviderModelAiId id = ProviderModelAiId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        ProviderModelAi providerModelAi = new ProviderModelAi(id, nameProviderAi, razonSocial, sitioWeb, activeValue, now, null);
        providerModelAi.recordEvent(new ProviderModelAiRegisteredEvent(id, now));
        return providerModelAi;
    }

    public static ProviderModelAi restore(ProviderModelAiId id, String nameProviderAi, String razonSocial,
                                          String sitioWeb, boolean active, LocalDateTime createdAt,
                                          LocalDateTime updatedAt) {
        return new ProviderModelAi(id, nameProviderAi, razonSocial, sitioWeb, active, createdAt, updatedAt);
    }

    public void update(String nameProviderAi, String razonSocial, String sitioWeb, Boolean active) {
        this.nameProviderAi = Objects.requireNonNull(nameProviderAi, "El nombre del proveedor no puede ser nulo");
        this.razonSocial = razonSocial;
        this.sitioWeb = sitioWeb;
        if (active != null) {
            this.active = active;
        }
        this.updatedAt = LocalDateTime.now();

        recordEvent(new ProviderModelAiUpdatedEvent(this.id, this.nameProviderAi, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new ProviderModelAiDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ProviderModelAiId id() { return id; }
    public String nameProviderAi() { return nameProviderAi; }
    public String razonSocial() { return razonSocial; }
    public String sitioWeb() { return sitioWeb; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
