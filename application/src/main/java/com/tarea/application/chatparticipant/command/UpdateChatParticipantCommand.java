package com.tarea.application.chatparticipant.command;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;

public record UpdateChatParticipantCommand(
        ChatParticipantId id,
        ChatConversationId conversationId,
        SenderTypeId participantTypeId,
        PatientId patientId,
        ProfessionalId professionalId
) {
}
