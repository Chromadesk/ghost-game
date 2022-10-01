package models.items.bulletparts;

import models.items.Part;

public class Casing extends Part {

    public Casing(String name, int damage, int piercing, int speed, int power, int value) {
        super(name, "Casing", true, damage, piercing, speed, power, value);
    }
}
