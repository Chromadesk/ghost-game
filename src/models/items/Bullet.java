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
        super(name, new Form("Physical"), shape.damage + projectile.damage + powder.damage + primer.damage + casing.damage,
                shape.piercing + projectile.piercing + + powder.piercing + primer.piercing + casing.piercing,
                shape.speed + projectile.speed + powder.speed + primer.speed + casing.speed,
                shape.power + projectile.power + powder.power + primer.power + casing.power,
                shape.value + projectile.value + powder.value + primer.value + casing.value);
        this.shape = shape;
        this.projectile = projectile;
        this.powder = powder;
        this.primer = primer;
        this.casing = casing;
    }

    public Bullet(String name, Shape shape, Projectile projectile, Dust dust, Powder powder, Primer primer, Casing casing) {
        super(name, new Form("Physical"), shape.damage + projectile.damage + dust.damage + powder.damage + primer.damage + casing.damage,
                shape.piercing + projectile.piercing + dust.piercing + powder.piercing + primer.piercing + casing.piercing,
                shape.speed + projectile.speed + dust.speed + powder.speed + primer.speed + casing.speed,
                shape.power + projectile.power + dust.power + powder.power + primer.power + casing.power,
                shape.value + projectile.value + dust.value + powder.value + primer.value + casing.value);
        this.shape = shape;
        this.projectile = projectile;
        this.dust = dust;
        this.powder = powder;
        this.primer = primer;
        this.casing = casing;
    }
}
