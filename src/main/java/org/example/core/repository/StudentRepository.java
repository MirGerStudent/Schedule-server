package org.example.core.repository;

import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Student;
import org.example.core.repository.interfaces.IStudentsRepository;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class StudentRepository implements IStudentsRepository {

    private final JdbcOperations jdbcOperations;
    private final RowMapper<Student> studentRowMapper;

    public StudentRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.studentRowMapper = (rs, rowNum) -> {
            UUID studentId = rs.getObject("student_id", UUID.class);
            String studentSurname = rs.getString("student_surname");
            String studentName = rs.getString("student_name");
            String studentPatronymic = rs.getString("student_patronymic");
            String studentStatus = rs.getString("student_status");
            UUID groupId = rs.getObject("group_id", UUID.class);
            return new Student(studentId, studentSurname, studentName, studentPatronymic, studentStatus, groupId);
        };
    }

    @Override
    public List<Student> getStudentsByGroup(String group) {
        String sql = "select * from \"students\" where \"group_id\" = ?";
        return jdbcOperations.query(sql, studentRowMapper, group);
    }

    @Override
    public Student getStudentById(UUID uuid) {
        return null;
    }

    @Override
    public UUID addStudents(StudentDTO student) {
        return null;
    }

    @Override
    public void deleteStudentById(UUID uuid) {

    }
}
