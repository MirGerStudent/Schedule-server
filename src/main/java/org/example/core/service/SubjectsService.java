package org.example.core.service;

import org.example.core.model.DTO.SubjectDTO;
import org.example.core.model.Subject;
import org.example.core.repository.interfaces.ISubjectsRepository;
import org.example.core.service.interfaces.ISubjectsService;

import java.util.UUID;

public class SubjectsService implements ISubjectsService {
    private final ISubjectsRepository subjectsRepository;

    public SubjectsService(ISubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
    }

    @Override
    public Subject getSubjectById(UUID subjectId) {
        return null;
    }

    @Override
    public UUID addSubject(SubjectDTO subject) {
        return null;
    }

    @Override
    public Subject editSubject(SubjectDTO subject) {
        return null;
    }

    @Override
    public void deleteSubjectById(UUID subjectId) {

    }
}
