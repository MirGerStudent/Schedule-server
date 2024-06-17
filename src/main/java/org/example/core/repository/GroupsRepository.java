package org.example.core.repository;

import org.example.core.exceptions.RepositoryException;
import org.example.core.model.DTO.GroupDTO;
import org.example.core.model.Group;
import org.example.core.repository.interfaces.IGroupsRepository;
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
public class GroupsRepository implements IGroupsRepository {
    private final JdbcOperations jdbcOperations;
    private final RowMapper<Group> groupRowMapper;

    public GroupsRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
        this.groupRowMapper = (rs, rowNum) -> {
            UUID groupId = UUID.fromString(rs.getString("group_id"));
            String groupName = rs.getString("group_name");
            return new Group(groupId, groupName);
        };
    }


    @Override
    public UUID addGroup(GroupDTO group) throws RepositoryException {
        try {
            String sql = "INSERT INTO \"groups\" (\"group_id\", \"group_name\") VALUES (?, ?)";
            UUID newGroupId = UUID.randomUUID();
            PreparedStatementCreator preparedStatementCreator = conn -> {
                PreparedStatement preparedStatement = conn.prepareStatement(sql, new String[]{"group_id"});
                preparedStatement.setString(1, newGroupId.toString());
                preparedStatement.setString(2, group.getGroupName());
                return preparedStatement;
            };
            jdbcOperations.update(preparedStatementCreator);
            return Objects.requireNonNull(newGroupId);
        } catch (DataAccessException exception) {
            throw new RepositoryException(String.format("Can't insert group into database: %s\nWith Exception: %s", group.toString(), exception));
        }

    }

    @Override
    public void editGroup(Group group) throws RepositoryException {
        try {
            String sql = "UPDATE \"groups\" SET \"group_name\" = ? WHERE \"group_id\" = ?";
            int check = jdbcOperations.update(sql, group.getName(), group.getId());
            if (check == 0) {
                throw new RepositoryException("Can't edit group: " + group);
            }
        } catch (DataAccessException e) {
            throw new RepositoryException("Can't edit group: " + group);
        }
    }

    @Override
    public void deleteGroupById(UUID uuid) throws RepositoryException {
        String sql = "DELETE FROM \"groups\" WHERE \"group_id\" = ?";
        int check = jdbcOperations.update(sql, uuid.toString());
        if (check == 0) {
            throw new RepositoryException("Can't delete group with id: " + uuid);
        }
    }

    @Override
    public void addGroupByIdToLesson(UUID lessonId) {

    }

    @Override
    public List<Group> getAllGroups() {
        String sql = "SELECT * FROM \"groups\"";
        return jdbcOperations.query(sql, groupRowMapper);
    }

    @Override
    public Group getGroupById(UUID uuid) throws RepositoryException {
        try {
            String sql = "SELECT * FROM \"groups\" WHERE \"group_id\" = ?";
            return jdbcOperations.queryForObject(sql, groupRowMapper, uuid.toString());
        } catch (DataAccessException e) {
            throw new RepositoryException("Group with id: " + uuid.toString() + " not found!");
        }
    }
}
