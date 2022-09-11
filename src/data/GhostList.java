package data;

import models.Form;
import models.entities.Ghost;

import java.util.ArrayList;

public class GhostList {

    private static final ArrayList<Ghost> allGhosts = new ArrayList<>() {
        {
            add(new Ghost("Ghoul", new Form("Physical"), 100, 0, ElementList.multi("Infernal Dark"),
                    0, 0, 0, 3, 1, 1,
                    SkillList.multi("Attack"), 3));
        }
    };

    public static ArrayList<Ghost> getAll() {
        return allGhosts;
    }

    public static Ghost get(String name) {
        for(Ghost ghost : allGhosts) {
            if (name == ghost.getName()) {
                return ghost;
            }
        }
        throw new Error("Ghost not found.");
    }
}
