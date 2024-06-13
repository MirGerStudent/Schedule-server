package org.example.core.service;

import jakarta.validation.ConstraintDeclarationException;
import jakarta.validation.Valid;
import org.example.core.exceptions.InsertDataException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Student;
import org.example.core.repository.interfaces.IStudentsRepository;
import org.example.core.service.interfaces.IStudentsService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Validated
@Service
public class StudentsService implements IStudentsService {
    private final IStudentsRepository repository;

    public StudentsService(IStudentsRepository repository) {
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
    public UUID addStudents(@Valid StudentDTO student) throws InsertDataException {
        try {
//            UUID result = repository.addStudents(student);
//            return result;
            return repository.addStudents(student);
        } catch (ConstraintDeclarationException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void deleteStudentById(UUID uuid) {

    }

    @Override
    public UUID editStudent(StudentDTO student) {
        return null;
    }

    @Override
    public void addStudentByIdToLesson(UUID uuid) {

    }
}
