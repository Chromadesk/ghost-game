package models.entities;

import models.Element;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Entity {

    private int id;
    private static int nextId = 0;
    String name;

    boolean physicalForm;

    int health;

    int resistance;

    ArrayList<Element> elements;

    public Entity(String name, boolean physicalForm, int health, int resistance, ArrayList<Element> elements) {
        this.name = name;
        this.physicalForm = physicalForm;
        this.health = health;
        this.resistance = resistance;
        this.elements = elements;
        this.id = nextId;
        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }

    public boolean isPhysicalForm() {
        return physicalForm;
    }

    public void setPhysicalForm(boolean physicalForm) {
        this.physicalForm = physicalForm;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id == entity.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
