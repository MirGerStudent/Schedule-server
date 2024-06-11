package org.example.core.repository;

import org.example.core.model.DTO.SubjectDTO;
import org.example.core.model.Subject;
import org.example.core.repository.interfaces.ISubjectsRepository;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;
import java.util.UUID;

public class SubjectsRepository implements ISubjectsRepository {
    private final JdbcOperations jdbcOperations;
    private final RowMapper<Subject> subjectRowMapper;

    public SubjectsRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.subjectRowMapper = (rs, rowNum) -> {
            UUID subjectId = UUID.fromString(rs.getString("subject_id"));
            String subjectName = rs.getString("subject_name");
            return new Subject(subjectId, subjectName);
        };
    }

    @Override
    public List<Subject> getSubjectByGroupId(UUID groupId) {
        return List.of();
    }

    @Override
    public Subject getSubjectById(UUID subjectId) {
        return null;
    }

    @Override
    public UUID addSubject(SubjectDTO subject) {
        return null;
    }

    @Override
    public Subject editSubject(SubjectDTO subject) {
        return null;
    }

    @Override
    public void deleteSubjectById(UUID subjectId) {

    }
}
