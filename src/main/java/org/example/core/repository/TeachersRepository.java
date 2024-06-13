package org.example.core.repository;

import org.example.core.model.DTO.TeacherDTO;
import org.example.core.model.Teacher;
import org.example.core.repository.interfaces.ITeachersRepository;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.UUID;

public class TeachersRepository implements ITeachersRepository {
    private final JdbcOperations jdbcOperations;
    private final RowMapper<Teacher> teacherRowMapper;

    public TeachersRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.teacherRowMapper = (rs, rowNum) -> {
            UUID teacherId = UUID.fromString(rs.getString("teacher_id"));
            String teacherName = rs.getString("teacher_name");
            String teacherSurname = rs.getString("teacher_surname");
            String teacherPatronymic = rs.getString("teacher_patronymic");
            String teacherPost = rs.getString("teacher_post");
            return new Teacher(teacherId, teacherName, teacherSurname, teacherPatronymic, teacherPost);
        };
    }

    @Override
    public List<Teacher> getAllTeachers() {
        String sql = "SELECT * FROM \"teachers\"";
        return jdbcOperations.query(sql, teacherRowMapper);
    }

    @Override
    public Teacher getTeacherById(UUID uuid) {
        return null;
    }

    @Override
    public UUID addTeacher(TeacherDTO teacher) {
        return null;
    }

    @Override
    public void editTeacherById(TeacherDTO teacher) {

    }

    @Override
    public void deleteTeacherById(UUID uuid) {

    }
}
