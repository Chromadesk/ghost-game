package models.items;

import models.Form;

public class Item {

    private String name;

    private Form form;

    private double damage;

    private double piercing;

    private double speed;

    private double power;

    private double value;

    public Item(String name, Form form, double damage, double piercing, double speed, double power, double value) {
        this.name = name;
        this.form = form;
        this.damage = damage;
        this.piercing = piercing;
        this.speed = speed;
        this.power = power;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getPiercing() {
        return piercing;
    }

    public void setPiercing(double piercing) {
        this.piercing = piercing;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
