package models.entities;

import data.ElementList;
import data.SkillList;
import models.Element;
import models.skills.Skill;
import models.items.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Character{

    private ArrayList<Item> items;

    private int ammo;

    private double money;

    public Player(String name, boolean physicalForm, int health, int resistance, ArrayList<Element> elements, int armorPhysical, int armorCorporeal, int speedBlock, int speedAgility, int speedMovement, int actionPoints, HashMap<String, Skill> skills, ArrayList<Item> items, int ammo, double money) {
        super(name, physicalForm, health, resistance, elements, armorPhysical, armorCorporeal, speedBlock, speedAgility, speedMovement, actionPoints, skills);
        this.items = items;
        this.ammo = ammo;
        this.money = money;
    }

    public Player(String name) {
        super(name, true, 100, 0, ElementList.multi("Mortal"), 0, 0, 70, 40, 2, 3, SkillList.multi("Shoot"));
        this.items = new ArrayList<>();
        this.ammo = 0;
        this.money = 10;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
