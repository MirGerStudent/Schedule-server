package org.example.core.service.interfaces;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.core.exceptions.RepositoryException;
import org.example.core.model.DTO.GroupDTO;
import org.example.core.model.Group;

import java.util.List;
import java.util.UUID;

public interface IGroupsService {
    List<Group> getAllGroups();
    Group getGroupById(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid
    ) throws RepositoryException;
    UUID addGroup(@Valid GroupDTO group) throws RepositoryException;
    void editGroup(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String groupId,
            @Valid GroupDTO group)
            throws RepositoryException;
    void deleteGroupById(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid
    ) throws RepositoryException;
    void addGroupByIdToLesson(
            @Valid
            @NotBlank(message = "The \"UUID\" field cannot be empty")
            @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
            @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
            String uuid
    );
}
