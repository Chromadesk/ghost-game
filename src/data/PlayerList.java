package data;

import models.Form;
import models.entities.Player;
import java.util.HashMap;

public class PlayerList {

    private static final HashMap<String, Player> allPlayers = new HashMap<>() {
        {
            put("Niitami", new Player("Niitami"));
        }
    };

    public static Player get(String name) {
        return allPlayers.get(name);
    }

}
