package models.items.bulletparts;

import models.items.Part;

public class Dust extends Part {

    public Dust(String type, String name, int damage, int piercing, int speed, int power, int value) {
        super(type, name, true, damage, piercing, speed, power, value);
    }
}
