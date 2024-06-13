package org.example.core.service.interfaces;

import jakarta.validation.Valid;
import org.example.core.model.DTO.TeacherDTO;
import org.example.core.model.Teacher;

import java.util.List;
import java.util.UUID;

public interface ITeachersService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(UUID uuid);
    UUID addTeacher(@Valid TeacherDTO teacher);
    void editTeacherById(@Valid TeacherDTO teacher);
    void deleteTeacherById(UUID uuid);
}
