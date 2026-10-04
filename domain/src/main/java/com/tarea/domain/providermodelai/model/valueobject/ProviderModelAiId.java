package com.tarea.domain.providermodelai.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ProviderModelAiId(UUID value) {
    public ProviderModelAiId {
        Objects.requireNonNull(value, "El valor de ProviderModelAiId no puede ser nulo");
    }

    public static ProviderModelAiId generate() {
        return new ProviderModelAiId(UUID.randomUUID());
    }
}
