package main;

import data.PartData;

public class Main {
    public static void main (String[] args) {
        System.out.println("running main");
        PartData.loadPartData();
        System.out.println("ooga booga");
        System.out.println(PartData.allParts);
        System.out.println(PartData.allCasings);
        System.out.println(PartData.allShape);
        System.out.println(PartData.allDust);
        System.out.println(PartData.allPowder);
        System.out.println(PartData.allPrimer);
        System.out.println(PartData.allProjectile);
    }
}
