package org.example.core.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class StudentDTO {
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
    private String groupId;

    public StudentDTO() {
    }

    public StudentDTO(String name, String surname, String patronymic, String status, String groupId) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.status = status;
        this.groupId = groupId;
    }

    public @NotBlank(message = "The \"name\" field cannot be empty!") @Size(min = 2, max = 15, message = "Incorrect name!") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "The \"name\" field cannot be empty!") @Size(min = 2, max = 15, message = "Incorrect name!") String name) {
        this.name = name;
    }

    public @NotBlank(message = "The \"surname\" field cannot be empty!") @Size(min = 2, max = 25, message = "Incorrect surname!") String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank(message = "The \"surname\" field cannot be empty!") @Size(min = 2, max = 25, message = "Incorrect surname!") String surname) {
        this.surname = surname;
    }

    public @Size(max = 20, message = "Incorrect patronymic!") String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(@Size(max = 20, message = "Incorrect patronymic!") String patronymic) {
        this.patronymic = patronymic;
    }

    public @NotBlank(message = "The \"status\" field cannot be empty!") @Pattern(regexp = "ACTIVE|SABBATICAL|EXPELLED|COMPLETED") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "The \"status\" field cannot be empty!") @Pattern(regexp = "ACTIVE|SABBATICAL|EXPELLED|COMPLETED") String status) {
        this.status = status;
    }

    public @NotBlank(message = "The \"UUID\" field cannot be empty") @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}") @Size(min = 36, max = 36, message = "UUID is 36 characters long!") String getGroupId() {
        return groupId;
    }

    public void setGroupId(@NotBlank(message = "The \"UUID\" field cannot be empty") @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}") @Size(min = 36, max = 36, message = "UUID is 36 characters long!") String groupId) {
        this.groupId = groupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDTO that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getPatronymic(), that.getPatronymic()) && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getGroupId(), that.getGroupId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getPatronymic(), getStatus(), getGroupId());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, %s, %s", getSurname(), getName(), getPatronymic(), getGroupId(), getStatus());
    }
}
