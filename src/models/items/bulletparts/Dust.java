package models.items.bulletparts;

import models.StatGroup;
import models.items.Part;

import java.util.HashMap;

public class Dust extends Part {

    public Dust(String name, String type, boolean physicalForm, HashMap<String, StatGroup> stats, int value) {
        super(name, type, physicalForm, stats, value);
    }

}
