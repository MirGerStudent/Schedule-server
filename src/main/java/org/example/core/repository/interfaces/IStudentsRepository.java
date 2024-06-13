package org.example.core.repository.interfaces;

import jakarta.validation.Valid;
import org.example.core.exceptions.InsertDataException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Student;

import java.util.List;
import java.util.UUID;

public interface IStudentsRepository {
    List<Student> getStudentsByGroupId(UUID groupID);
    Student getStudentById(UUID uuid);
    UUID addStudents(StudentDTO student) throws InsertDataException;
    UUID editStudent(StudentDTO student);
    void deleteStudentById(UUID uuid);
    void addStudentByIdToLesson(UUID uuid);
}
