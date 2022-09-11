package models.items.bulletparts;

import models.Form;
import models.items.Part;

public class Projectile extends Part {

    public Projectile (String type, String name, double damage, double piercing, double speed, double power, double value) {
        super(type, name, new Form("Physical"), damage, piercing, speed, power, value);
    }
}
