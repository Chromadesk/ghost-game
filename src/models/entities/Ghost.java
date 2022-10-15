package models.entities;

import models.elements.Element;
import models.skills.Skill;

import java.util.ArrayList;
import java.util.HashMap;

public class Ghost extends Character{

    double bounty;

    public Ghost(String name, boolean physicalForm, int health, int resistance, ArrayList<Element> elements, int armorPhysical, int armorCorporeal, int speedReaction, int speedAgility, int speedMovement, int actionPoints, HashMap<String, Skill> skills, double bounty) {
        super(name, physicalForm, health, resistance, elements, armorPhysical, armorCorporeal, speedReaction, speedAgility, speedMovement, actionPoints, skills);
        this.bounty = bounty;
    }

    public double getBounty() {
        return bounty;
    }

    public void setBounty(double bounty) {
        this.bounty = bounty;
    }
}
