package org.example.core.model.DTO;

import jakarta.validation.constraints.*;

import java.util.Objects;
import java.util.UUID;

public class LessonDTO {
    @NotBlank(message = "The \"surname\" field cannot be empty!")
    @Size(min = 10, max = 10, message = "Incorrect data! Format is 'DD.MM.YYYY'")
    String data;

    @Min(value = 1, message = "The sequence number cannot be less than 1!")
    @Max(value = 8, message = "The sequence number cannot be more than 8!")
    Long sequenceNumber;

    @NotBlank(message = "The \"subjectId\" field cannot be empty")
    @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
    String subjectId;

    @NotBlank(message = "The \"teacherId\" field cannot be empty")
    @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
    String teacherId;

    @NotBlank(message = "The \"groupId\" field cannot be empty")
    @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}")
    @Size(min = 36, max = 36, message = "UUID is 36 characters long!")
    String groupId;

    public LessonDTO() {}

    public LessonDTO(String data, Long sequenceNumber, String subjectId, String teacherId, String groupId) {
        this.data = data;
        this.sequenceNumber = sequenceNumber;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.groupId = groupId;
    }

    public @NotBlank(message = "The \"surname\" field cannot be empty!") @Size(min = 10, max = 10, message = "Incorrect data! Format is 'DD.MM.YYYY'") String getData() {
        return data;
    }

    public void setData(@NotBlank(message = "The \"surname\" field cannot be empty!") @Size(min = 10, max = 10, message = "Incorrect data! Format is 'DD.MM.YYYY'") String data) {
        this.data = data;
    }

    public @Min(value = 1, message = "The sequence number cannot be less than 1!") @Max(value = 8, message = "The sequence number cannot be more than 8!") Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(@Min(value = 1, message = "The sequence number cannot be less than 1!") @Max(value = 8, message = "The sequence number cannot be more than 8!") Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public @NotBlank(message = "The \"UUID\" field cannot be empty") @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}") @Size(min = 36, max = 36, message = "UUID is 36 characters long!") String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(@NotBlank(message = "The \"UUID\" field cannot be empty") @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}") @Size(min = 36, max = 36, message = "UUID is 36 characters long!") String subjectId) {
        this.subjectId = subjectId;
    }

    public @NotBlank(message = "The \"UUID\" field cannot be empty") @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}") @Size(min = 36, max = 36, message = "UUID is 36 characters long!") String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(@NotBlank(message = "The \"UUID\" field cannot be empty") @Pattern(regexp = "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}") @Size(min = 36, max = 36, message = "UUID is 36 characters long!") String teacherId) {
        this.teacherId = teacherId;
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
        if (!(o instanceof LessonDTO lessonDTO)) return false;
        return Objects.equals(getData(), lessonDTO.getData()) && Objects.equals(getSequenceNumber(), lessonDTO.getSequenceNumber()) && Objects.equals(getSubjectId(), lessonDTO.getSubjectId()) && Objects.equals(getTeacherId(), lessonDTO.getTeacherId()) && Objects.equals(getGroupId(), lessonDTO.getGroupId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getSequenceNumber(), getSubjectId(), getTeacherId(), getGroupId());
    }

    @Override
    public String toString() {
        return String.format("%s on %s for %s, %s, %s", getSubjectId(), getData(), getGroupId(), getSequenceNumber(), getTeacherId());
    }
}
