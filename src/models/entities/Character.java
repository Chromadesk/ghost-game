package models.entities;

import models.Element;
import models.Form;
import models.Skill;

import java.util.ArrayList;

public abstract class Character extends Entity {

    int armorPhysical;

    int armorCorporeal;

    int speedReaction;

    int speedAgility;

    double damageMultiplier;

    int actionPoints;

    ArrayList<Skill> skills;

    public Character(String name, Form form, int health, int resistance, ArrayList<Element> elements, int armorPhysical, int armorCorporeal, int speedReaction, int speedAgility, double damageMultiplier, int actionPoints, ArrayList<Skill> skills) {
        super(name, form, health, resistance, elements);
        this.armorPhysical = armorPhysical;
        this.armorCorporeal = armorCorporeal;
        this.speedReaction = speedReaction;
        this.speedAgility = speedAgility;
        this.damageMultiplier = damageMultiplier;
        this.actionPoints = actionPoints;
        this.skills = skills;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
}
