package org.example.core.model.DTO;

import java.util.Objects;

public class StudentDTO {
    String name;
    String surname;
    String patronymic;
    String status;
    String groupName;

    public StudentDTO(String name, String surname, String patronymic, String status, String groupName) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.status = status;
        this.groupName = groupName;
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

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentDTO that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getPatronymic(), that.getPatronymic()) && Objects.equals(getStatus(), that.getStatus()) && Objects.equals(getGroupName(), that.getGroupName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getPatronymic(), getStatus(), getGroupName());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, %s, %s", getSurname(), getName(), getPatronymic(), getGroupName(), getStatus());
    }
}
