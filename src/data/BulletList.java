package data;

import models.items.Bullet;

import java.util.HashMap;

public class BulletList {

    private static final HashMap<String, Bullet> allBullets = new HashMap<>() {
        {
            put("standard",
                    new Bullet("Standard",
                    PartData.allShape.get("Full Metal Jacket"),
                    PartData.allProjectile.get("Lead"),
                    PartData.allPowder.get("Black Powder"),
                    PartData.allPrimer.get("Standard"),
                    PartData.allCasings.get("Brass")));
        }
    };

    public static Bullet get(String key) {
        return allBullets.get(key);
    }

    public static Bullet getById(int id) {
        for (Bullet bullet : allBullets.values()) {
            if (bullet.getId() == id) return bullet;
        }
        return null;
    }

    public static HashMap<String, Bullet> getAll() {
        return allBullets;
    }

}
