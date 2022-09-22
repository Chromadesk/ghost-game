package main;

import data.GhostList;
import data.PlayerList;
import models.entities.Character;
import models.skills.Skill;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Game {

    static int turn = 0;
    static final ArrayList<Character> characters = new ArrayList<>();

    static void addCharacter() {
        Scanner input = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("Input name of ghost/player to be added (or type x to cancel):");
            name = input.next();
            if(Objects.equals(name, "x")) {
                return;
            }
            if (PlayerList.get(name) != null) {
                characters.add(PlayerList.get(name));
                System.out.println("Added Player " + name);
                return;
            }
            if (GhostList.get(name) != null) {
                characters.add(GhostList.get(name));
                System.out.println("Added Ghost " + name);
                return;
            }
            System.out.println("Name not found. Try again:");
        }
    }

    static void listOptions() {
        if (characters.size() == 0) {
            System.out.println("No characters found.");
            addCharacter();
        }
        while (true) {
            System.out.println("\nTurn " + turn + " -----------------------------------------------------------------------------");
            for (Character character : characters) {
                System.out.println(character.getName() + " - " + Math.round(character.getHealth()) + "HP " +
                        Math.round(character.getArmorPhysical()) + " Phys Armor " +
                        Math.round(character.getArmorCorporeal()) + " Corp Armor " +
                        Math.round(character.getSpeedMovement()) + " Movespeed ");
            }
            Scanner input = new Scanner(System.in);
            String command = input.next();
        }
    }

    public static boolean rngPercentage(double num) {
        if (num >= 100) return true;
        return Math.round(Math.random() * 100) <= num;
    }

}
