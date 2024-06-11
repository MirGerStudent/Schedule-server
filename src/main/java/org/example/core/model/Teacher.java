package org.example.core.model;

import java.util.Objects;
import java.util.UUID;

public class Teacher {
    private UUID uuid;
    private String name;
    private String surname;
    private String patronymic;
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
