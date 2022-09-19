package models.skills;

import models.entities.Character;
import models.items.Bullet;
import models.items.Item;

import java.util.ArrayList;
import java.util.Objects;

public class Skill {
    String type;
    String name;
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
    public Skill(String name, double speed, double damage, double piercing, double power, boolean endsTurn, int apCost) {
        this.type = "offensive";
        this.name = name;
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
        }
        throw new Error("Cannot use setBullet on non shoot type skill.");
    }

    //TODO Apply effect to character while taking into account any potential defensive/dodge abilities of the target.
    public void apply(Character character) {
        if (this.type == "offensive") {

        }
        if (this.type == "defensive") {

        }
        if (this.type == "dodge") {

        }
        if (this.type == "shoot") {

        }
    }
}
