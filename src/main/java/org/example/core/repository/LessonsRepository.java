package org.example.core.repository;

import org.example.core.model.DTO.LessonDTO;
import org.example.core.model.Lesson;
import org.example.core.repository.interfaces.ILessonsRepository;

import java.util.List;
import java.util.UUID;

public class LessonsRepository implements ILessonsRepository {
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
