package com.tarea.infrastructure.chatconversation.adapters.in.rest.controllers;

import com.tarea.application.chatconversation.command.RegisterChatConversationCommand;
import com.tarea.application.chatconversation.command.UpdateChatConversationCommand;
import com.tarea.application.chatconversation.dto.ChatConversationResponse;
import com.tarea.application.chatconversation.usecase.DeleteChatConversationUseCase;
import com.tarea.application.chatconversation.usecase.GetChatConversationByIdUseCase;
import com.tarea.application.chatconversation.usecase.ListChatConversationUseCase;
import com.tarea.application.chatconversation.usecase.RegisterChatConversationUseCase;
import com.tarea.application.chatconversation.usecase.UpdateChatConversationUseCase;
import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.tarea.domain.priority.model.valueobject.PriorityId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.infrastructure.chatconversation.adapters.in.rest.dtos.CreateChatConversationRequest;
import com.tarea.infrastructure.chatconversation.adapters.in.rest.dtos.UpdateChatConversationRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/chat-conversations")
public class ChatConversationController {

    private final RegisterChatConversationUseCase registerUseCase;
    private final GetChatConversationByIdUseCase getByIdUseCase;
    private final ListChatConversationUseCase listUseCase;
    private final UpdateChatConversationUseCase updateUseCase;
    private final DeleteChatConversationUseCase deleteUseCase;

    public ChatConversationController(RegisterChatConversationUseCase registerUseCase,
            GetChatConversationByIdUseCase getByIdUseCase,
            ListChatConversationUseCase listUseCase,
            UpdateChatConversationUseCase updateUseCase,
            DeleteChatConversationUseCase deleteUseCase) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatConversationResponse> create(@Valid @RequestBody CreateChatConversationRequest request) {
        var command = new RegisterChatConversationCommand(
                new ConversationStatusId(request.conversationStatusId()),
                new PriorityId(request.priorityId()),
                request.lastMessageAt(),
                request.closed(),
                request.closedAt(),
                request.closedBy() != null ? new ProfessionalId(request.closedBy()) : null
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerUseCase.execute(command));
    }

    @GetMapping
    public ResponseEntity<List<ChatConversationResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatConversationResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatConversationId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatConversationResponse> update(@PathVariable UUID id,
            @Valid @RequestBody UpdateChatConversationRequest request) {
        var command = new UpdateChatConversationCommand(
                new ChatConversationId(id),
                new ConversationStatusId(request.conversationStatusId()),
                new PriorityId(request.priorityId()),
                request.lastMessageAt(),
                request.closed(),
                request.closedAt(),
                request.closedBy() != null ? new ProfessionalId(request.closedBy()) : null
        );

        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatConversationId(id));
        return ResponseEntity.noContent().build();
    }
}
