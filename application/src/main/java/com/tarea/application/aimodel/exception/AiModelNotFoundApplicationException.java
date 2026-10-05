//Este es el lugar en donde esta alamacenado este archivo .java
package com.tarea.application.aimodel.exception;
//importa la informacion que esta en la carpeta "exception", especificamente el .java "ApplicationException"
import com.tarea.application.common.exception.ApplicationException;
//Una clase publica llamada "AiModelNotFoundApplicationException" que aplica la informacion de "ApplicationException" 
public class AiModelNotFoundApplicationException extends ApplicationException {
    // un constructor publico llamado "AiModelNotFoundApplicationException" que recibe un id
    public AiModelNotFoundApplicationException(String id) {
        // Envía a la clase padre el mensaje de error con el ID del modelo no encontrado
        super("Modelo de IA no encontrado con el ID: " + id);
    }
}
