package org.example.core.model.DTO;

import java.util.Objects;

public class StudentDTO {
    String name;
    String surname;
    String patronymic;
    String status;
    String groupId;

    public StudentDTO() {
    }

    public StudentDTO(String name, String surname, String patronymic, String status, String groupId) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.status = status;
        this.groupId = groupId;
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupName(String groupName) {
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
