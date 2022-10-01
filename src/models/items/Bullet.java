package models.items;

import models.items.bulletparts.*;

public class Bullet extends Item {

    Shape shape;
    Projectile projectile;
    Dust dust;
    Powder powder;
    Primer primer;
    Casing casing;
    public Bullet(String name, Shape shape, Projectile projectile, Powder powder, Primer primer, Casing casing) {
        super(name, true, shape.getDamage() + projectile.getDamage() + powder.getDamage() + primer.getDamage() + casing.getDamage(),
                shape.getPiercing() + projectile.getPiercing() + powder.getPiercing() + primer.getPiercing() + casing.getPiercing(),
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
        super(name, true, shape.getDamage() + projectile.getDamage() + dust.getDamage() + powder.getDamage() + primer.getDamage() + casing.getDamage(),
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

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Projectile getProjectile() {
        return projectile;
    }

    public void setProjectile(Projectile projectile) {
        this.projectile = projectile;
    }

    public Dust getDust() {
        return dust;
    }

    public void setDust(Dust dust) {
        this.dust = dust;
    }

    public Powder getPowder() {
        return powder;
    }

    public void setPowder(Powder powder) {
        this.powder = powder;
    }

    public Primer getPrimer() {
        return primer;
    }

    public void setPrimer(Primer primer) {
        this.primer = primer;
    }

    public Casing getCasing() {
        return casing;
    }

    public void setCasing(Casing casing) {
        this.casing = casing;
    }
    @Override
    public String toString() {
        if (this.dust == null) {
            return "[" + this.getId() + "]" + " Name - " + this.getName() + " | Shape - " + this.shape.getName() +
                    " | Projectile - " + this.projectile.getName() + " | Powder - " + this.powder.getName() +
                    " | Primer - " + this.primer.getName() + " | Casing - " + this.casing.getName();
        }

        return "[" + this.getId() + "]" + " Name - " + this.getName() + " | Shape - " + this.shape.getName() +
                " | Projectile - " + this.projectile.getName() + " | Powder - " + this.powder.getName() +
                " | Dust - " + this.dust.getName() +  " | Primer - " + this.primer.getName() +
                " | Casing - " + this.casing.getName();
    }
}
