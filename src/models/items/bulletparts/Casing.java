package models.items.bulletparts;

import models.Form;
import models.items.Part;

public class Casing extends Part {

    public Casing(String name, double damage, double piercing, double speed, double power, double value) {
        super("Casing", name, new Form("Physical"), damage, piercing, speed, power, value);
    }
}
