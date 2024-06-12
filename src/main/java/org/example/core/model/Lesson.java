package org.example.core.model;

import java.util.Objects;
import java.util.UUID;

public class Lesson {
    UUID uuid;
    String data;
    Long sequenceNumber;
    UUID subjectId;
    UUID teacherId;

    public Lesson() {}

    public Lesson(UUID uuid, String data, Long sequenceNumber, UUID subjectId, UUID teacherId) {
        this.uuid = uuid;
        this.data = data;
        this.sequenceNumber = sequenceNumber;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
        if (!(o instanceof Lesson lesson)) return false;
        return Objects.equals(getUuid(), lesson.getUuid()) && Objects.equals(getData(), lesson.getData()) && Objects.equals(getSequenceNumber(), lesson.getSequenceNumber()) && Objects.equals(getSubjectId(), lesson.getSubjectId()) && Objects.equals(getTeacherId(), lesson.getTeacherId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getData(), getSequenceNumber(), getSubjectId(), getTeacherId());
    }

    @Override
    public String toString() {
        return String.format("%s on %s %s %s", getSubjectId(), getData(), getSequenceNumber(), getTeacherId());
    }
}
