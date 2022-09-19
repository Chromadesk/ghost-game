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
            System.out.println("\nTurn " + turn + "-----------------------------------------------------------------------------");
            System.out.println("Select an action:");
            System.out.println("1) Use Skill");
            System.out.println("3) Add New Character");
            Scanner input = new Scanner(System.in);
            switch (input.nextInt()) {
                case 1:
                    System.out.println("");
                    input.close();
                    break;
                case 3:
                    addCharacter();
                    input.close();
                    break;
            }
        }
    }

}
