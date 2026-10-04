package com.tarea.domain.chatescalationassignment.port.repository;

import com.tarea.domain.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.tarea.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

import java.util.List;
import java.util.Optional;

public interface ChatEscalationAssignmentRepository {
    ChatEscalationAssignment save(ChatEscalationAssignment chatEscalationAssignment);
    Optional<ChatEscalationAssignment> findById(ChatEscalationAssignmentId id);
    List<ChatEscalationAssignment> findAll();
    void delete(ChatEscalationAssignment chatEscalationAssignment);
}
