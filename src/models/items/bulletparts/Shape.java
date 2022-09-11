package models.items.bulletparts;

import models.Form;
import models.items.Part;

public class Shape extends Part {

    public Shape (String name, double damage, double piercing, double speed, double power, double value) {
        super("Shape", name, new Form("Physical"), damage, piercing, speed, power, value);
    }
}
