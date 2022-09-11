package data;

import models.entities.Player;

import java.util.ArrayList;

public class PlayerList {

    private static final ArrayList<Player> allPlayers = new ArrayList<>() {
        {
            add(new Player("Niitami"));
        }
    };

    public static ArrayList<Player> getAll() {
        return allPlayers;
    }

    public static Player get(String name) {
        for(Player player : allPlayers) {
            if (name == player.getName()) {
                return player;
            }
        }
        throw new Error("Player not found.");
    }

}
