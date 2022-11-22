package StringMaker_heal_and_upgrade;

import Interface_heal_and_upgrade.VisualHealUpgrade;

public class infoDisplay implements VisualHealUpgrade {

    /**
     *The method will be showed in the bottom text part. It will shows that the collectible items the player has verse
     * the collectible items the player need.
     * @param EssenceHave the number of essence the player have
     * @param EssenceNeed the number of essence the player need
     * @param ArtifactHave the number of essence the player need
     * @param ArtifactNeed the number of essence the player need
     * @param ableToUpgrade the number of essence the player need
     * @param verb heal or upgrade
     */
    @Override
    public void showInfo(int EssenceHave, int EssenceNeed, int ArtifactHave, int ArtifactNeed,
                                  boolean ableToUpgrade, String verb) {
        String info;
        if (ableToUpgrade){
            info = String.format("You have Essence %d/%d. \n You have Artifact %d/%d. \n You can %s!",EssenceHave,
                    EssenceNeed, ArtifactHave, ArtifactNeed, verb);
        }
        else {
            info = String.format("You have Essence %d/%d. \n You have Artifact %d/%d. \n You don't have enough " +
                            "collections, try to get them!",EssenceHave, EssenceNeed, ArtifactHave, ArtifactNeed);
        }
        System.out.println(info);
    }

    /**
     * It will tell the player the system scan result.
     * @param Equipment the equipment player decide to upgrade.
     */
    @Override
    public void showUpgradeChoice(String Equipment) {
        String info;
        info = String.format("You decide to upgrade %s",Equipment);
        System.out.println(info);
    }

    /**
     * It will tell the player that the update/heal success
     * @param type
     */
    @Override
    public void showResult(String type) {
        String info;
        info = String.format("Congratulations! %s success!", type);
        System.out.println(info);
    }

    /**
     * It will show the two keys that player can press for choice.
     * @param key1 first key to press, without []
     * @param key2 second key to press, without []
     */
    @Override
    public void keypressRequest(String key1, String key2) {
        String info;
        info = String.format("Please press [%s]/[%s] and then press [Enter] for confirm", key1, key2);
        System.out.println(info);
    }

    /**
     * Tell player's HP is full, no need for heal
     */
    @Override
    public void WarnFullHP() {
        String info = new String("Your HP is full, there are no need for healing.");
        System.out.println(info);
    }

    /**
     * Tell player's equipment is full, can not upgrade.
     */
    @Override
    public void WarnMaxLv(String Equipment) {
        String info = String.format("Your %s is the highest level, you can not upgrade.", Equipment);
        System.out.println(info);
    }

    /**
     * Tell player that he/she give up upgrade/heal
     * @param type upgrade/heal
     */
    @Override
    public void notifyGiveUp(String type) {
        String info = String.format("You decide not to %s, good luck!", type);
        System.out.println(info);
    }

}

