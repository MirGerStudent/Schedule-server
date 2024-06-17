package org.example.core.service.interfaces;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.core.exceptions.RepositoryException;
import org.example.core.exceptions.ServiceException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Student;

import java.util.List;
import java.util.UUID;

public interface IStudentsService {
    List<Student> getStudentsByGroupId(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String groupID
    );
    Student getStudentById(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid
    );
    UUID addStudent(@Valid StudentDTO student) throws ServiceException;
    void editStudent(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String studentId,
            @Valid StudentDTO student) throws RepositoryException;
    void deleteStudentById(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid
    ) throws RepositoryException;
    void addStudentByIdToLesson(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid
    );
}
