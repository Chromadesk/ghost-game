package models.items;

import models.Form;

public class Part extends Item {

    String type;

    public Part (String type, String name, Form form, double damage, double piercing, double speed, double power, double value) {
        super(name, form, damage, piercing, speed, power, value);
        this.type = type;
    }
}
