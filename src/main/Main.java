package main;

import data.PartData;
import models.items.Bullet;

public class Main {
    public static void main (String[] args) {
        System.out.println("running main");
        PartData.loadPartData();
        Game.listOptions();
    }
}
