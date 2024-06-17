package org.example.core.model;

import jakarta.validation.constraints.*;

import java.util.Objects;
import java.util.UUID;

public class Student {
    @NotBlank(message = "The \"UUID\" field cannot be empty")
    @Size(min = 128, max = 128, message = "UUID is 128 characters long!")
    private UUID id;

    @NotBlank(message = "The \"name\" field cannot be empty!")
    @Size(min = 2, max = 15, message = "Incorrect name!")
    private String name;

    @NotBlank(message = "The \"surname\" field cannot be empty!")
    @Size(min = 2, max = 25, message = "Incorrect surname!")
    private String surname;

    @Size(max = 20, message = "Incorrect patronymic!")
    private String patronymic;

    @NotBlank(message = "The \"status\" field cannot be empty!")
    @Pattern(regexp = "ACTIVE|SABBATICAL|EXPELLED|COMPLETED")
    private String status;

    @NotBlank(message = "The \"UUID\" field cannot be empty")
    @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
    private UUID groupId;

    public Student(UUID id, String name, String surname, String patronymic, String status, UUID group) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.status = status;
        this.groupId = group;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getGroup() {
        return groupId;
    }

    public void setGroup(UUID group) {
        this.groupId = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(getId(), student.getId()) && Objects.equals(getName(), student.getName()) && Objects.equals(getSurname(), student.getSurname()) && Objects.equals(getPatronymic(), student.getPatronymic()) && Objects.equals(getStatus(), student.getStatus()) && Objects.equals(getGroup(), student.getGroup());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getPatronymic(), getStatus(), getGroup());
    }

    @Override
    public String toString() {
        return String.format("Student %s %s %s, %s, %s", getSurname(), getName(), getPatronymic(), getGroup().toString(), getStatus());
    }
}

