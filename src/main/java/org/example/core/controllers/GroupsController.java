package org.example.core.controllers;

import jakarta.validation.Valid;
import org.example.core.exceptions.InsertDataException;
import org.example.core.model.DTO.GroupDTO;
import org.example.core.model.Group;
import org.example.core.service.interfaces.IGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/groups")
public class GroupsController {
    private final IGroupsService groupsService;

    @Autowired
    public GroupsController(IGroupsService groupsService) {
        this.groupsService = groupsService;
    }
    @GetMapping
    public List<Group> getAllGroups() {
        return groupsService.getAllGroups();
    }

    @PostMapping
    public UUID addStudent(@Valid @RequestBody GroupDTO group) throws InsertDataException {
        return groupsService.addGroup(group);
    }
}
