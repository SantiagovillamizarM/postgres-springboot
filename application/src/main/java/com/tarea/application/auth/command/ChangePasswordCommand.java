package com.tarea.application.auth.command;

import com.tarea.domain.auth.model.valueobject.UserId;

public record ChangePasswordCommand(
        UserId userId,
        String currentPassword,
        String newPassword
) {
}
