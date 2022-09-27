package models.entities;

import models.Element;
import models.skills.Skill;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class Character extends Entity {
    private int armorPhysical;
    private int armorCorporeal;
    private int speedBlock;
    private int speedAgility;
    private int speedMovement;
    private int actionPoints;

    private HashMap<String, Skill> skills;

    /**
     * Character constructor
     * @param name Name of the character
     * @param physicalForm Physical, Corporeal, or Mystic form
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
    public Character(String name, boolean physicalForm, int health, int resistance, ArrayList<Element> elements, int armorPhysical, int armorCorporeal, int speedBlock, int speedAgility, int speedMovement, int actionPoints, HashMap<String, Skill> skills) {
        super(name, physicalForm, health, resistance, elements);
        this.armorPhysical = armorPhysical;
        this.armorCorporeal = armorCorporeal;
        this.speedBlock = speedBlock;
        this.speedAgility = speedAgility;
        this.speedMovement = speedMovement;
        this.actionPoints = actionPoints;
        this.skills = skills;
    }

    public String rollDefend(int speed) {
        if (speed < this.speedBlock) {
            if (speed < this.speedAgility) return "dodge";
            return "block";
        }
        return "fail";
    }

    public int getArmorPhysical() {
        return armorPhysical;
    }

    public void setArmorPhysical(int armorPhysical) {
        this.armorPhysical = armorPhysical;
    }

    public int getArmorCorporeal() {
        return armorCorporeal;
    }

    public void setArmorCorporeal(int armorCorporeal) {
        this.armorCorporeal = armorCorporeal;
    }

    public int getSpeedBlock() {
        return speedBlock;
    }

    public void setSpeedBlock(int speedBlock) {
        this.speedBlock = speedBlock;
    }

    public int getSpeedAgility() {
        return speedAgility;
    }

    public void setSpeedAgility(int speedAgility) {
        this.speedAgility = speedAgility;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public HashMap<String, Skill> getSkills() {
        return this.skills;
    }

    public void setSkills(HashMap<String, Skill> skills) {
        this.skills = skills;
    }

    public int getSpeedMovement() {
        return speedMovement;
    }

    public void setSpeedMovement(int speedMovement) {
        this.speedMovement = speedMovement;
    }

}
