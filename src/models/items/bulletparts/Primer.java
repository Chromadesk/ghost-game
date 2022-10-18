package models.items.bulletparts;

import models.StatGroup;
import models.items.Part;

import java.util.HashMap;

public class Primer extends Part {

    public Primer(String name, boolean physicalForm, HashMap<String, StatGroup> stats, int value) {
        super(name, "Primer", physicalForm, stats, value);
    }

}
