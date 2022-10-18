package models.items.bulletparts;

import models.StatGroup;
import models.items.Part;

import java.util.HashMap;

public class Projectile extends Part {

    public Projectile(String name, String type, boolean physicalForm, HashMap<String, StatGroup> stats, int value) {
        super(name, type, physicalForm, stats, value);
    }

}
