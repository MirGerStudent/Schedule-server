package org.example.core.repository.interfaces;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.core.exceptions.RepositoryException;
import org.example.core.model.DTO.GroupDTO;
import org.example.core.model.Group;

import java.util.List;
import java.util.UUID;

public interface IGroupsRepository {
    List<Group> getAllGroups();
    Group getGroupById(UUID uuid) throws RepositoryException;
    UUID addGroup(GroupDTO group) throws RepositoryException;
    void editGroup(Group group) throws RepositoryException;
    void deleteGroupById(UUID uuid) throws RepositoryException;
    void addGroupByIdToLesson(UUID uuid);
}
