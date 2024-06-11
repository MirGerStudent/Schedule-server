package org.example.core.service.interfaces;

import org.example.core.model.DTO.TeacherDTO;
import org.example.core.model.Teacher;

import java.util.List;
import java.util.UUID;

public interface ITeachersService {
    List<Teacher> getAllTeachers();
    Teacher getTeacherById(UUID uuid);
    UUID addTeacher(TeacherDTO teacher);
    void deleteTeacherById(UUID uuid);
}
