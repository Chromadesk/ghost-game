package data;

import models.StatusEffect;

import java.util.HashMap;

public class StatusEffectList {

    private static final HashMap<String, StatusEffect> all = new HashMap<>() {
        {
            put("poison", new StatusEffect("Poisoned", "weakness", false, 3,
                    "%-20",
                    "",
                    "",
                    "",
                    "%-10",
                    "%-10",
                    "%-10",
                    ""));
        }
    };

    public static StatusEffect get(String name) {
        return all.get(name);
    }

    public static StatusEffect construct(String key) {
        StatusEffect statusEffect = all.get(key);
        return new StatusEffect(statusEffect.getName(), statusEffect.getDescription(), statusEffect.isAutoStacking(),
                statusEffect.getMaxStack(), statusEffect.getEffectHealth(), statusEffect.getEffectResistance(),
                statusEffect.getEffectArmorPhysical(), statusEffect.getEffectArmorCorporeal(), statusEffect.getEffectSpeedBlock(),
                statusEffect.getEffectSpeedAgility(), statusEffect.getEffectSpeedMovement(), statusEffect.getEffectActionPoints());
    }

}
