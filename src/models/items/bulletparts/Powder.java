package models.items.bulletparts;

import models.StatGroup;
import models.items.Part;

import java.util.HashMap;

public class Powder extends Part {

    public Powder(String name, boolean physicalForm, HashMap<String, StatGroup> stats, int value) {
        super(name, "Powder", physicalForm, stats, value);
    }

}
