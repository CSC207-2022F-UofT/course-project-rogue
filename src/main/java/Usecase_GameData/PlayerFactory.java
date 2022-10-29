package Usecase_GameData;

import Entity.Player;

public class PlayerFactory {
    public Player getPlayer(int maxHP, int atkPT, Collectible essence, Collectible artifact, int x, int y){
        // I want to leave out Sword and Armor because if we were to have a class system we would be more
        // flexible on that. For example, have a new input of String class and for every class the factory
        // gets the starter equipment and items for that specific class and build the player.
        Equipment sword = new Equipment();
        Equipment armor = new Equipment();
        return new Player(maxHP, atkPT, essence, artifact, sword, armor, x, y);
    }
}
