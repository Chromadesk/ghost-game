package models.items.bulletparts;

import models.StatGroup;
import models.items.Part;

import java.util.HashMap;

public class Shape extends Part {
    public Shape(String name, boolean physicalForm, HashMap<String, StatGroup> stats, int value, String type) {
        super(name, physicalForm, stats, value, type);
    }
}
