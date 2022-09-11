package models.entities;

import models.Element;
import models.Form;

import java.util.ArrayList;

public abstract class Entity {

    String name;

    Form form;

    int health;

    int resistance;

    ArrayList<Element> elements;

    public Entity(String name, Form form, int health, int resistance, ArrayList<Element> elements) {
        this.name = name;
        this.form = form;
        this.health = health;
        this.resistance = resistance;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        return name.equals(entity.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
