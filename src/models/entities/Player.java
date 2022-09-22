package models.entities;

import data.ElementList;
import data.SkillList;
import models.Element;
import models.Form;
import models.skills.Skill;
import models.items.Item;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends Character{

    ArrayList<Item> items;

    int ammo;

    double money;

    public Player(String name, Form form, int health, int resistance, ArrayList<Element> elements, int armorPhysical, int armorCorporeal, int speedReaction, int speedAgility, int speedMovement, int actionPoints, HashMap<String, Skill> skills, ArrayList<Item> items, int ammo, double money) {
        super(name, form, health, resistance, elements, armorPhysical, armorCorporeal, speedReaction, speedAgility, speedMovement, actionPoints, skills);
        this.items = items;
        this.ammo = ammo;
        this.money = money;
    }

    public Player(String name) {
        super(name, new Form("Physical"), 100, 0, ElementList.multi("Mortal"), 0, 0, 70, 40, 2, 3, SkillList.multi("Shoot"));
        this.items = new ArrayList<>();
        this.ammo = 0;
        this.money = 10;
    }
}
