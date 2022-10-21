package models.items;

import models.IdentifiableObject;
import models.StatGroup;
import models.items.bulletparts.*;

import java.util.HashMap;

// DOES NOT EXTEND ITEM!!
public class Bullet extends IdentifiableObject {

    private Shape shape;
    private Projectile projectile;
    private Dust dust;
    private Powder powder;
    private Primer primer;
    private Casing casing;

    private boolean physicalForm;
    private int value;

    HashMap<String, HashMap<String, StatGroup>> stats = new HashMap<>();

    public Bullet(String name, Shape shape, Projectile projectile, Powder powder, Primer primer, Casing casing) {
        super(name);
        this.shape = shape;
        this.projectile = projectile;
        this.powder = powder;
        this.primer = primer;
        this.casing = casing;
        this.stats.put("shapeStats", shape.getStats());
        this.stats.put("projectileStats", projectile.getStats());
        this.stats.put("powderStats", powder.getStats());
        this.stats.put("primerStats", primer.getStats());
        this.stats.put("casingStats", casing.getStats());
    }

    public Bullet(String name, Shape shape, Projectile projectile, Dust dust, Powder powder, Primer primer, Casing casing) {
        super(name);
        this.shape = shape;
        this.projectile = projectile;
        this.dust = dust;
        this.powder = powder;
        this.primer = primer;
        this.casing = casing;
        this.stats.put("shapeStats", shape.getStats());
        this.stats.put("projectileStats", projectile.getStats());
        this.stats.put("dustStats", dust.getStats());
        this.stats.put("powderStats", powder.getStats());
        this.stats.put("primerStats", primer.getStats());
        this.stats.put("casingStats", casing.getStats());
    }

    private void setForm(boolean form) {
        if (form) this.setPhysicalForm(true);
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

    public boolean isPhysicalForm() {
        return physicalForm;
    }

    public void setPhysicalForm(boolean physicalForm) {
        this.physicalForm = physicalForm;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public HashMap<String, HashMap<String, StatGroup>> getStats() {
        return stats;
    }

    public void setStats(HashMap<String, HashMap<String, StatGroup>> stats) {
        this.stats = stats;
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
