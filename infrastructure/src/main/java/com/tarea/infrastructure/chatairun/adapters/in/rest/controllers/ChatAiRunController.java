package com.tarea.infrastructure.chatairun.adapters.in.rest.controllers;

import com.tarea.application.chatairun.command.RegisterChatAiRunCommand;
import com.tarea.application.chatairun.command.UpdateChatAiRunCommand;
import com.tarea.application.chatairun.dto.ChatAiRunResponse;
import com.tarea.application.chatairun.usecase.DeleteChatAiRunUseCase;
import com.tarea.application.chatairun.usecase.GetChatAiRunByIdUseCase;
import com.tarea.application.chatairun.usecase.ListChatAiRunUseCase;
import com.tarea.application.chatairun.usecase.RegisterChatAiRunUseCase;
import com.tarea.application.chatairun.usecase.UpdateChatAiRunUseCase;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.infrastructure.chatairun.adapters.in.rest.dtos.CreateChatAiRunRequest;
import com.tarea.infrastructure.chatairun.adapters.in.rest.dtos.UpdateChatAiRunRequest;
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
@RequestMapping("/api/chat-ai-runs")
public class ChatAiRunController {

    private final RegisterChatAiRunUseCase registerUseCase;
    private final GetChatAiRunByIdUseCase getByIdUseCase;
    private final ListChatAiRunUseCase listUseCase;
    private final UpdateChatAiRunUseCase updateUseCase;
    private final DeleteChatAiRunUseCase deleteUseCase;

    public ChatAiRunController(RegisterChatAiRunUseCase registerUseCase,
            GetChatAiRunByIdUseCase getByIdUseCase,
            ListChatAiRunUseCase listUseCase,
            UpdateChatAiRunUseCase updateUseCase,
            DeleteChatAiRunUseCase deleteUseCase) {
        this.registerUseCase = registerUseCase;
        this.getByIdUseCase = getByIdUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
        this.deleteUseCase = deleteUseCase;
    }

    @PostMapping
    public ResponseEntity<ChatAiRunResponse> create(@Valid @RequestBody CreateChatAiRunRequest request) {
        var command = new RegisterChatAiRunCommand(
                new ChatConversationId(request.conversationId()),
                new ChatMessageId(request.messageId()),
                new AiModelId(request.modelId()),
                new AiRunStatusId(request.aiRunStatusId())
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(registerUseCase.execute(command));
    }

    @GetMapping
    public ResponseEntity<List<ChatAiRunResponse>> findAll() {
        return ResponseEntity.ok(listUseCase.execute());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatAiRunResponse> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(getByIdUseCase.execute(new ChatAiRunId(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChatAiRunResponse> update(@PathVariable UUID id,
            @Valid @RequestBody UpdateChatAiRunRequest request) {
        var command = new UpdateChatAiRunCommand(
                new ChatAiRunId(id),
                new ChatConversationId(request.conversationId()),
                new ChatMessageId(request.messageId()),
                new AiModelId(request.modelId()),
                new AiRunStatusId(request.aiRunStatusId())
        );

        return ResponseEntity.ok(updateUseCase.execute(command));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        deleteUseCase.execute(new ChatAiRunId(id));
        return ResponseEntity.noContent().build();
    }
}
