package models.items;


import models.IdentifiableObject;
import models.StatGroup;

import java.util.HashMap;

public class Item extends IdentifiableObject {

    HashMap<String, StatGroup> stats;

    boolean physicalForm;

    private int value;

    public Item(String name, boolean physicalForm, HashMap<String, StatGroup> stats, int value) {
        super(name);
        this.physicalForm = physicalForm;
        this.stats = stats;
        this.value = value;
    }

    public HashMap<String, StatGroup> getStats() {
        return stats;
    }

    public void setStats(HashMap<String, StatGroup> stats) {
        this.stats = stats;
    }

    public boolean isPhysicalForm() {
        return physicalForm;
    }

    public void setPhysicalForm(boolean physicalForm) {
        this.physicalForm = physicalForm;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
