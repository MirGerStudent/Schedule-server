package org.example.core.controllers;

import org.example.core.model.Student;
import org.example.core.service.interfaces.IStudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentsController {
    private IStudentsService studentsService;

    @Autowired
    public StudentsController(IStudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/{groupId}")
    public List<Student> getStudentsByGroup(@RequestParam("groupId") UUID groupId) {
        return studentsService.getStudentsByGroupId(groupId);
    }
}
