package org.example.core.service;

import org.example.core.model.DTO.TeacherDTO;
import org.example.core.model.Teacher;
import org.example.core.repository.interfaces.ITeachersRepository;
import org.example.core.service.interfaces.ITeachersService;

import java.util.List;
import java.util.UUID;

public class TeachersService implements ITeachersService {
    private final ITeachersRepository teachersRepository;

    public TeachersService(ITeachersRepository teachersRepository) {
        this.teachersRepository = teachersRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return List.of();
    }

    @Override
    public Teacher getTeacherById(UUID uuid) {
        return null;
    }

    @Override
    public UUID addTeacher(TeacherDTO teacher) {
        return null;
    }

    @Override
    public void deleteTeacherById(UUID uuid) {

    }

    @Override
    public void editTeacherById(TeacherDTO teacher) {

    }
}
