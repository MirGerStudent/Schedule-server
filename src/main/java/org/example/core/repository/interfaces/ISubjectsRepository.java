package org.example.core.repository.interfaces;

import org.example.core.model.DTO.SubjectDTO;
import org.example.core.model.Subject;

import java.util.List;
import java.util.UUID;

public interface ISubjectsRepository {
    List<Subject> getSubjectByGroupId(UUID groupId);
    Subject getSubjectById(UUID subjectId);
    UUID addSubject(SubjectDTO subject);
    Subject editSubject(SubjectDTO subject);
    void deleteSubjectById(UUID subjectId);
}
