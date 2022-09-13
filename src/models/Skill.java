package models;

import java.util.ArrayList;

public class Skill {

    boolean attack;
    String name;

    int damage;
    int piercing;
    int speed;
    int power;
    int cost;

    ArrayList<Element> elements;

    public Skill(String name, int damage, int piercing, int speed, int power, int cost) {
        this.name = name;
        this.damage = damage;
        this.piercing = piercing;
        this.speed = speed;
        this.power = power;
        this.cost = cost;
        this.attack = true;
    }

    /**
     * For non-offensive skills which do not directly deal damage.
     * @param name Name of the skill
     * @param speed The speed of the skill's application
     * @param cost How much AP it costs
     */
    public Skill(String name, int speed, int cost) {
        this.name = name;
        this.speed = speed;
        this.cost = cost;
        this.attack = false;
    }

    /**
     * Reserved for "Shoot" skill and its clones.
     * @param name Name of the skill
     */
    public Skill(String name, int cost) {
        this.name = name;
        this.cost = cost;
        this.attack = true;
    }

    public boolean isAttack() {
        return attack;
    }

    public void setAttack(boolean attack) {
        this.attack = attack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }
}
