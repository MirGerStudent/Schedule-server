package org.example.core.model;

import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

//@Component
public class Student {
    UUID id;
    String name;
    String surname;
    String patronymic;
    String status;
    UUID groupId;

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

