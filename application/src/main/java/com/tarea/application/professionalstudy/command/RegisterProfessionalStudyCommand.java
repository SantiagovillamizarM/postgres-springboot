package com.tarea.application.professionalstudy.command;

import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.study.model.valueobject.StudyId;

public record RegisterProfessionalStudyCommand(
        StudyId studyId,
        ProfessionalId professionalId,
        String title,
        String university,
        Boolean valid,
        String resolutionNumber,
        CountryId countryId
) {
}
