package models.entities;

import models.Element;
import models.Form;
import models.skills.Skill;

import java.util.ArrayList;

public class Ghost extends Character{

    double bounty;

    public Ghost(String name, Form form, int health, int resistance, ArrayList<Element> elements, int armorPhysical, int armorCorporeal, int speedReaction, int speedAgility, int speedMovement, int actionPoints, ArrayList<Skill> skills, double bounty) {
        super(name, form, health, resistance, elements, armorPhysical, armorCorporeal, speedReaction, speedAgility, speedMovement, actionPoints, skills);
        this.bounty = bounty;
    }
}
