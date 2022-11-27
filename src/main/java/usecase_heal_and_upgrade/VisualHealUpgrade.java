package usecase_heal_and_upgrade;

public interface VisualHealUpgrade {
    /**
     *The method will be showed in the bottom text part. It will shows that the collectible items the player has verse
     * the collectible items the player need.
     * @param EssenceHave the number of essence the player have
     * @param EssenceNeed the number of essence the player need
     * @param ableToUpgrade the number of essence the player need
     * @param verb heal or upgrade
     */
    void showInfo(int EssenceHave, int EssenceNeed, boolean ableToUpgrade, String verb);
    //This method will be showed in the bottom text part of the game.
    //The window will show the numbers of collectible items the player have for the healing required.
    //And it will tell if the player can finish the healing action.

    /**
     * It will tell the player the system scan result.
     * @param Equipment the equipment player decide to upgrade.
     */
    void showUpgradeChoice(String Equipment);

    /**
     * It will tell the player that the update/heal success
     * @param type the string representing the result
     */
    void showResult(String type);

    /**
     * It will show the two keys that player can press for choice.
     * @param key1 first key to press
     * @param key2 second key to press
     */
    void keypressRequest(String key1, String key2);

    /**
     * Tell player's HP is full, no need for heal
     */
    void warnFullHP();

    /**
     * Tell player's equipment is full, can not upgrade.
     */
    void warnMaxLv(String Equipment);

    /**
     * Tell player that he/she give up upgrade/heal
     * @param type upgrade/heal
     */
    void notifyGiveUp(String type);
}
