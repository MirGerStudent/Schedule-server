package org.example.core.repository.interfaces;

import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Student;

import java.util.List;
import java.util.UUID;

public interface IStudentsRepository {
    List<Student> getStudentsByGroup(String group);
    Student getStudentById(UUID uuid);
    UUID addStudents(StudentDTO student);
    void deleteStudentById(UUID uuid);
//    Student updateStudent(UUID uuid, StudentDTO student);
}
