package models.skills;

import main.Game;
import models.IdentifiableObject;
import models.statuseffects.StatusEffect;
import models.entities.Character;
import models.entities.Player;
import models.items.Bullet;

import java.util.*;

public class Skill extends IdentifiableObject {
    //TODO Make healing, armor giving, supporting, etc all those kinds of skills work.
    //TODO Replace "type" with a Skill interface and multiple skill classes that implement it.
    String type;
    boolean physicalForm;
    int speed;
    int damage;
    int piercing;
    int power;
    boolean endsTurn;
    int apCost;
    Character user;
    //The status effect, then the duration of the effect
    HashMap<StatusEffect, Integer> statusEffects = new HashMap<>();

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
    public Skill(String name, boolean physicalForm, int speed, int damage, int piercing, int power, boolean endsTurn, int apCost) {
        super(name);
        this.type = "offensive";
        this.physicalForm = physicalForm;
        this.speed = speed;
        this.damage = damage;
        this.piercing = piercing;
        this.power = power;
        this.endsTurn = endsTurn;
        this.apCost = apCost;
    }
    public Skill(String name, boolean physicalForm, int speed, int damage, int piercing, int power, boolean endsTurn, int apCost, HashMap<StatusEffect, Integer> statusEffects) {
        super(name);
        this.type = "offensive";
        this.physicalForm = physicalForm;
        this.speed = speed;
        this.damage = damage;
        this.piercing = piercing;
        this.power = power;
        this.endsTurn = endsTurn;
        this.apCost = apCost;
        this.statusEffects = statusEffects;
    }

    public Skill(String name, boolean endsTurn, int apCost) {
        super(name);
        this.type = "shoot";
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
            this.physicalForm = bullet.isPhysicalForm();
            return;
        }
        System.out.println("Error! setBullet cannot be used on non-shoot type skills.");
    }

    public void shootSkill(Character character) {
        if (!Objects.equals(this.type, "shoot")) {
            useAttack(character);
            return;
        }
        if (((Player) user).getLoadedMag().size() == 0) System.out.println("No ammo!");
        setBullet(((Player) user).shootBullet());
        useAttack(character);
    }

    /**
     * Uses skill as an attack to damage a target while accounting for armor, speed, and power. Will also end turn
     * and/or cost AP.
     * @param character Enemy target of skill.
     */
    public void useAttack(Character character) {
        if (Objects.equals(character.rollDefend(this.speed), "block")) {
            System.out.println(character.getName() + " blocks the attack!");
            dealDamage(character, (int) Math.round(this.damage * 0.3));
            dealPower(character, (int) Math.round(this.power));
            dealEffects(character);
        }
        if (Objects.equals(character.rollDefend(this.speed), "dodge")) {
            System.out.println(character.getName() + " dodges the attack!");
        }
        if (Objects.equals(character.rollDefend(this.speed), "fail")) {
            System.out.println(character.getName() + " is hit with " + this.getName() + "!");
            dealDamage(character, (int) Math.round(this.damage));
            dealPower(character, (int) Math.round(this.power));
            dealEffects(character);
        }
    }

    /**
     * Deals damage while accounting for the armor of the target and the piercing value of the skill.
     * @param character The target of damage.
     * @param damage The amount of damage to do to the target before accounting for armor.
     */
    private void dealDamage(Character character, int damage) {
        //physical damage
        if (this.physicalForm) {
            if (character.getArmorPhysical() > 0) {
                //Decide if the damage ignores the armor or not
                if (Game.rngPercentage(this.piercing)) {
                    character.setHealth(character.getHealth() - damage);
                    character.setArmorPhysical(damage - character.getArmorPhysical());
                    System.out.println(damage + " damage pierces through the physical armor!");
                    return;
                }
                //Deal damage to armor, if armor is 100% broken subtract leftover damage from health.
                character.setArmorPhysical(damage - character.getArmorPhysical());
                System.out.println(damage + " damage to physical armor!");
                if (character.getArmorPhysical() < 0) {
                    character.setHealth(character.getHealth() - character.getArmorPhysical());
                }
                return;
            }
            //If no armor, just damage health
            character.setHealth(character.getHealth() - damage);
            System.out.println(damage + " damage!");
            return;
        }
        //corporeal damage
        if (character.getArmorCorporeal() > 0) {
            //Decide if the damage ignores the armor or not
            if (Game.rngPercentage(this.piercing)) {
                character.setHealth(character.getHealth() - damage);
                character.setHealth(character.getHealth() - character.getArmorCorporeal());
                System.out.println(damage + " damage pierces through the physical armor!");
                return;
            }
            //Deal damage to armor, if armor is 100% broken subtract leftover damage from health.
            character.setArmorCorporeal(damage - character.getArmorCorporeal());
            if (character.getArmorCorporeal() < 0) {
                character.setHealth(character.getHealth() - character.getArmorCorporeal());
                System.out.println(damage + " damage to physical armor!");
                return;
            }
            //If no armor, just damage health
            character.setHealth(character.getHealth() - damage);
            System.out.println(damage + " damage!");
        }
    }

    private void dealPower(Character character, int stoppingPower) {
        if (character.getResistance() <= stoppingPower) {
            System.out.println(character.getName() + " is stunned!");
        }
    }

    private void dealEffects(Character character) {
        for (Map.Entry<StatusEffect, Integer> effectPair : statusEffects.entrySet()) {
            effectPair.getKey().use(this.user, character, effectPair.getValue());
        }
    }

    public Character getUser() {
        return user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPhysicalForm() {
        return physicalForm;
    }

    public void setPhysicalForm(boolean physicalForm) {
        this.physicalForm = physicalForm;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPiercing() {
        return piercing;
    }

    public void setPiercing(int piercing) {
        this.piercing = piercing;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isEndsTurn() {
        return endsTurn;
    }

    public void setEndsTurn(boolean endsTurn) {
        this.endsTurn = endsTurn;
    }

    public int getApCost() {
        return apCost;
    }

    public void setApCost(int apCost) {
        this.apCost = apCost;
    }

    public HashMap<StatusEffect, Integer> getStatusEffects() {
        return statusEffects;
    }

    public void setStatusEffects(HashMap<StatusEffect, Integer> statusEffects) {
        this.statusEffects = statusEffects;
    }

    public void setUser(Character user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return type + "Skill" + " [" + this.getName() + ']' + " physicalForm=" + physicalForm + ", speed=" + speed + ", damage=" + damage + ", piercing=" + piercing + ", power=" + power + ", endsTurn=" + endsTurn + ", apCost=" + apCost;
    }
}
