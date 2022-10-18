package models.items.bulletparts;

import models.StatGroup;
import models.items.Part;

import java.util.HashMap;

public class Casing extends Part {

    public Casing(String name, boolean physicalForm, HashMap<String, StatGroup> stats, int value) {
        super(name, "Casing", physicalForm, stats, value);
    }

}
