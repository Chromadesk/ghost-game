package models.items.bulletparts;

import models.Form;
import models.items.Part;

public class Primer extends Part {

    public Primer(String name, double damage, double piercing, double speed, double power, double value) {
        super("Primer", name, new Form("Physical"), damage, piercing, speed, power, value);
    }
}
