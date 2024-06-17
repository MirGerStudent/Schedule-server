package org.example.core.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.UUID;

public class Group {
    private UUID id;

    @NotBlank(message = "The \"groupName\" field cannot be empty!")
    @Size(min = 11, max = 11, message = "Incorrect groupName!")
    private String name;

    public Group(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotBlank(message = "The \"groupName\" field cannot be empty!") @Size(min = 11, max = 11, message = "Incorrect groupName!") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "The \"groupName\" field cannot be empty!") @Size(min = 11, max = 11, message = "Incorrect groupName!") String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Group group)) return false;
        return Objects.equals(getId(), group.getId()) && Objects.equals(getName(), group.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

    @Override
    public String toString() {
        return String.format(getName());
    }
}
