package models.entities;

import models.Element;
import models.IdentifiableObject;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Entity extends IdentifiableObject {
    //TODO Make "MAX" stats so that a character can be healed to their maximum health value.

    boolean physicalForm;

    int health;

    int resistance;

    ArrayList<Element> elements;

    public Entity(String name, boolean physicalForm, int health, int resistance, ArrayList<Element> elements) {
        super(name);
        this.physicalForm = physicalForm;
        this.health = health;
        this.resistance = resistance;
        this.elements = elements;
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
}
