//Este archivo sirve como objeto (Record), solo carga datos de entrada que se necesitan para crear
//o modificar algun registro

//Este es el lugar en donde esta alamacenado este archivo .java
package com.tarea.application.aimodel.command;
//importa la informacion de "ProviderModelAiId" que esta en la carpeta "valueobject"
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;
//importa numeros decimales de precision arbitraria (Se usa para resultados exactos)
import java.math.BigDecimal;
//un record publico llamado "RegisterAiModelCommand" (Record lo que hace es que funciona como un contenedor 
//inmutable de datos, se pueden llamar DTO o comando (El nombre de la carpeta))
public record RegisterAiModelCommand(
        //Identificador del proveedor del modelo de IA.
        ProviderModelAiId providerModelId,
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
        Boolean active
) {
}
