package main;

import data.GhostList;
import data.PlayerList;
import models.entities.Ghost;
import models.entities.Character;
import models.entities.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public static final ArrayList<Character> characters = new ArrayList<>();

    public static void addCharacter() {
        Scanner input = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("Input name of ghost/player to be added:");
            name = input.next();
            if(name.length() == 0) {
                return;
            }
            for (Ghost ghost : GhostList.getAll()) {
                if (ghost.getName() == name) {
                    input.close();
                    characters.add(ghost);
                }
            }
            for (Player player : PlayerList.getAll()) {
                if (player.getName() == name) {
                    input.close();
                    characters.add(player);
                }
            }
            System.out.println("Name not found. Try again:");
        }
    }

}
