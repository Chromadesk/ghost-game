package models.items;

import models.Element;
import models.Form;

import java.util.ArrayList;

public class Item {

    public String name;

    public Form form;

    public double damage;

    public double piercing;

    public double speed;

    public double power;

    public double value;

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
