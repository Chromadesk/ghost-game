package models.items;

import models.Form;
import models.items.bulletparts.*;

public class Bullet extends Item{
    Shape shape;
    Projectile projectile;
    Dust dust;
    Powder powder;
    Primer primer;
    Casing casing;
    public Bullet(String name, Shape shape, Projectile projectile, Powder powder, Primer primer, Casing casing) {
        super(name, new Form("Physical"), shape.getDamage() + projectile.getDamage() + powder.getDamage() + primer.getDamage() + casing.getDamage(),
                shape.getPiercing() + projectile.getPiercing() + + powder.getPiercing() + primer.getPiercing() + casing.getPiercing(),
                shape.getSpeed() + projectile.getSpeed() + powder.getSpeed() + primer.getSpeed() + casing.getSpeed(),
                shape.getPower() + projectile.getPower() + powder.getPower() + primer.getPower() + casing.getPower(),
                shape.getValue() + projectile.getValue() + powder.getValue() + primer.getValue() + casing.getValue());
        this.shape = shape;
        this.projectile = projectile;
        this.powder = powder;
        this.primer = primer;
        this.casing = casing;
    }

    public Bullet(String name, Shape shape, Projectile projectile, Dust dust, Powder powder, Primer primer, Casing casing) {
        super(name, new Form("Physical"), shape.getDamage() + projectile.getDamage() + dust.getDamage() + powder.getDamage() + primer.getDamage() + casing.getDamage(),
                shape.getPiercing() + projectile.getPiercing() + dust.getPiercing() + powder.getPiercing() + primer.getPiercing() + casing.getPiercing(),
                shape.getSpeed() + projectile.getSpeed() + dust.getSpeed() + powder.getSpeed() + primer.getSpeed() + casing.getSpeed(),
                shape.getPower() + projectile.getPower() + dust.getPower() + powder.getPower() + primer.getPower() + casing.getPower(),
                shape.getValue() + projectile.getValue() + dust.getValue() + powder.getValue() + primer.getValue() + casing.getValue());
        this.shape = shape;
        this.projectile = projectile;
        this.dust = dust;
        this.powder = powder;
        this.primer = primer;
        this.casing = casing;
    }
}
