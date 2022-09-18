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
    static int playingCharacter = 0;
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

    static void useSkill(Character character) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose one of " + character.getName() + "'s skills to use:");
        System.out.println(character.getSkills());
        Skill skill = character.getSkills().get(input.next());
        System.out.println("Select a character to use skill on:");
        String target = input.next();
        for (Character potentialTarget : characters) {
            if (target == potentialTarget.getName()) {
                skill.apply(potentialTarget);
            }
        }
    }

    static void listOptions() {
        if (characters.size() == 0) {
            System.out.println("No characters found.");
            addCharacter();
        }
        while (true) {
            Character player = characters.get(getPlayingCharacter());
            System.out.println("Turn " + turn + " - " + player.getName() + "'s Turn ---------------------------");
            System.out.println("Health: " + player.getHealth());
            System.out.println("AP: " + player.getActionPoints());
            System.out.println("Phys Armor: " + player.getArmorPhysical());
            System.out.println("Corp Armor: " + player.getArmorCorporeal());
            System.out.println("Move Speed: " + player.getSpeedMovement());
            System.out.println("Select an action:");
            System.out.println("1) Use Skill");
            System.out.println("3) Add New Character");
            Scanner input = new Scanner(System.in);
            switch (input.nextInt()) {
                case 1:
                    useSkill(player);
                    input.close();
                    break;
                case 3:
                    addCharacter();
                    input.close();
                    break;
                default:
                    nextTurn();
                    input.close();
                    return;
            }
        }
    }

    static int getPlayingCharacter() {
        if (playingCharacter > characters.size()) {
            playingCharacter = 0;
        }
        return playingCharacter;
    }

    static void nextTurn() {
        turn++;
        playingCharacter++;
        listOptions();
    }

}
