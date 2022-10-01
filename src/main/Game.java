package main;

import data.BulletList;
import data.GhostList;
import data.PlayerList;
import models.entities.Character;
import models.entities.Player;
import models.items.Bullet;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

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
            //sys viewBullets
            if (Objects.equals(fields[1], "viewBullets")) {
                for (Bullet bullet : BulletList.getAll().values()) {
                    System.out.println(bullet);
                }
                return;
            }
            //If command is not found, print this:
            System.out.println("No such System command");
            return;
        }
        //Character (char)
        if (Objects.equals(fields[0], "char")) {
            Character character = getById(Integer.parseInt(fields[2]));
            //char getSkills *character ID*
            if (Objects.equals(fields[1], "getSkills")) {
                assert character != null;
                System.out.println(character.getSkills());
                return;
            }
            //char useSkill *user ID* *skill name* *target*
            if (Objects.equals(fields[1], "useSkill")) {
                assert character != null;
                character.getSkills().get(fields[3]).useAttack(PlayerList.get(fields[4]));
                return;
            }
            //char shootSkill *user ID* *skill name* *target ID*
            if (Objects.equals(fields[1], "shootSkill")) {
                assert character != null;
                if (character.getClass() != Player.class) {
                    System.out.println("Inputted user is not a Player.");
                    return;
                }
                character.getSkills().get(fields[3]).shootSkill(getById(Integer.parseInt(fields[4])));
                return;
            }
            //char viewMag *user ID*
            if (Objects.equals(fields[1], "viewMag")) {
                assert character != null;
                if (character.getClass() != Player.class) {
                    System.out.println("Inputted user is not a Player.");
                    return;
                }
                if (((Player) character).getLoadedMag().size() != 0) {
                    for (int i = 0; i < ((Player) character).getLoadedMag().size(); i++) {
                        System.out.println(i + "-" + ((Player) character).getLoadedMag().get(i));
                    }
                }
                if (((Player) character).getLoadedMag().size() == 0) System.out.println("Mag empty.");
                System.out.println(((Player) character).getMaxMag() + " max mag size");
                return;
            }
            //char reloadMag *user ID* *ids of bullets separated by commas)
            if (Objects.equals(fields[1], "reloadMag")) {
                String[] bulletIds = fields[3].split(",");
                ArrayList<Bullet> bullets = new ArrayList<>();
                for (String bulletId : bulletIds) {
                    bullets.add(BulletList.getById(Integer.parseInt(bulletId)));
                }
                assert character != null;
                ((Player) character).reloadMag(bullets);
                System.out.println(((Player) character).getLoadedMag());
                return;
            }
            //If command is not found, print this:
            System.out.println("No such Character command");
            return;
        }
        //If command is not found, print this:
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
