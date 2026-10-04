package com.tarea.application.professionalstudy.command;

import com.tarea.domain.country.model.valueobject.CountryId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.study.model.valueobject.StudyId;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;

public record UpdateProfessionalStudyCommand(
        ProfessionalStudyId id,
        StudyId studyId,
        ProfessionalId professionalId,
        String title,
        String university,
        Boolean valid,
        String resolutionNumber,
        CountryId countryId
) {
}
