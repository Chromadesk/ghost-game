package models.skills;

import main.Game;
import models.Form;
import models.entities.Character;
import models.items.Bullet;
import models.items.Item;

import java.util.ArrayList;
import java.util.Objects;

public class Skill {
    String type;
    String name;
    Form form;
    double speed;
    double damage;
    double piercing;
    double power;
    int armorPhys;
    int armorCorp;
    boolean endsTurn;
    int apCost;

    /**
     * Offensive Type Skill Constructor
     * @param name Name of skill
     * @param speed Speed of skill
     * @param damage Damage of skill
     * @param piercing Piercing power of skill
     * @param power Stopping Power of skill
     * @param endsTurn If the skill ends your turn when used
     * @param apCost If the skill does not end turn, how much AP does it cost?
     */
    public Skill(String name, Form form, double speed, double damage, double piercing, double power, boolean endsTurn, int apCost) {
        this.type = "offensive";
        this.name = name;
        this.form = form;
        this.speed = speed;
        this.damage = damage;
        this.piercing = piercing;
        this.power = power;
        this.endsTurn = endsTurn;
        this.apCost = apCost;
    }

    public Skill(String name, boolean endsTurn, int apCost) {
        this.type = "shoot";
        this.name = name;
        this.endsTurn = endsTurn;
        this.apCost = apCost;
    }
    //TODO - make martial arts close quarters skills dependent on the item & character's strength
//    public Skill(String name, Item item, Character character, boolean endsTurn, int apCost) {
//        this.type = "martial";
//        this.name = name;
//        this.speed = character.get;
//        this.damage = bullet.getDamage();
//        this.piercing = bullet.getPiercing();
//        this.power = bullet.getPower();
//        this.endsTurn = endsTurn;
//        this.apCost = apCost;
//    }

    public void setBullet(Bullet bullet) {
        if (Objects.equals(this.type, "shoot")) {
            this.speed = bullet.getSpeed();
            this.damage = bullet.getDamage();
            this.piercing = bullet.getPiercing();
            this.power = bullet.getPower();
            this.form = bullet.getForm();
        }
        System.out.println("Error! setBullet cannot be used on non-shoot type skills.");;
    }

    /**
     * Activates this skill as an attack while accounting for dodge/block speed.
     * @param character Enemy target of skill.
     */
    public void useAttack(Character character) {
        if (character.rollDefend(this.speed) == "block") {
            System.out.println(character.getName() + " blocks the attack!");
            dealDamage(character, (int) Math.round(this.damage * 0.3));
        }
        if (character.rollDefend(this.speed) == "dodge") {
            System.out.println(character.getName() + " dodges the attack!");
        }
        if (character.rollDefend(this.speed) == "fail") {
            System.out.println(character.getName() + " is hit with " + this.name + "!");
        }
    }

    public void dealDamage(Character character, int damage) {
        //physical damage
        if (this.form.getName() == "Physical") {
            if (character.getArmorPhysical() > 0) {
                //Decide if the damage ignores the armor or not
                if (Game.rngPercentage(this.piercing)) {
                    character.setHealth(character.getHealth() - damage);
                    character.setArmorPhysical(damage - character.getArmorPhysical());
                    return;
                }
                //Deal damage to armor, if armor is 100% broken subtract leftover damage from health.
                character.setArmorPhysical(damage - character.getArmorPhysical());
                if (character.getArmorPhysical() < 0) {
                    character.setHealth(character.getHealth() - character.getArmorPhysical());
                }
                character.setHealth(character.getHealth() - damage);
                return;
            }
            //If no armor, just damage health
            character.setHealth(character.getHealth() - damage);
            return;
        }
        //corporeal damage
        if (this.form.getName() == "Corporeal" || this.form.getName() == "Mystic") {
            if (character.getArmorCorporeal() > 0) {
                //Decide if the damage ignores the armor or not
                if (Game.rngPercentage(this.piercing)) {
                    character.setHealth(character.getHealth() - damage);
                    character.setHealth(character.getHealth() - character.getArmorCorporeal());
                    return;
                }
                //Deal damage to armor, if armor is 100% broken subtract leftover damage from health.
                character.setArmorCorporeal(damage - character.getArmorCorporeal());
                if (character.getArmorCorporeal() < 0) {
                    character.setHealth(character.getHealth() - character.getArmorCorporeal());
                }
                character.setHealth(character.getHealth() - damage);
                return;
            }
            //If no armor, just damage health
            character.setHealth(character.getHealth() - damage);
            return;
        }
    }
}
