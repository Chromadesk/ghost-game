package main;

import data.PartData;

public class Main {
    public static void main (String[] args) {
        PartData.loadData();
        System.out.println(PartData.allParts);
    }
}
