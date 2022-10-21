package models.items;

import models.StatGroup;

import java.util.HashMap;

public class Part extends Item {

    //TODO Make it so parts can be non-physical because when it its activated it will become non-physical.
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
