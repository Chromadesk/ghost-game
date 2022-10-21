package main;

import models.StatGroup;
import models.items.Bullet;
import models.statuseffects.StatusEffect;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Contains all the methods and commands which will be used in GameController.
 */
public class ConsoleController {
    //Remove all non getter & setter methods from models and put them here.

    //What needs to change with time?
    //Turn count
    //AP refreshing
    //Duration of status effects

    int turn = 0;

    private static StatGroup selectStatGroup(String group, HashMap<String, StatGroup> statGroupList) {
        if (statGroupList.get(group) == null) {
            return statGroupList.get("default");
        }
        return statGroupList.get(group);
    }

    private static StatGroup selectStatGroupFromCluster(String group, HashMap<String, HashMap<String, StatGroup>> stats) {
        int speed = 0;
        int damage = 0;
        int piercing = 0;
        int power = 0;
        ArrayList<StatusEffect> statusEffects = new ArrayList<>();

        for (HashMap<String, StatGroup> statGroupList : stats.values()) {
            StatGroup statGroup = selectStatGroup(group, statGroupList);
            speed += statGroup.getSpeed();
            damage += statGroup.getDamage();
            piercing += statGroup.getPiercing();
            power += statGroup.getPower();
            statusEffects.addAll(statGroup.getStatusEffects());
        }

        return new StatGroup("", speed, damage, piercing, power, statusEffects);
    }


}
