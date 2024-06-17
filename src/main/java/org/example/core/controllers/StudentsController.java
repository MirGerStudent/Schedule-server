package org.example.core.controllers;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import jakarta.websocket.server.PathParam;
import org.example.core.exceptions.RepositoryException;
import org.example.core.exceptions.ServiceException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Responce.CommonResponse;
import org.example.core.model.Student;
import org.example.core.service.interfaces.IStudentsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/students")
public class StudentsController {
    private final IStudentsService studentsService;

    public StudentsController(IStudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<CommonResponse<List<Student>>> getStudentsByGroupId(@PathVariable("groupId") String groupId) {
        try {
            return ResponseEntity.ok(new CommonResponse<>(studentsService.getStudentsByGroupId(groupId)));
        } catch (UnexpectedTypeException exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new CommonResponse<>(exception.toString()));
        }
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<CommonResponse<Student>> getStudentById(@PathVariable("studentId") String studentId) {
        try {
            return ResponseEntity.ok(new CommonResponse<>(studentsService.getStudentById(studentId)));
        } catch (UnexpectedTypeException exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new CommonResponse<>(exception.toString()));
        }
    }

    @PostMapping
    public ResponseEntity<CommonResponse<UUID>> addStudent(@RequestBody StudentDTO student) {
        try {
            return ResponseEntity.ok(new CommonResponse<>(studentsService.addStudent(student)));
        } catch (ConstraintViolationException | ServiceException exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new CommonResponse<>(exception.getMessage()));
        }
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<CommonResponse<Boolean>> editStudent(@PathVariable("studentId") String uuid, @RequestBody StudentDTO student){
        try {
            studentsService.editStudent(uuid, student);
            return ResponseEntity.ok(new CommonResponse<>(true));
        } catch (RepositoryException exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new CommonResponse<>(exception.toString()));
        }
    }

    @DeleteMapping
    public ResponseEntity<CommonResponse<Boolean>> deleteStudent(@PathParam("studentId") String uuid) {
        try {
            studentsService.deleteStudentById(uuid);
            return ResponseEntity.ok(new CommonResponse<>(true));
        } catch (RepositoryException exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new CommonResponse<>(exception.toString()));
        }
    }
}
