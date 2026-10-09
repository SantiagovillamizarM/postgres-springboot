package com.tarea.application.auth.command;

public record LoginCommand(
        String email,
        String password
) {
}
