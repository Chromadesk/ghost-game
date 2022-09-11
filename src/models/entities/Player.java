package models.entities;

import data.ElementList;
import data.SkillList;
import models.Element;
import models.Form;
import models.Skill;
import models.items.Item;

import java.util.ArrayList;

public class Player extends Character{

    ArrayList<Item> items;

    int ammo;

    double money;

    public Player(String name, int health, int resistance, ArrayList<Element> elements, int armorPhysical, int armorCorporeal, int speedReaction, int speedAgility, double damageMultiplier, int actionPoints, ArrayList<Skill> skills, ArrayList<Item> items, int ammo, double money) {
        super(name, new Form("Physical"), health, resistance, elements, armorPhysical, armorCorporeal, speedReaction, speedAgility, damageMultiplier, actionPoints, skills);
        this.items = items;
        this.ammo = ammo;
        this.money = money;
    }

    public Player (String name) {
        super(name, new Form("Physical"), 100, 0, ElementList.multi("Mortal"),
                0, 0, 50, 2, 1, 1,
                SkillList.multi("Shoot,Move"));
    }

}
