package models.items.bulletparts;

import models.items.Part;

public class Shape extends Part {

    public Shape (String name, int damage, int piercing, int speed, int power, int value) {
        super("Shape", name, true, damage, piercing, speed, power, value);
    }
}
