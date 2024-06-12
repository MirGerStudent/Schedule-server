package org.example.core.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class SubjectDTO {
    @NotBlank(message = "The \"subject\" field cannot be empty!")
    @Size(min = 7, max = 36, message = "Incorrect name for subject!")
    private String name;

    public SubjectDTO() {
    }

    public SubjectDTO(String name) {
        this.name = name;
    }

    public @NotBlank(message = "The \"subject\" field cannot be empty!") @Size(min = 7, max = 36, message = "Incorrect name for subject!") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "The \"subject\" field cannot be empty!") @Size(min = 7, max = 36, message = "Incorrect name for subject!") String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectDTO that)) return false;
        return Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }

    @Override
    public String toString() {
        return String.format("%s", getName());
    }
}
