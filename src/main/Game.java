package main;

import data.GhostList;
import data.PlayerList;
import models.entities.Character;

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
                characters.add(PlayerList.construct(name));
                System.out.println("Added Player " + name);
                return;
            }
            if (GhostList.get(name) != null) {
                characters.add(GhostList.construct(name));
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
                System.out.println("[" + character.getId() + "]" + character.getName() + " - " +
                        Math.round(character.getHealth()) + "HP " +
                        Math.round(character.getArmorPhysical()) + " Phys Armor " +
                        Math.round(character.getArmorCorporeal()) + " Corp Armor " +
                        Math.round(character.getSpeedMovement()) + " Movespeed ");
            }
            Scanner input = new Scanner(System.in);
            System.out.println("--Awaiting command...--");
            String command = input.nextLine();
            inputCommand(command);
        }
    }

    public static boolean rngPercentage(double num) {
        if (num >= 100) return true;
        return Math.round(Math.random() * 100) <= num;
    }

    /**
     * Acts like a standard game dev console, accepts commands in the format of "entity fields", separated by spaces.
     * @param command The inputted command
     */
    private static void inputCommand(String command) {
        String[] fields = command.split(" ");
        //System (sys)
        if (Objects.equals(fields[0], "sys")) {
            //sys addChar
            if (Objects.equals(fields[1], "addChar")) {
                addCharacter();
                return;
            }
            //sys kill *charID*
            if (Objects.equals(fields[1], "kill")) {
                if (getById(fields[2]) == null) {
                    System.out.println("ID not found in current game player list.");
                    return;
                }
                characters.remove(getById(fields[2]));
                return;
            }
            System.out.println("No such system command");
        }
        //Character (char)
        if (Objects.equals(fields[0], "char")) {
            Character character = PlayerList.get(fields[2]);
            //char getSkills *character*
            if (Objects.equals(fields[1], "getSkills")) {
                System.out.println(character.getSkills());
                return;
            }
            //char useSkill *user* *skill name* *target*
            if (Objects.equals(fields[1], "useSkill")) {
                character.getSkills().get(fields[3]).useAttack(PlayerList.get(fields[4]));
                return;
            }
            //char set *character* *stat* *num*
//            if (fields[1] == "set") {
//                character.set
//                return;
//            }
            System.out.println("No such character command");
        }
        System.out.println("No such command");

    }

    private static Character getById(Object id) {
        if (id.getClass() == String.class) {
            if (!isNumeric((String) id)) {
                return null;
            }
            id = Integer.parseInt((String) id);
        }
        for (Character character : characters) {
            if (character.getId() == (int) id) {
                return character;
            }
        }
        return null;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
