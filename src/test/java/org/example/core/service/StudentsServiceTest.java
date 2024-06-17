package org.example.core.service;

import org.example.core.exceptions.RepositoryException;
import org.example.core.exceptions.ServiceException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Student;
import org.example.core.repository.StudentsRepository;
import org.example.core.repository.interfaces.IStudentsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentsServiceTest {
    private IStudentsRepository studentsRepository;
    private StudentsService studentsService;

    @BeforeEach
    void setUp() {
        studentsRepository = mock(StudentsRepository.class);
        studentsService = new StudentsService(studentsRepository);
    }

    @Test
    void getStudentsByGroupIdTest() {
        ArrayList<Student> students = new ArrayList<>();
        UUID uuid = UUID.fromString("d0ce86d3-2aaa-4b84-b2b3-b950e91217a5");
        when(studentsRepository.getStudentsByGroupId(uuid)).thenReturn(new ArrayList<>());
        List<Student> answer = studentsService.getStudentsByGroupId(uuid.toString());
        assertEquals(students, answer);
    }

    @Test
    void getStudentByIdTest() {
        Student student = new Student(UUID.fromString("be33d95c-31c6-4990-b034-8617b1ba831d"), "gerhard", "mikula", "Stanislavovich", "ACTIVE", UUID.fromString("d0ce86d3-2aaa-4b84-b2b3-b950e91217a5"));
        UUID uuid = UUID.fromString("be33d95c-31c6-4990-b034-8617b1ba831d");
        when(studentsRepository.getStudentById(uuid)).thenReturn(student);
        Student answer = studentsService.getStudentById(uuid.toString());
        assertEquals(student, answer);
    }

    @Test
    void addStudentTest() throws RepositoryException, ServiceException {
        UUID uuid = UUID.randomUUID();
        StudentDTO student = new StudentDTO("Anon", "Anon", "Anon", "ACTIVE", UUID.randomUUID().toString());
        when(studentsRepository.addStudent(student)).thenReturn(uuid);
        UUID answer = studentsService.addStudent(student);
        verify(studentsRepository, times(1)).addStudent(student);
        assertEquals(answer, uuid);
    }
}