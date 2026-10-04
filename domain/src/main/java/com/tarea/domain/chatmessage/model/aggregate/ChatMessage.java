package com.tarea.domain.chatmessage.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;
import com.tarea.domain.chatmessage.event.ChatMessageDeletedEvent;
import com.tarea.domain.chatmessage.event.ChatMessageRegisteredEvent;
import com.tarea.domain.chatmessage.event.ChatMessageUpdatedEvent;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatMessage extends AggregateRoot {
    private final ChatMessageId id;
    private ChatConversationId conversationId;
    private MessageTypeId messageTypeId;
    private ChatParticipantId participantId;
    private String content;
    private String metadata;
    private final LocalDateTime createdAt;

    private ChatMessage(ChatMessageId id, ChatConversationId conversationId, MessageTypeId messageTypeId,
                        ChatParticipantId participantId, String content, String metadata,
                        LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.conversationId = Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        this.messageTypeId = Objects.requireNonNull(messageTypeId, "El tipo de mensaje no puede ser nulo");
        this.participantId = Objects.requireNonNull(participantId, "El participante no puede ser nulo");
        this.content = content;
        this.metadata = metadata;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
    }

    public static ChatMessage register(ChatConversationId conversationId, MessageTypeId messageTypeId,
                                       ChatParticipantId participantId, String content, String metadata) {
        ChatMessageId id = ChatMessageId.generate();
        LocalDateTime now = LocalDateTime.now();

        ChatMessage chatMessage = new ChatMessage(id, conversationId, messageTypeId, participantId, content,
                                                  metadata, now);
        chatMessage.recordEvent(new ChatMessageRegisteredEvent(id, now));
        return chatMessage;
    }

    public static ChatMessage restore(ChatMessageId id, ChatConversationId conversationId,
                                      MessageTypeId messageTypeId, ChatParticipantId participantId,
                                      String content, String metadata, LocalDateTime createdAt) {
        return new ChatMessage(id, conversationId, messageTypeId, participantId, content, metadata, createdAt);
    }

    public void update(ChatConversationId conversationId, MessageTypeId messageTypeId,
                       ChatParticipantId participantId, String content, String metadata) {
        this.conversationId = Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        this.messageTypeId = Objects.requireNonNull(messageTypeId, "El tipo de mensaje no puede ser nulo");
        this.participantId = Objects.requireNonNull(participantId, "El participante no puede ser nulo");
        this.content = content;
        this.metadata = metadata;

        recordEvent(new ChatMessageUpdatedEvent(this.id, this.conversationId, this.messageTypeId,
                                                this.participantId, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatMessageDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ChatMessageId id() { return id; }
    public ChatConversationId conversationId() { return conversationId; }
    public MessageTypeId messageTypeId() { return messageTypeId; }
    public ChatParticipantId participantId() { return participantId; }
    public String content() { return content; }
    public String metadata() { return metadata; }
    public LocalDateTime createdAt() { return createdAt; }
}
