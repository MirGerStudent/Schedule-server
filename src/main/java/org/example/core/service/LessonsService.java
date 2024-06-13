package org.example.core.service;

import org.example.core.model.DTO.LessonDTO;
import org.example.core.model.Lesson;
import org.example.core.repository.interfaces.ILessonsRepository;
import org.example.core.service.interfaces.ILessonsService;

import java.util.List;
import java.util.UUID;

public class LessonsService implements ILessonsService {
    private final ILessonsRepository repository;

    public LessonsService(ILessonsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Lesson getLessonById(UUID uuid) {
        return null;
    }

    @Override
    public List<Lesson> getLessonsByGroupId(UUID groupId) {
        return List.of();
    }

    @Override
    public List<Lesson> getLessonsBySubjectId(UUID subjectId) {
        return List.of();
    }

    @Override
    public List<Lesson> getLessonsByTeacherId(UUID teacherId) {
        return List.of();
    }

    @Override
    public UUID addLesson(LessonDTO lesson) {
        return null;
    }

    @Override
    public void editLesson(LessonDTO lesson) {

    }

    @Override
    public void deleteLessonById(UUID uuid) {

    }
}
