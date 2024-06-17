package org.example.core.controllers;

import jakarta.websocket.server.PathParam;
import org.example.core.exceptions.RepositoryException;
import org.example.core.model.DTO.GroupDTO;
import org.example.core.model.Group;
import org.example.core.model.Responce.CommonResponse;
import org.example.core.service.interfaces.IGroupsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/group")
public class GroupsController {
    private final IGroupsService groupsService;

    public GroupsController(IGroupsService groupsService) {
        this.groupsService = groupsService;
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<Group>>> getAllGroups() {
//        try {
        return ResponseEntity.ok(new CommonResponse<>(groupsService.getAllGroups()));
//        } catch (Exception exception) {
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(new CommonResponse<>(exception.toString()));
//        }
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<CommonResponse<Group>> getGroupById(@PathVariable("groupId") String uuid) {
        try {
            return ResponseEntity.ok(new CommonResponse<>(groupsService.getGroupById(uuid)));
        } catch (RepositoryException exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new CommonResponse<>(exception.toString()));
        }
    }

    @PostMapping
    public ResponseEntity<CommonResponse<UUID>> addGroup(@RequestBody GroupDTO group) {
        try {
            return ResponseEntity.ok(new CommonResponse<>(groupsService.addGroup(group)));
        } catch (RepositoryException exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new CommonResponse<>(exception.toString()));
        }
    }

    @DeleteMapping
    public ResponseEntity<CommonResponse<Boolean>> deleteGroupById(@RequestParam("groupId") String uuid) {
        try {
            groupsService.deleteGroupById(uuid);
            return ResponseEntity.ok(new CommonResponse<>(true));
        } catch (RepositoryException exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new CommonResponse<>(exception.toString()));
        }
    }

    @PutMapping("/{groupId}")
    public ResponseEntity<CommonResponse<Boolean>> editGroup(@PathVariable("groupId") String uuid, @RequestBody GroupDTO group) {
        try {
            groupsService.editGroup(uuid, group);
            return ResponseEntity.ok(new CommonResponse<>(true));
        } catch (RepositoryException exception) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new CommonResponse<>(exception.toString()));
        }
    }
}
