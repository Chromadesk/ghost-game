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
        return new Player(player.getName(), player.isDefaultPhysicalForm(), player.getDefaultHealth(), player.getDefaultResistance(),
                player.getDefaultElements(), player.getDefaultArmorPhysical(), player.getDefaultArmorCorporeal(), player.getDefaultSpeedBlock(),
                player.getDefaultSpeedAgility(), player.getDefaultSpeedMovement(), player.getDefaultActionPoints(), player.getDefaultSkills(),
                player.getMoney(), player.getMaxMag(), player.getDefaultSoul());
    }

}
