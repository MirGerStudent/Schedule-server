package org.example.core.repository.interfaces;

import org.example.core.exceptions.InsertDataException;
import org.example.core.model.DTO.GroupDTO;
import org.example.core.model.Group;

import java.util.List;
import java.util.UUID;

public interface IGroupsRepository {
    List<Group> getAllGroups();
    Group getGroupById(UUID uuid);
    UUID addGroup(GroupDTO group) throws InsertDataException;
    void editGroup(GroupDTO group);
    void deleteGroupById(UUID uuid);
    void addGroupByIdToLesson(UUID uuid);
}
