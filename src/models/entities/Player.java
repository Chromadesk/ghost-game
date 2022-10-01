package models.entities;

import data.ElementList;
import data.SkillList;
import models.Element;
import models.items.Bullet;
import models.skills.Skill;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Character{
    private double money;
    private int maxMag = 6;
    private ArrayList<Bullet> loadedMag = new ArrayList<>();

    public Player(String name, boolean physicalForm, int health, int resistance, ArrayList<Element> elements, int armorPhysical, int armorCorporeal, int speedBlock, int speedAgility, int speedMovement, int actionPoints, HashMap<String, Skill> skills, double money, int maxMag) {
        super(name, physicalForm, health, resistance, elements, armorPhysical, armorCorporeal, speedBlock, speedAgility, speedMovement, actionPoints, skills);
        this.money = money;
        this.maxMag = maxMag;
    }

    public Player(String name) {
        super(name, true, 100, 0, ElementList.multi("Mortal"), 0, 0, 70, 40, 2, 3, SkillList.multi("shoot"));
        this.money = 10;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void reloadMag(ArrayList<Bullet> newClip) {
        if (newClip.size() > maxMag) {
            System.out.println("<!> reloadMag will overload maxMag size.");
        }
        this.loadedMag = newClip;
    }

    public ArrayList<Bullet> getLoadedMag() {
        return this.loadedMag;
    }

    public Bullet shootBullet() {
        if (this.loadedMag.size() == 0) return null;
        Bullet bullet = this.loadedMag.get(0);
        this.loadedMag.remove(0);
        return bullet;
    }

    public int getMaxMag() {
        return maxMag;
    }

    public void setMaxMag(int maxMag) {
        this.maxMag = maxMag;
    }

}
