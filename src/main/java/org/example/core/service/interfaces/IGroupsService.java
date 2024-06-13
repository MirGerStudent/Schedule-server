package org.example.core.service.interfaces;

import jakarta.validation.Valid;
import org.example.core.exceptions.InsertDataException;
import org.example.core.model.DTO.GroupDTO;
import org.example.core.model.Group;

import java.util.List;
import java.util.UUID;

public interface IGroupsService {
    List<Group> getAllGroups();
    Group getGroupById(UUID uuid);
    UUID addGroup(@Valid GroupDTO group) throws InsertDataException;
    void editGroup(@Valid GroupDTO group);
    void deleteGroupById(UUID uuid);
    void addGroupByIdToLesson(UUID uuid);
}
