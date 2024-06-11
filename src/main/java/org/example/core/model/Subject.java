package org.example.core.model;

import java.util.Objects;
import java.util.UUID;

public class Subject {
    private UUID uuid;
    private String name;

    public Subject(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject subject)) return false;
        return Objects.equals(getUuid(), subject.getUuid()) && Objects.equals(getName(), subject.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getName());
    }

    @Override
    public String toString() {
        return String.format("%s", getName());
    }
}
