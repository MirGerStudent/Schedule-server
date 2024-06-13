package org.example.core.service.interfaces;

import jakarta.validation.Valid;
import org.example.core.model.DTO.LessonDTO;
import org.example.core.model.Lesson;

import java.util.List;
import java.util.UUID;

public interface ILessonsService {
    Lesson getLessonById(UUID uuid);
    List<Lesson> getLessonsByGroupId(UUID groupId);
    List<Lesson> getLessonsBySubjectId(UUID subjectId);
    List<Lesson> getLessonsByTeacherId(UUID teacherId);
    UUID addLesson(@Valid LessonDTO lesson);
    void editLesson(@Valid LessonDTO lesson);
    void deleteLessonById(UUID uuid);
}
