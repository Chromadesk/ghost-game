package models.items;


public class Item {

    private final int id;
    private static int nextId = 0;

    private String name;

    private boolean physicalForm;

    private int damage;

    private int piercing;

    private int speed;

    private int power;

    private int value;

    public Item(String name, boolean physicalForm, int damage, int piercing, int speed, int power, int value) {
        this.name = name;
        this.physicalForm = physicalForm;
        this.damage = damage;
        this.piercing = piercing;
        this.speed = speed;
        this.power = power;
        this.value = value;
        this.id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPhysicalForm() {
        return physicalForm;
    }

    public void setPhysicalForm(boolean physicalForm) {
        this.physicalForm = physicalForm;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPiercing() {
        return piercing;
    }

    public void setPiercing(int piercing) {
        this.piercing = piercing;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
