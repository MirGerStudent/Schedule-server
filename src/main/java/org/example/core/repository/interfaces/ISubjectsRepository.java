package org.example.core.repository.interfaces;

import org.example.core.model.DTO.SubjectDTO;
import org.example.core.model.Subject;

import java.util.UUID;

public interface ISubjectsRepository {
    Subject getSubjectById(UUID subjectId);
    UUID addSubject(SubjectDTO subject);
    Subject editSubject(SubjectDTO subject);
    void deleteSubjectById(UUID subjectId);
}
