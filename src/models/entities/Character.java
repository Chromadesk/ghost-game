package models.entities;

import models.Element;
import models.Form;
import models.skills.Skill;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Character extends Entity {
    private double armorPhysical;
    private double armorCorporeal;
    private double speedBlock;
    private double speedAgility;
    private double speedMovement;
    private double actionPoints;

    private HashMap<String, Skill> skills;

    /**
     * Character constructor
     * @param name Name of the character
     * @param form Physical, Corporeal, or Mystic form
     * @param health Max HP of character
     * @param resistance Stopping Power Resistance of character.
     * @param elements A list of all the character's elements.
     * @param armorPhysical Max PhyAR (Physical Armor) of character.
     * @param armorCorporeal Max CrpAR(Corporeal Armor) of character.
     * @param speedBlock How quickly character can react to attacks and use Block skill. Always faster than speedAgility.
     * @param speedAgility How quickly character can react to attacks and use Dodge skill.
     * @param speedMovement How many blocks the character can move each turn.
     * @param actionPoints How many AP (Action Points) the player has for smaller skills.
     * @param skills A list of all the character's skills.
     */
    public Character(String name, Form form, double health, double resistance, ArrayList<Element> elements, double armorPhysical, double armorCorporeal, double speedBlock, double speedAgility, double speedMovement, double actionPoints, HashMap<String, Skill> skills) {
        super(name, form, health, resistance, elements);
        this.armorPhysical = armorPhysical;
        this.armorCorporeal = armorCorporeal;
        this.speedBlock = speedBlock;
        this.speedAgility = speedAgility;
        this.speedMovement = speedMovement;
        this.actionPoints = actionPoints;
        this.skills = skills;
    }

    public String rollDefend(double speed) {
        if (speed < this.speedBlock) {
            if (speed < this.speedAgility) return "dodge";
            return "block";
        }
        return "fail";
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

    public double getSpeedBlock() {
        return speedBlock;
    }

    public void setSpeedBlock(double speedBlock) {
        this.speedBlock = speedBlock;
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
