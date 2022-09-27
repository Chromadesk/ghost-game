package models.items.bulletparts;

import models.items.Part;

public class Projectile extends Part {

    public Projectile (String type, String name, int damage, int piercing, int speed, int power, int value) {
        super(type, name, true, damage, piercing, speed, power, value);
    }
}
