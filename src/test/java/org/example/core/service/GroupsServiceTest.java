package org.example.core.service;

import org.example.core.exceptions.RepositoryException;
import org.example.core.model.DTO.GroupDTO;
import org.example.core.model.Group;
import org.example.core.repository.GroupsRepository;
import org.example.core.repository.interfaces.IGroupsRepository;
import org.example.core.service.interfaces.IGroupsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GroupsServiceTest {
    IGroupsRepository repository;
    IGroupsService service;

    @BeforeEach
    void setUp() {
        repository = mock(GroupsRepository.class);
        service = new GroupsService(repository);
    }

    @Test
    void getAllGroupsTest() {
        ArrayList<Group> groups = new ArrayList<>();
        when(repository.getAllGroups()).thenReturn(groups);
        List<Group> answer = service.getAllGroups();
        verify(repository, times(1)).getAllGroups();
        assertEquals(answer, groups);
    }

    @Test
    void getGroupByIdTest() throws RepositoryException {
        UUID uuid = UUID.randomUUID();
        Group group = new Group(uuid, "MMM999-O-99");
        when(service.getGroupById(uuid.toString())).thenReturn(group);
        Group answer = service.getGroupById(uuid.toString());
        assertEquals(answer, group);
    }

    @Test
    void addGroupTest() throws RepositoryException {
        UUID uuid = UUID.randomUUID();
        GroupDTO group = new GroupDTO("MMM999-O-99");
        when(repository.addGroup(group)).thenReturn(uuid);
        UUID answer = service.addGroup(group);
        verify(repository, times(1)).addGroup(group);
        assertEquals(answer, uuid);
    }
}