package models.items.bulletparts;

import models.items.Part;

public class Dust extends Part {

    public Dust(String name, String type, int damage, int piercing, int speed, int power, int value) {
        super(name, type, true, damage, piercing, speed, power, value);
    }
}
