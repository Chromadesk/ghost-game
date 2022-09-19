package models.entities;

import models.Element;
import models.Form;
import models.skills.Skill;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Character extends Entity {
    private double armorPhysical;
    private double armorCorporeal;
    private double speedReaction;
    private double speedAgility;
    private double speedMovement;
    private double actionPoints;

    private HashMap<String, Skill> skills;

    public Character(String name, Form form, double health, double resistance, ArrayList<Element> elements, double armorPhysical, double armorCorporeal, double speedReaction, double speedAgility, double speedMovement, double actionPoints, HashMap<String, Skill> skills) {
        super(name, form, health, resistance, elements);
        this.armorPhysical = armorPhysical;
        this.armorCorporeal = armorCorporeal;
        this.speedReaction = speedReaction;
        this.speedAgility = speedAgility;
        this.speedMovement = speedMovement;
        this.actionPoints = actionPoints;
        this.skills = skills;
    }

    public void rollDefend(String name) {
        Skill skill = skills.get(name);

    }

    public double getArmorPhysical() {
        return armorPhysical;
    }

    public void setArmorPhysical(double armorPhysical) {
        this.armorPhysical = armorPhysical;
    }

    public double getArmorCorporeal() {
        return armorCorporeal;
    }

    public void setArmorCorporeal(double armorCorporeal) {
        this.armorCorporeal = armorCorporeal;
    }

    public double getSpeedReaction() {
        return speedReaction;
    }

    public void setSpeedReaction(double speedReaction) {
        this.speedReaction = speedReaction;
    }

    public double getSpeedAgility() {
        return speedAgility;
    }

    public void setSpeedAgility(double speedAgility) {
        this.speedAgility = speedAgility;
    }

    public double getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(double actionPoints) {
        this.actionPoints = actionPoints;
    }

    public HashMap<String, Skill> getSkills() {
        return skills;
    }

    public void setSkills(HashMap<String, Skill> skills) {
        this.skills = skills;
    }

    public double getSpeedMovement() {
        return speedMovement;
    }

    public void setSpeedMovement(double speedMovement) {
        this.speedMovement = speedMovement;
    }
}
