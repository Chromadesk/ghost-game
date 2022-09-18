package data;

import models.Form;
import models.entities.Ghost;
import java.util.HashMap;

public class GhostList {

    private static final HashMap<String, Ghost> allGhosts = new HashMap<>() {
        {
            put("Ghoul", new Ghost("Ghoul", new Form("Physical"), 100, 0, ElementList.multi("Infernal Dark"),
                    0, 0, 0, 3, 1, 1,
                    SkillList.multi("Attack"), 3));
        }
    };

    public static Ghost get(String name) {
        return allGhosts.get(name);
    }
}
