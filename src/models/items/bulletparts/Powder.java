package models.items.bulletparts;

import models.Form;
import models.items.Part;

public class Powder extends Part {

    public Powder(String name, double damage, double piercing, double speed, double power, double value) {
        super("Powder", name, new Form("Physical"), damage, piercing, speed, power, value);
    }
}
