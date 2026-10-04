package com.tarea.infrastructure.chatconversationaisetting.adapters.in.rest.controllers;

import com.tarea.application.chatconversationaisetting.command.RegisterChatConversationAiSettingCommand;
import com.tarea.application.chatconversationaisetting.command.UpdateChatConversationAiSettingCommand;
import com.tarea.application.chatconversationaisetting.dto.ChatConversationAiSettingResponse;
import com.tarea.application.chatconversationaisetting.usecase.DeleteChatConversationAiSettingUseCase;
import com.tarea.application.chatconversationaisetting.usecase.GetChatConversationAiSettingByIdUseCase;
import com.tarea.application.chatconversationaisetting.usecase.ListChatConversationAiSettingUseCase;
import com.tarea.application.chatconversationaisetting.usecase.RegisterChatConversationAiSettingUseCase;
import com.tarea.application.chatconversationaisetting.usecase.UpdateChatConversationAiSettingUseCase;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.tarea.infrastructure.chatconversationaisetting.adapters.in.rest.dtos.CreateChatConversationAiSettingRequest;
import com.tarea.infrastructure.chatconversationaisetting.adapters.in.rest.dtos.UpdateChatConversationAiSettingRequest;
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
@RequestMapping("/api/chat-conversation-ai-settings")
public class ChatConversationAiSettingController {

    private final RegisterChatConversationAiSettingUseCase registerUseCase;
    private final GetChatConversationAiSettingByIdUseCase getByIdUseCase;
    private final ListChatConversationAiSettingUseCase listUseCase;
    private final UpdateChatConversationAiSettingUseCase updateUseCase;
    private final DeleteChatConversationAiSettingUseCase deleteUseCase;

    public ChatConversationAiSettingController(RegisterChatConversationAiSettingUseCase registerUseCase,
            GetChatConversationAiSettingByIdUseCase getByIdUseCase,
            ListChatConversationAiSettingUseCase listUseCase,
            UpdateChatConversationAiSettingUseCase updateUseCase,
            DeleteChatConversationAiSettingUseCase deleteUseCase) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatConversationAiSettingResponse> create(@Valid @RequestBody CreateChatConversationAiSettingRequest request) {
        var command = new RegisterChatConversationAiSettingCommand(
                new ChatConversationId(request.conversationId()),
                request.aiEnabled(),
                new AiModelId(request.defaultModelId())
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerUseCase.execute(command));
    }

    @GetMapping
    public ResponseEntity<List<ChatConversationAiSettingResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatConversationAiSettingResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatConversationAiSettingId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatConversationAiSettingResponse> update(@PathVariable UUID id,
            @Valid @RequestBody UpdateChatConversationAiSettingRequest request) {
        var command = new UpdateChatConversationAiSettingCommand(
                new ChatConversationAiSettingId(id),
                new ChatConversationId(request.conversationId()),
                request.aiEnabled(),
                new AiModelId(request.defaultModelId())
        );

        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatConversationAiSettingId(id));
        return ResponseEntity.noContent().build();
    }
}
