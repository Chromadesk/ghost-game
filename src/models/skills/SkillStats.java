package models.skills;

import models.IdentifiableObject;
import models.statuseffects.StatusEffect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SkillStats extends IdentifiableObject {

    String formChange;
    int speed;
    int damage;
    int piercing;
    int power;
    final ArrayList<StatusEffect> statusEffects = new ArrayList<>();

    public SkillStats(String name, String formChange, int speed, int damage, int piercing, int power, HashMap<StatusEffect, Integer> statusEffects) {
        super(name);
        this.formChange = formChange;
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
}
