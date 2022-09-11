//package data;
//
//import models.items.Bullet;
//import models.items.Item;
//import models.items.bulletparts.*;
//
//import java.util.ArrayList;
//
//public class PartList {
//
//    private static final ArrayList<Shape> allShapes = new ArrayList<>() {
//        {
//            add(new Shape("Full Metal Jacket", 10, 5, 0, 0, 1.5));
//            add(new Shape("Hollow Point", 0, -10, 10, 0, 1));
//            add(new Shape("Frangible", 0, -100, 0, 20, 1));
//            add(new Shape("Armor Piercing", 10, 40, -20, 10, 2));
//            add(new Shape("Bore Shell", 12, 0, 0, 10, 2));
//        }
//    };
//    private static final ArrayList<Projectile> allProjectiles = new ArrayList<>() {
//        {
//            add(new Projectile("Metal", "Lead", 70,10,50,10,1.50));
//        }
//    };
//    private static final ArrayList<Dust> allDusts = new ArrayList<>() {
//        {
//            add(new Dust("test", "test", 10, 10, 10, 10, 10));
//        }
//    };
//    private static final ArrayList<Powder> allPowders = new ArrayList<>() {
//        {
//            add(new Powder("Black Powder", 20, 10, 50, 10, 0.25));
//        }
//    };
//    private static final ArrayList<Primer> allPrimers = new ArrayList<>() {
//        {
//            add(new Primer("Standard", 0, 0, 0, 0, 0));
//        }
//    };
//    private static final ArrayList<Casing> allCasings = new ArrayList<>() {
//        {
//            add(new Casing("Brass", 0, 0, 0, 0, 0));
//        }
//    };
//    private static final ArrayList<Bullet> allBullets = new ArrayList<>() {
//        {
//            add(new Bullet("Default", PartList.get("Full Metal Jacket", allShapes)));
//        }
//    };
//
//    public static Item get(String name, ArrayList<Item> list) {
//        for(Item item : list) {
//            if (name == item.getName()) {
//                return item;
//            }
//        }
//        throw new Error("Item not found.");
//    }
//
//}
