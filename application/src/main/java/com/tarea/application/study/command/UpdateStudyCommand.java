package com.tarea.application.study.command;

import com.tarea.domain.study.model.valueobject.StudyId;

public record UpdateStudyCommand(
        StudyId id,
        String name
) {
}
