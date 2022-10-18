package models.items;

import models.StatGroup;

import java.util.HashMap;

public class Part extends Item {

    private String type;

    public Part(String name, String type, boolean physicalForm, HashMap<String, StatGroup> stats, int value) {
        super(name, physicalForm, stats, value);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
