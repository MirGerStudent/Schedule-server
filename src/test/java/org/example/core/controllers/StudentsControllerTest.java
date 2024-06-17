package org.example.core.controllers;

import org.example.core.exceptions.RepositoryException;
import org.example.core.exceptions.ServiceException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Responce.CommonResponse;
import org.example.core.model.Student;
import org.example.core.service.StudentsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentsControllerTest {
    StudentsService service;
    StudentsController controller;

    @BeforeEach
    void setUp() {
        service = mock(StudentsService.class);
        controller = new StudentsController(service);
    }

    @Test
    void getStudentsByGroupIdTest() {
        UUID uuid = UUID.randomUUID();
        ResponseEntity<CommonResponse<List<Student>>> response = ResponseEntity.ok(new CommonResponse<>(new ArrayList<>()));
        when(service.getStudentsByGroupId(uuid.toString())).thenReturn(new ArrayList<>());
        ResponseEntity<CommonResponse<List<Student>>> answer = controller.getStudentsByGroupId(uuid.toString());
        verify(service, times(1)).getStudentsByGroupId(uuid.toString());
        assertEquals(HttpStatus.OK, answer.getStatusCode());
        assertEquals(response, answer);
    }

    @Test
    void getStudentByIdTest() {
        Student student = new Student(UUID.fromString("be33d95c-31c6-4990-b034-8617b1ba831d"), "gerhard", "mikula", "Stanislavovich", "ACTIVE", UUID.fromString("d0ce86d3-2aaa-4b84-b2b3-b950e91217a5"));
        ResponseEntity<CommonResponse<Student>> response = ResponseEntity.ok(new CommonResponse<>(student));
        when(service.getStudentById(student.getId().toString())).thenReturn(student);
        ResponseEntity<CommonResponse<Student>> answer = controller.getStudentById(student.getId().toString());
        verify(service, times(1)).getStudentById(student.getId().toString());
        assertEquals(HttpStatus.OK, answer.getStatusCode());
        assertEquals(response, answer);
    }

    @Test
    void addStudentTest() throws ServiceException {
        UUID uuid = UUID.randomUUID();
        StudentDTO student = new StudentDTO("Anon", "Anon", "Anon", "ACTIVE", UUID.randomUUID().toString());
        ResponseEntity<CommonResponse<UUID>> response = ResponseEntity.ok(new CommonResponse<>(uuid));
        when(service.addStudent(student)).thenReturn(uuid);
        ResponseEntity<CommonResponse<UUID>> answer = controller.addStudent(student);
        verify(service, times(1)).addStudent(student);
        assertEquals(response, answer);
    }
}