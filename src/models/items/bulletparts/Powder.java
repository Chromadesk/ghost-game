package models.items.bulletparts;

import models.items.Part;

public class Powder extends Part {

    public Powder(String name, int damage, int piercing, int speed, int power, int value) {
        super(name, "Powder", true, damage, piercing, speed, power, value);
    }
}
