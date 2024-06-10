package org.example.core.service.interfaces;

import org.example.core.exceptions.InsertDataException;
import org.example.core.model.DTO.GroupDTO;
import org.example.core.model.Group;

import java.util.List;
import java.util.UUID;

public interface IGroupsService {
    List<Group> getAllGroups();
    Group getGroupById(long id);
    UUID addGroup(GroupDTO group) throws InsertDataException;
    void editGroup(Group group);
    void deleteGroupById(long id);
}
