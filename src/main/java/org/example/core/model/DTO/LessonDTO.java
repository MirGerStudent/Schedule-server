package org.example.core.model.DTO;

import java.util.Objects;
import java.util.UUID;

public class LessonDTO {
    String data;
    Long sequenceNumber;
    UUID subjectId;
    UUID teacherId;

    public LessonDTO() {}

    public LessonDTO(String data, Long sequenceNumber, UUID subjectId, UUID teacherId) {
        this.data = data;
        this.sequenceNumber = sequenceNumber;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public UUID getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(UUID subjectId) {
        this.subjectId = subjectId;
    }

    public UUID getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(UUID teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LessonDTO lessonDTO)) return false;
        return Objects.equals(getData(), lessonDTO.getData()) && Objects.equals(getSequenceNumber(), lessonDTO.getSequenceNumber()) && Objects.equals(getSubjectId(), lessonDTO.getSubjectId()) && Objects.equals(getTeacherId(), lessonDTO.getTeacherId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getData(), getSequenceNumber(), getSubjectId(), getTeacherId());
    }

    @Override
    public String toString() {
        return String.format("%s on %s %s %s", getSubjectId(), getData(), getSequenceNumber(), getTeacherId());
    }
}
