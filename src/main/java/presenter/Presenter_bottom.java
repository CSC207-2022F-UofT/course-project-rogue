package presenter;

import Interface.Visual_h_u;

public class Presenter_bottom implements Visual_h_u {

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
    @Override
    public void show_info(int Essence_have, int Essence_need, int Artifact_have, int Artifact_need,
                                  boolean able_to_upgrade, String verb) {
        String info;
        if (able_to_upgrade){
            info = String.format("You have Essence %d/%d. \n You have Artifact %d/%d. \n You can %s!",Essence_have,
                    Essence_need, Artifact_have, Artifact_need, verb);
        }
        else {
            info = String.format("You have Essence %d/%d. \n You have Artifact %d/%d. \n You don't have enough " +
                            "collections, try to get them!",Essence_have, Essence_need, Artifact_have, Artifact_need);
        }
        System.out.println(info);
    }

    /**
     * It will tell the player the system scan result.
     * @param Equipment the equipment player decide to upgrade.
     */
    @Override
    public void show_upgrade_choice(String Equipment) {
        String info;
        info = String.format("You decide to upgrade %s",Equipment);
        System.out.println(info);
    }

    /**
     * It will tell the player that the update/heal success
     * @param type
     */
    @Override
    public void show_result(String type) {
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
    public void keypress_request(String key1, String key2) {
        String info;
        info = String.format("Please press [%s]/[%s] and then press [Enter] for confirm", key1, key2);
        System.out.println(info);
    }

    /**
     * Tell player's HP is full, no need for heal
     */
    @Override
    public void Warn_FullHP() {
        String info = new String("Your HP is full, there are no need for healing.");
        System.out.println(info);
    }

    /**
     * Tell player's equipment is full, can not upgrade.
     */
    @Override
    public void Warn_MaxLv(String Equipment) {
        String info = String.format("Your %s is the highest level, you can not upgrade.", Equipment);
        System.out.println(info);
    }

}

