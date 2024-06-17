package org.example.core.service;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.core.exceptions.RepositoryException;
import org.example.core.model.DTO.GroupDTO;
import org.example.core.model.Group;
import org.example.core.repository.interfaces.IGroupsRepository;
import org.example.core.service.interfaces.IGroupsService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Validated
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
    public Group getGroupById(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid
    ) throws RepositoryException {
        return repository.getGroupById(UUID.fromString(uuid));
    }

    @Override
    public UUID addGroup(@Valid GroupDTO group) throws RepositoryException {
        return repository.addGroup(group);
    }

    @Override
    public void editGroup(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String groupId,
            @Valid GroupDTO group
    ) throws RepositoryException {
        repository.editGroup(
                new Group(
                        UUID.fromString(groupId),
                        group.getGroupName()
                )
        );
    }

    @Override
    public void addGroupByIdToLesson(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid
    ) {
        repository.addGroupByIdToLesson(UUID.fromString(uuid));
    }

    @Override
    public void deleteGroupById(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid
    ) throws RepositoryException {
        repository.deleteGroupById(UUID.fromString(uuid));
    }
}
