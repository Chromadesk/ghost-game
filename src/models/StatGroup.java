package models;

import models.IdentifiableObject;
import models.statuseffects.StatusEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Most classes which contain offensive stats have a map of StatGroup objects.
 * This allows each class to have differing effects depending on which StatGroup is called.
 * Each Stat Group must be named "objName_statGrpName" and there must be one Default stat group in every
 * class, the other stat groups must be named elements so that they may be called whenever the object is
 * used against said element.
 */
public class StatGroup extends IdentifiableObject {

    int speed;
    int damage;
    int piercing;
    int power;
    final ArrayList<StatusEffect> statusEffects = new ArrayList<>();

    /**
     *
     * @param name Name as "objectName_statGroupName". EX: leadProjectile_default
     * @param speed How fast the object will move. EX: Default human speed is 70 block, 50 dodge.
     * @param damage How much base damage the object will deal upon a successful hit. EX: Default bullet does 100 damage.
     * @param piercing What percentage of damage is added when hitting armor. EX: 50 pierce = +50% damage to armor.
     * @param power How much stopping power the object has. EX: Default bullet is 10 power, default person is 0 resistance.
     * @param statusEffects A map of status effects the object applies upon successful hit. StatusEffect object as the key
     *                      and int duration as the value so each status effect can be given a duration in turns.
     */
    public StatGroup(String name, int speed, int damage, int piercing, int power, HashMap<StatusEffect, Integer> statusEffects) {
        super(name);
        this.speed = speed;
        this.damage = damage;
        this.piercing = piercing;
        this.power = power;
        for (Map.Entry<StatusEffect, Integer> effectPair : statusEffects.entrySet()) {
            StatusEffect effect = effectPair.getKey();
            effect.setDuration(effectPair.getValue());
            this.statusEffects.add(effect);
        }
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

    public ArrayList<StatusEffect> getStatusEffects() {
        return statusEffects;
    }
}
