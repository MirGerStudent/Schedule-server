package org.example.core.controllers;

import org.example.core.exceptions.RepositoryException;
import org.example.core.model.DTO.GroupDTO;
import org.example.core.model.Group;
import org.example.core.model.Responce.CommonResponse;
import org.example.core.service.GroupsService;
import org.example.core.service.interfaces.IGroupsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GroupsControllerTest {
    IGroupsService service;
    GroupsController controller;

    @BeforeEach
    void setUp() {
        service = mock(GroupsService.class);
        controller = new GroupsController(service);
    }

    @Test
    void getAllGroupsTest() {
        ResponseEntity<CommonResponse<List<Group>>> response = ResponseEntity.ok(new CommonResponse<>(new ArrayList<>()));
        when(service.getAllGroups()).thenReturn(new ArrayList<>());
        ResponseEntity<CommonResponse<List<Group>>> answer = controller.getAllGroups();
        verify(service, times(1)).getAllGroups();
        assertEquals(HttpStatus.OK, answer.getStatusCode());
        assertEquals(response, answer);
    }

    @Test
    void getGroupByIdTest() throws RepositoryException {
        Group group = new Group(UUID.randomUUID(), "MMM999-O-99");
        ResponseEntity<CommonResponse<Group>> response = ResponseEntity.ok(new CommonResponse<>(group));
        when(service.getGroupById(group.getId().toString())).thenReturn(group);
        ResponseEntity<CommonResponse<Group>> answer = controller.getGroupById(group.getId().toString());
        verify(service, times(1)).getGroupById(group.getId().toString());
        assertEquals(HttpStatus.OK, answer.getStatusCode());
        assertEquals(response, answer);
    }

    @Test
    void addGroupTest() throws RepositoryException {
        UUID uuid = UUID.randomUUID();
        GroupDTO group = new GroupDTO("MMM999-O-99");
        ResponseEntity<CommonResponse<UUID>> response = ResponseEntity.ok(new CommonResponse<>(uuid));
        when(service.addGroup(group)).thenReturn(uuid);
        ResponseEntity<CommonResponse<UUID>> answer = controller.addGroup(group);
        verify(service, times(1)).addGroup(group);
        assertEquals(response, answer);
    }
}