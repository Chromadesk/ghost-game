package data;

import models.entities.Player;
import java.util.HashMap;

public class PlayerList {

    private static final HashMap<String, Player> allPlayers = new HashMap<>() {
        {
            put("niitami", new Player("Niitami"));
        }
    };

    public static Player get(String key) {
        return allPlayers.get(key);
    }

    public static Player construct(String key) {
        Player player = allPlayers.get(key);
        return new Player(player.getName(), player.isPhysicalForm(), player.getHealth(), player.getResistance(),
                player.getElements(), player.getArmorPhysical(), player.getArmorCorporeal(), player.getSpeedBlock(),
                player.getSpeedAgility(), player.getSpeedMovement(), player.getActionPoints(), player.getSkills(),
                player.getItems(), player.getAmmo(), player.getMoney());
    }

}
