package org.example.core.repository.interfaces;

import org.example.core.exceptions.RepositoryException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Student;

import java.util.List;
import java.util.UUID;

public interface IStudentsRepository {
    List<Student> getStudentsByGroupId(UUID groupID);
    Student getStudentById(UUID uuid);
    UUID addStudent(StudentDTO student) throws RepositoryException;
    void editStudent(Student student) throws RepositoryException;
    void deleteStudentById(UUID uuid) throws RepositoryException;
    void addStudentByIdToLesson(UUID uuid);
}
