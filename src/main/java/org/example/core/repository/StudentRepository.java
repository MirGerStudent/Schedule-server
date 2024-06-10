package org.example.core.repository;

import org.example.core.exceptions.InsertDataException;
import org.example.core.model.DTO.StudentDTO;
import org.example.core.model.Student;
import org.example.core.repository.interfaces.IStudentsRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Repository
public class StudentRepository implements IStudentsRepository {
    private final JdbcOperations jdbcOperations;
    private final RowMapper<Student> studentRowMapper;

    public StudentRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.studentRowMapper = (rs, rowNum) -> {
            UUID studentId = UUID.fromString(rs.getString("student_id"));
            String studentSurname = rs.getString("student_surname");
            String studentName = rs.getString("student_name");
            String studentPatronymic = rs.getString("student_patronymic");
            String studentStatus = rs.getString("student_status");
            UUID groupId = UUID.fromString(rs.getString("group_id"));
            return new Student(studentId, studentSurname, studentName, studentPatronymic, studentStatus, groupId);
        };
    }

    @Override
    public List<Student> getStudentsByGroup(String group) {
        String sql = "SELECT * FROM \"students\" WHERE \"group_id\" = ?";
        return jdbcOperations.query(sql, studentRowMapper, group);
    }

    @Override
    public Student getStudentById(UUID uuid) {
        return null;
    }

    @Override
    public UUID addStudents(StudentDTO student) throws InsertDataException {
        try {
            String sql = "INSERT INTO \"students\" (\"student_id\", \"student_surname\", \"student_name\", \"student_patronymic\", \"student_status\", \"group_id\") VALUES(?, ?, ?, ?, ?, ?)";
            UUID newStudentUUID = UUID.randomUUID();
            PreparedStatementCreator preparedStatementCreator = conn -> {
                PreparedStatement preparedStatement = conn.prepareStatement(sql, new String[]{"student_id"});
                preparedStatement.setString(1, newStudentUUID.toString());
                preparedStatement.setString(2, student.getSurname());
                preparedStatement.setString(3, student.getName());
                preparedStatement.setString(4, student.getPatronymic());
                preparedStatement.setString(5, student.getStatus());
                preparedStatement.setString(6, student.getGroupId());
                return preparedStatement;
            };
            jdbcOperations.update(preparedStatementCreator);
            return Objects.requireNonNull(newStudentUUID);
        } catch (DataAccessException exception) {
            throw new InsertDataException(String.format("Can't insert student into database: %s\nWith Exception: %s", student.toString(), exception));
        }
    }

    @Override
    public void deleteStudentById(UUID uuid) {

    }
}
