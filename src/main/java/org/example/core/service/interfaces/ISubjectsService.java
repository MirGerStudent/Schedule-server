package org.example.core.service.interfaces;

import jakarta.validation.Valid;
import org.example.core.model.DTO.SubjectDTO;
import org.example.core.model.Subject;

import java.util.UUID;

public interface ISubjectsService {
    Subject getSubjectById(UUID subjectId);
    UUID addSubject(@Valid SubjectDTO subject);
    void editSubject(@Valid SubjectDTO subject);
    void deleteSubjectById(UUID subjectId);
}
