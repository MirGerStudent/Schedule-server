package org.example.core.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.UUID;

public class Teacher {
    @NotNull(message = "The \"UUID\" field cannot be empty")
    @Size(min = 128, max = 128, message = "UUID is 128 characters long!")
    private UUID uuid;

    @NotNull(message = "The \"name\" field cannot be empty!")
    @Size(min = 2, max = 15, message = "Incorrect name!")
    private String name;

    @NotNull(message = "The \"surname\" field cannot be empty!")
    @Size(min = 2, max = 25, message = "Incorrect surname!")
    private String surname;

    @Max(value = 20, message = "Incorrect patronymic!")
    private String patronymic;

    @NotNull(message = "The \"post\" field cannot be empty!")
    private String post;

    public Teacher(UUID uuid, String name, String surname, String patronymic, String post) {
        this.uuid = uuid;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.post = post;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Teacher teacher)) return false;
        return Objects.equals(getUuid(), teacher.getUuid()) && Objects.equals(getName(), teacher.getName()) && Objects.equals(getSurname(), teacher.getSurname()) && Objects.equals(getPatronymic(), teacher.getPatronymic()) && Objects.equals(getPost(), teacher.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getName(), getSurname(), getPatronymic(), getPost());
    }

    @Override
    public String toString() {
        return String.format("Teacher: %s %s %s, %s", getName(), getSurname(), getPatronymic(), getPost());
    }
}
