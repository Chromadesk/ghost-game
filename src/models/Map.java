package models;

import models.entities.Entity;

import java.util.ArrayList;

public class Map {

    String name;

    ArrayList<Entity> entities;

    boolean day;

    boolean domain;

    public Map(String name, ArrayList<Entity> entities, boolean day, boolean domain) {
        this.name = name;
        this.entities = entities;
        this.day = day;
        this.domain = domain;
    }
}
