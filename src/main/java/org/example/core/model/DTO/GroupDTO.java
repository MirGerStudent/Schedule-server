package org.example.core.model.DTO;

import java.util.Objects;

public class GroupDTO {
    String GroupName;

    public GroupDTO(String groupName) {
        GroupName = groupName;
    }

    public String getGroupName() {
        return GroupName;
    }

    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupDTO groupDTO)) return false;
        return Objects.equals(getGroupName(), groupDTO.getGroupName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getGroupName());
    }

    @Override
    public String toString() {
        return getGroupName();
    }
}
