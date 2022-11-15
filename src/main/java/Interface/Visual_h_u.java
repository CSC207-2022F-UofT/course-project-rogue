package Interface;

public interface Visual_h_u {
    /**
     *The method will be showed in the bottom text part. It will shows that the collectible items the player has verse
     * the collectible items the player need.
     * @param Essence_have the number of essence the player have
     * @param Essence_need the number of essence the player need
     * @param Artifact_have the number of essence the player need
     * @param Artifact_need the number of essence the player need
     * @param able_to_upgrade the number of essence the player need
     * @param verb heal or upgrade
     */
    void show_info(int Essence_have, int Essence_need, int Artifact_have, int Artifact_need,
                           boolean able_to_upgrade, String verb);
    //This method will be showed in the bottom text part of the game.
    //The window will show the numbers of collectible items the player have for the healing required.
    //And it will tell if the player can finish the healing action.

    /**
     * It will tell the player the system scan result.
     * @param Equipment the equipment player decide to upgrade.
     */
    void show_upgrade_choice(String Equipment);

    /**
     * It will tell the player that the update/heal success
     * @param type
     */
    void show_result(String type);

    /**
     * It will show the two keys that player can press for choice.
     * @param key1 first key to press
     * @param key2 second key to press
     */
    void keypress_request(String key1, String key2);

    /**
     * Tell player's HP is full, no need for heal
     */
    void Warn_FullHP();

    /**
     * Tell player's equipment is full, can not upgrade.
     */
    void Warn_MaxLv(String Equipment);

    /**
     * Tell player that he/she give up upgrade/heal
     * @param type upgrade/heal
     */
    void notifyGiveUp(String type);
}
