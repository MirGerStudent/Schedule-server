package org.example.core.repository.interfaces;

import jakarta.validation.Valid;
import org.example.core.model.DTO.TeacherDTO;
import org.example.core.model.Teacher;

import java.util.List;
import java.util.UUID;

public interface ITeachersRepository {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(UUID uuid);
    UUID addTeacher(TeacherDTO teacher);
    void editTeacherById(TeacherDTO teacher);
    void deleteTeacherById(UUID uuid);
}
