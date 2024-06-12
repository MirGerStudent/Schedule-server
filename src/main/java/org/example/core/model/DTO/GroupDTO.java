package org.example.core.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class GroupDTO {
    @NotBlank(message = "The \"groupName\" field cannot be empty!")
    @Size(min = 11, max = 11, message = "Incorrect groupName!")
    private String groupName;

    public GroupDTO() {
    }

    public GroupDTO(String groupName) {
        this.groupName = groupName;
    }

    public @NotBlank(message = "The \"groupName\" field cannot be empty!") @Size(min = 11, max = 11, message = "Incorrect groupName!") String getGroupName() {
        return groupName;
    }

    public void setGroupName(@NotBlank(message = "The \"groupName\" field cannot be empty!") @Size(min = 11, max = 11, message = "Incorrect groupName!") String groupName) {
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
