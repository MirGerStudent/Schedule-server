package org.example.core.repository;

import org.example.core.exceptions.RepositoryException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Responce.CommonResponse;
import org.example.core.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StudentsRepositoryTest {
    private JdbcOperations jdbcOperations;
    private StudentsRepository studentRepository;

    @BeforeEach
    void setUp() {
        jdbcOperations = mock(JdbcOperations.class);
        studentRepository = new StudentsRepository(jdbcOperations);
    }

    @Test
    void getStudentsByGroupIdTest() {
        ArrayList<Student> students = new ArrayList<>();
        UUID uuid = UUID.fromString("d0ce86d3-2aaa-4b84-b2b3-b950e91217a5");
        when(jdbcOperations.query(anyString(), any(RowMapper.class))).thenReturn(students);
        List<Student> answer = studentRepository.getStudentsByGroupId(uuid);
        assertEquals(students, answer);
    }

    @Test
    void getStudentByIdTest() {
        Student student = new Student(UUID.fromString("be33d95c-31c6-4990-b034-8617b1ba831d"), "gerhard", "mikula", "Stanislavovich", "ACTIVE", UUID.fromString("d0ce86d3-2aaa-4b84-b2b3-b950e91217a5"));
        UUID uuid = UUID.fromString("be33d95c-31c6-4990-b034-8617b1ba831d");
        when(jdbcOperations.queryForObject(anyString(), any(RowMapper.class), anyString())).thenReturn(student);
        Student answer = studentRepository.getStudentById(uuid);
        assertEquals(student, answer);
    }
}