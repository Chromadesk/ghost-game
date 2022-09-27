package models.items.bulletparts;

import models.items.Part;

public class Casing extends Part {

    public Casing(String name, int damage, int piercing, int speed, int power, int value) {
        super("Casing", name, true, damage, piercing, speed, power, value);
    }
}
