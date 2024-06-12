package org.example.core.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class TeacherDTO {
    @NotBlank(message = "The \"name\" field cannot be empty!")
    @Size(min = 2, max = 15, message = "Incorrect name!")
    private String name;

    @NotBlank(message = "The \"surname\" field cannot be empty!")
    @Size(min = 2, max = 25, message = "Incorrect surname!")
    private String surname;

    @Size(max = 20, message = "Incorrect patronymic!")
    private String patronymic;

    @NotBlank(message = "The \"post\" field cannot be empty!")
    @Size(min = 5, max = 36, message = "Incorrect teacher post!")
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
