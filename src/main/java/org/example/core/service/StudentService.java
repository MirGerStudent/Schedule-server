package org.example.core.service;

import org.example.core.exceptions.InsertDataException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Student;
import org.example.core.repository.interfaces.IStudentsRepository;
import org.example.core.service.interfaces.IStudentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService implements IStudentsService {
    private final IStudentsRepository repository;

    public StudentService(IStudentsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getStudentsByGroupId(UUID groupID) {
        return repository.getStudentsByGroup(groupID.toString());
    }

    @Override
    public Student getStudentById(UUID uuid) {
        return null;
    }

    @Override
    public UUID addStudents(StudentDTO student) throws InsertDataException {
        return repository.addStudents(student);
    }

    @Override
    public void deleteStudentById(UUID uuid) {

    }
}
