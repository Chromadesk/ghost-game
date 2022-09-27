package data;
import models.entities.Ghost;

import java.util.HashMap;

public class GhostList {

    private static final HashMap<String, Ghost> allGhosts = new HashMap<>() {
        {
            put("ghoul", new Ghost("Ghoul", true, 100, 0, ElementList.multi("Infernal Dark"),
                    0, 0, 0, 3, 1, 1,
                    SkillList.multi("Attack"), 3));
        }
    };

    public static Ghost get(String name) {
        return allGhosts.get(name);
    }

    public static Ghost construct(String key) {
        Ghost ghost = allGhosts.get(key);
        return new Ghost(ghost.getName(), ghost.isPhysicalForm(), ghost.getHealth(), ghost.getResistance(),
                ghost.getElements(), ghost.getArmorPhysical(), ghost.getArmorCorporeal(), ghost.getSpeedBlock(),
                ghost.getSpeedAgility(), ghost.getSpeedMovement(), ghost.getActionPoints(), ghost.getSkills(),
                ghost.getBounty());
    }
}
