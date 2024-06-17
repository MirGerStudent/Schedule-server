package org.example.core.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.core.exceptions.RepositoryException;
import org.example.core.exceptions.ServiceException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Student;
import org.example.core.repository.interfaces.IStudentsRepository;
import org.example.core.service.interfaces.IStudentsService;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Validated
public class StudentsService implements IStudentsService {
    private final IStudentsRepository repository;

    public StudentsService(IStudentsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getStudentsByGroupId(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String groupID
    ) {
        return repository.getStudentsByGroupId(UUID.fromString(groupID));
    }

    @Override
    public Student getStudentById(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid
    ) {
        return repository.getStudentById(UUID.fromString(uuid));
    }

    @Override
    public UUID addStudent(@Valid StudentDTO student) throws ServiceException {
        try {
            return repository.addStudent(student);
        } catch (RepositoryException exception) {
            throw new ServiceException("Repository Error: ", exception);
        }
    }

    @Override
    public void deleteStudentById(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid
    ) throws RepositoryException {
        repository.deleteStudentById(UUID.fromString(uuid));
    }

    @Override
    public void editStudent(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid,
            @Valid StudentDTO student) throws RepositoryException {
        repository.editStudent(
                new Student(
                        UUID.fromString(uuid),
                        student.getName(),
                        student.getSurname(),
                        student.getPatronymic(),
                        student.getStatus(),
                        UUID.fromString(student.getGroupId())
                )
        );
    }

    @Override
    public void addStudentByIdToLesson(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid
    ) {

    }
}
