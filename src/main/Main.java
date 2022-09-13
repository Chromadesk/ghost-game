package main;

import data.PartData;
import models.items.Bullet;

public class Main {
    public static void main (String[] args) {
        System.out.println("running main");
        PartData.loadPartData();
        System.out.println(new Bullet("Default", PartData.allShape.get("Full Metal Jacket"),
                PartData.allProjectile.get("Lead"), PartData.allPowder.get("Black Powder"),
                PartData.allPrimer.get("Standard"), PartData.allCasings.get("Brass")));
    }
}
