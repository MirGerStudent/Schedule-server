package org.example.core.controllers;

import jakarta.validation.Valid;
import org.example.core.exceptions.InsertDataException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Student;
import org.example.core.service.interfaces.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentsController {
    private final IStudentsService studentsService;

    @Autowired
    public StudentsController(IStudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping
    public List<Student> getStudentsByGroup(@RequestParam("groupId") UUID groupId) {
        return studentsService.getStudentsByGroupId(groupId);
    }

    @PostMapping
    public UUID addStudent(@Valid @RequestBody StudentDTO student) throws InsertDataException {
        return studentsService.addStudents(student);
    }
}
