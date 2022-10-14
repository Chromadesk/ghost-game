package models;

import java.util.Objects;

public abstract class IdentifiableObject {

    private String name;

    private int id;
    private static int nextId = 0;

    public IdentifiableObject(String name) {
        this.name = name;
        this.id = nextId++;
    }

    public int getId() {
        return id;
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
        if (o == null || getClass() != o.getClass()) return false;
        IdentifiableObject that = (IdentifiableObject) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String identify() {
        return "[" + id + "] " + name;
    }
}
