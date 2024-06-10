package org.example.core.service.interfaces;

import org.example.core.exceptions.InsertDataException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Student;

import java.util.List;
import java.util.UUID;

public interface IStudentsService {
    List<Student> getStudentsByGroupId(UUID groupID);
    Student getStudentById(UUID uuid);
    UUID addStudents(StudentDTO student) throws InsertDataException;
    void deleteStudentById(UUID uuid);
}
