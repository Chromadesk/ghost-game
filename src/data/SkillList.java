package data;

import models.Element;
import models.Skill;

import java.util.ArrayList;

public class SkillList {

    private static final ArrayList<Skill> allSkills = new ArrayList<>() {
        {
            add(new Skill("Attack", 30, 0, 60, 10, 1, ElementList.multi("Mortal")));
            add(new Skill("Shoot"));
            add(new Skill("Move", 30, 1));
        }
    };

    public static ArrayList<Skill> getAll() {
        return allSkills;
    }

    public static Skill get(String name) {
        for(Skill skill : allSkills) {
                if (name == skill.getName()) {
                    return skill;
                }
        }
        throw new Error("Skill not found");
    }

    public static ArrayList<Skill> multi(String name) {
        ArrayList<Skill> list = new ArrayList<>();
        for (Skill skill : allSkills) {
            if (name.contains(skill.getName())) {
                list.add(skill);
            }
        }
        return list;
    }

}
