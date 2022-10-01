package models.items;

public class Part extends Item {

    String type;

    public Part (String name, String type, boolean physicalForm, int damage, int piercing, int speed, int power, int value) {
        super(name, physicalForm, damage, piercing, speed, power, value);
        this.type = type;
    }
}
