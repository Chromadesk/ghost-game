package models.items.bulletparts;

import models.items.Part;

public class Primer extends Part {

    public Primer(String name, int damage, int piercing, int speed, int power, int value) {
        super("Primer", name, true, damage, piercing, speed, power, value);
    }
}
