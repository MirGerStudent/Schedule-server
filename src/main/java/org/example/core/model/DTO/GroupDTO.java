package org.example.core.model.DTO;

import java.util.Objects;

public class GroupDTO {
    String groupName;

    public GroupDTO() {
    }

    public GroupDTO(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
