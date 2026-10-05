//Este es el lugar en donde esta alamacenado este archivo .java
package com.tarea.application.aimodel.dto;
//importa numeros decimales de precision arbitraria (Se usa para resultados exactos)
import java.math.BigDecimal;
//importa el tiempo local, este usa el tiempo que tiene el pc
import java.time.LocalDateTime;
//esto importa la "Universally Unique Identifier (Identificador Único Universal)
import java.util.UUID;
//un record publico llamado "AiModelResponse" (Record lo que hace es que funciona como un contenedor 
//inmutable de datos, se pueden llamar DTO o comando (El nombre de la carpeta))
public record AiModelResponse(
        // tipo de dato y el nombre del componente
        UUID id,
        // tipo de dato y el nombre del componente
        UUID providerModelId,
        // tipo de dato y el nombre del componente
        String nameModel,
        // tipo de dato y el nombre del componente
        String modelKey,
        // tipo de dato y el nombre del componente
        BigDecimal inputTokenPrice,
        // tipo de dato y el nombre del componente
        BigDecimal outputTokenPrice,
        // tipo de dato y el nombre del componente
        Integer maxTokens,
        // tipo de dato y el nombre del componente
        Integer contextWindow,
        // tipo de dato y el nombre del componente
        boolean active,
        // tipo de dato y el nombre del componente
        LocalDateTime createdAt,
        // tipo de dato y el nombre del componente
        LocalDateTime updatedAt
) {
}
