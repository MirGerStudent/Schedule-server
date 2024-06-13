package org.example.core.service;

import org.example.core.exceptions.InsertDataException;
import org.example.core.model.DTO.GroupDTO;
import org.example.core.model.Group;
import org.example.core.repository.interfaces.IGroupsRepository;
import org.example.core.service.interfaces.IGroupsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GroupsService implements IGroupsService {
    private final IGroupsRepository repository;

    public GroupsService(IGroupsRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Group> getAllGroups() {
        return repository.getAllGroups();
    }

    @Override
    public Group getGroupById(long id) {
        return null;
    }

    @Override
    public UUID addGroup(GroupDTO group) throws InsertDataException {
        return repository.addGroup(group);
    }

    @Override
    public void editGroup(Group group) {

    }

    @Override
    public void addGroupByIdToLesson(UUID uuid) {

    }

    @Override
    public void deleteGroupById(long id) {

    }
}
