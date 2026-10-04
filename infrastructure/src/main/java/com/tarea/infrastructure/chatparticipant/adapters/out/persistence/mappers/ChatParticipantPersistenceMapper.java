package com.tarea.infrastructure.chatparticipant.adapters.out.persistence.mappers;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.patient.model.valueobject.PatientId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;
import com.tarea.domain.chatparticipant.model.aggregate.ChatParticipant;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.tarea.infrastructure.chatparticipant.adapters.out.persistence.entity.ChatParticipantJpaEntity;

public class ChatParticipantPersistenceMapper {

    public ChatParticipantJpaEntity toJpa(ChatParticipant domain) {
        if (domain == null) {
            return null;
        }

        ChatParticipantJpaEntity jpa = new ChatParticipantJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setConversationId(domain.conversationId().value());
        jpa.setParticipantTypeId(domain.participantTypeId().value());
        jpa.setPatientId(domain.patientId() != null ? domain.patientId().value() : null);
        jpa.setProfessionalId(domain.professionalId() != null ? domain.professionalId().value() : null);
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public ChatParticipant toDomain(ChatParticipantJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return ChatParticipant.restore(
                new ChatParticipantId(jpa.getId()),
                new ChatConversationId(jpa.getConversationId()),
                new SenderTypeId(jpa.getParticipantTypeId()),
                jpa.getPatientId() != null ? new PatientId(jpa.getPatientId()) : null,
                jpa.getProfessionalId() != null ? new ProfessionalId(jpa.getProfessionalId()) : null,
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
