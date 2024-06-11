package org.example.core.model.DTO;

import java.util.Objects;

public class TeacherDTO {
    private String name;
    private String surname;
    private String patronymic;
    private String post;

    public TeacherDTO() {
    }

    public TeacherDTO(String name, String surname, String patronymic, String post) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.post = post;
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
        if (!(o instanceof TeacherDTO that)) return false;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getSurname(), that.getSurname()) && Objects.equals(getPatronymic(), that.getPatronymic()) && Objects.equals(getPost(), that.getPost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname(), getPatronymic(), getPost());
    }

    @Override
    public String toString() {
        return String.format("Teacher: %s %s %s, %s", getName(), getSurname(), getPatronymic(), getPost());
    }
}
