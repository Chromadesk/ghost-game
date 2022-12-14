package data;

import models.skills.Skill;
import java.util.HashMap;
import java.util.Map;

public class SkillList {

    private static final HashMap<String, Skill> allSkills = new HashMap<>() {
        {
            put("shoot", new Skill("Shoot", true, 0));
        }
    };

    public static HashMap<String, Skill> multi(String name) {
        HashMap<String, Skill> list = new HashMap<>();
        for (Map.Entry<String, Skill> set : allSkills.entrySet()) {
            if (name.contains(set.getKey())) {
                list.put(set.getKey(), set.getValue());
            }
        }
        return list;
    }
}
