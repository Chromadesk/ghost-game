package models.entities;

import models.elements.Element;
import models.IdentifiableObject;

import java.util.ArrayList;

public abstract class Entity extends IdentifiableObject {
    boolean defaultPhysicalForm;
    int defaultHealth;
    int defaultResistance;
    ArrayList<Element> defaultElements;
    boolean physicalForm = defaultPhysicalForm;
    int health = defaultHealth;
    int resistance = defaultResistance;
    ArrayList<Element> elements = defaultElements;

    public Entity(String name, boolean physicalForm, int health, int resistance, ArrayList<Element> elements) {
        super(name);
        this.defaultPhysicalForm = physicalForm;
        this.defaultHealth = health;
        this.defaultResistance = resistance;
        this.defaultElements = elements;
    }

    public boolean isDefaultPhysicalForm() {
        return defaultPhysicalForm;
    }

    public void setDefaultPhysicalForm(boolean defaultPhysicalForm) {
        this.defaultPhysicalForm = defaultPhysicalForm;
    }

    public int getDefaultHealth() {
        return defaultHealth;
    }

    public void setDefaultHealth(int defaultHealth) {
        this.defaultHealth = defaultHealth;
    }

    public int getDefaultResistance() {
        return defaultResistance;
    }

    public void setDefaultResistance(int defaultResistance) {
        this.defaultResistance = defaultResistance;
    }

    public ArrayList<Element> getDefaultElements() {
        return defaultElements;
    }

    public void setDefaultElements(ArrayList<Element> defaultElements) {
        this.defaultElements = defaultElements;
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
