package org.example.core.repository;

import org.example.core.exceptions.RepositoryException;
import org.example.core.model.Group;
import org.example.core.repository.interfaces.IGroupsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class GroupsRepositoryTest {
    private JdbcOperations jdbcOperations;
    private IGroupsRepository repository;

    @BeforeEach
    void setUp() {
        jdbcOperations = mock(JdbcOperations.class);
        repository = new GroupsRepository(jdbcOperations);
    }

    @Test
    void getAllGroupsTest() {
        List<Group> groups = new ArrayList<>();
        when(jdbcOperations.query(anyString(), any(RowMapper.class))).thenReturn(groups);
        List<Group> answer = repository.getAllGroups();
        assertEquals(groups, answer);
    }

    @Test
    void getGroupByIdTest() throws RepositoryException {
        Group group = new Group(UUID.randomUUID(), "ММБ109-О-90");
        when(jdbcOperations.queryForObject(anyString(), any(RowMapper.class), any())).thenReturn(group);
        Group answer = repository.getGroupById(group.getId());
        assertEquals(group, answer);
    }
}