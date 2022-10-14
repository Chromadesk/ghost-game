package models.skills;

import models.IdentifiableObject;

public abstract class BaseSkill extends IdentifiableObject {

    //TODO

    Character user;

    public BaseSkill(String name) {
        super(name);
    }

    public abstract void use();

    public Character getUser() {
        return user;
    }

    public void setUser(Character user) {
        this.user = user;
    }
}
