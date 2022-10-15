package models.statuseffects;

import models.IdentifiableObject;
import models.entities.Character;

public class StatusEffect extends IdentifiableObject {

    //String name

    String description;
    boolean autoStacking;
    int maxStack;
    int stack = 1;
    int duration;
    Character applied = null;
    Character applier = null;

    //Character stats, put blank if a stat is not to be effected.
    //=? Set stat to number
    //x? Multiply stat by number
    //-? Subtract stat by number
    //%? Set stat to percentage of its value
    ///? Divide stat by number
    //"=40" would set the stat to 40.
    String effectHealth;
    String effectResistance;
    String effectArmorPhysical;
    String effectArmorCorporeal;
    String effectSpeedBlock;
    String effectSpeedAgility;
    String effectSpeedMovement;
    String effectActionPoints;

    public void use(Character applier, Character applied, int duration) {
        this.applier = applier;
        this.applied = applied;
        this.duration = duration;
        applied.addStatusEffect(this);
        this.applyAll();
    };

    private void applyAll() {
        applied.setHealth(stringFunctionToNum(effectHealth, applied.getHealth()));
        applied.setResistance(stringFunctionToNum(effectResistance, applied.getResistance()));
        applied.setArmorPhysical(stringFunctionToNum(effectArmorPhysical, applied.getArmorPhysical()));
        applied.setArmorCorporeal(stringFunctionToNum(effectArmorCorporeal, applied.getArmorCorporeal()));
        applied.setSpeedBlock(stringFunctionToNum(effectSpeedBlock, applied.getSpeedBlock()));
        applied.setSpeedAgility(stringFunctionToNum(effectSpeedAgility, applied.getSpeedAgility()));
        applied.setSpeedMovement(stringFunctionToNum(effectSpeedMovement, applied.getSpeedMovement()));
        applied.setActionPoints(stringFunctionToNum(effectActionPoints, applied.getActionPoints()));
    }

    public void stackAll() {
        if (!canStack()) {
            return;
        }
        applyAll();
        stack++;
    }

    /**
     * Turns a string function (listed above) into a number after applying it on another number.
     * @param efStat The string function, (+, -, =, x, %, /)
     * @param stat The number which the function is meant to apply to.
     * @return A new number, which is the result of the function.
     */
    private int stringFunctionToNum(String efStat, int stat) {
        if (efStat.length() <= 1) {
            return stat;
        }

        int numEfStat = Integer.parseInt(efStat.substring(1));

        if ((efStat.startsWith("+"))) {
            return stat + numEfStat;
        }
        if ((efStat.startsWith("-"))) {
            return stat - numEfStat;
        }
        if ((efStat.startsWith("x"))) {
            return stat * numEfStat;
        }
        if ((efStat.startsWith("%"))) {
            return stat * (numEfStat / 100);
        }
        if ((efStat.startsWith("/"))) {
            return stat / numEfStat;
        }

        return stat;
    }

    private boolean canStack() {
        if (stack == maxStack) {
            return false;
        }
        return true;
    }

    public StatusEffect(String name, String description, boolean autoStacking, int maxStack, String effectHealth, String effectResistance, String effectArmorPhysical, String effectArmorCorporeal, String effectSpeedBlock, String effectSpeedAgility, String effectSpeedMovement, String effectActionPoints) {
        super(name);
        this.description = description;
        this.autoStacking = autoStacking;
        this.maxStack = maxStack;
        this.effectHealth = effectHealth;
        this.effectResistance = effectResistance;
        this.effectArmorPhysical = effectArmorPhysical;
        this.effectArmorCorporeal = effectArmorCorporeal;
        this.effectSpeedBlock = effectSpeedBlock;
        this.effectSpeedAgility = effectSpeedAgility;
        this.effectSpeedMovement = effectSpeedMovement;
        this.effectActionPoints = effectActionPoints;
    }

    //Getters & Setters
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAutoStacking() {
        return autoStacking;
    }

    public void setAutoStacking(boolean autoStacking) {
        this.autoStacking = autoStacking;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }

    public int getStack() {
        return stack;
    }

    public void setStack(int stack) {
        this.stack = stack;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Character getApplied() {
        return applied;
    }

    public void setApplied(Character applied) {
        this.applied = applied;
    }

    public Character getApplier() {
        return applier;
    }

    public void setApplier(Character applier) {
        this.applier = applier;
    }

    public String getEffectHealth() {
        return effectHealth;
    }

    public void setEffectHealth(String effectHealth) {
        this.effectHealth = effectHealth;
    }

    public String getEffectResistance() {
        return effectResistance;
    }

    public void setEffectResistance(String effectResistance) {
        this.effectResistance = effectResistance;
    }

    public String getEffectArmorPhysical() {
        return effectArmorPhysical;
    }

    public void setEffectArmorPhysical(String effectArmorPhysical) {
        this.effectArmorPhysical = effectArmorPhysical;
    }

    public String getEffectArmorCorporeal() {
        return effectArmorCorporeal;
    }

    public void setEffectArmorCorporeal(String effectArmorCorporeal) {
        this.effectArmorCorporeal = effectArmorCorporeal;
    }

    public String getEffectSpeedBlock() {
        return effectSpeedBlock;
    }

    public void setEffectSpeedBlock(String effectSpeedBlock) {
        this.effectSpeedBlock = effectSpeedBlock;
    }

    public String getEffectSpeedAgility() {
        return effectSpeedAgility;
    }

    public void setEffectSpeedAgility(String effectSpeedAgility) {
        this.effectSpeedAgility = effectSpeedAgility;
    }

    public String getEffectSpeedMovement() {
        return effectSpeedMovement;
    }

    public void setEffectSpeedMovement(String effectSpeedMovement) {
        this.effectSpeedMovement = effectSpeedMovement;
    }

    public String getEffectActionPoints() {
        return effectActionPoints;
    }

    public void setEffectActionPoints(String effectActionPoints) {
        this.effectActionPoints = effectActionPoints;
    }

    @Override
    public String toString() {
        return "[" + this.getId() + "] " + this.getName() + " - " + this.description;
    }
}
