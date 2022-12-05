package usecase_essence_use.upgrade;

import entity.item.Equipment;
import entity.player.Player;
import usecase_essence_use.EssenceUseInfoDisplay;
import usecase_essence_use.VisualHealUpgrade;
import usecase_essence_use.data_calculator.CalculatorCollectible;
import usecase_essence_use.data_calculator.CalculatorStat;
import usecase_essence_use.data_calculator.CollectibleUseManager;

public class UpgradeCalculator {

    private final CollectibleUseManager CollectHelper;
    private final Player player;
    private final CalculatorCollectible essenceNeed;

    private final CalculatorStat StatAdded;

    private Equipment equipment;

    private final String EquipType;


    /**
     * Constructor of Heal info. This class will collect the information of player and determine how to heal
     * @param player the player of the game
     */
    public UpgradeCalculator(Player player, String equipType){
        this.player = player;
        this.essenceNeed = new CalculatorCollectible();
        this.CollectHelper = new CollectibleUseManager(player, this.essenceNeed.essenceForUpgrade());
        this.equipment = getEquipment(player , equipType);
        this.EquipType = equipType;
        this.StatAdded = new CalculatorStat();
    }

    /**
     * Gets the Equipment from Player based on the Type
     * @param player: player who stepped on the tile
     * @param equipType: The type of equipment they want to upgrade
     * @return Equipment class which the player is currently equipping
     */

    private Equipment getEquipment(Player player, String equipType){
        if (equipType.equals("Weapon")){
            return player.getWeapon();
        } else if (equipType.equals("Armor")) {
            return player.getArmor();
        }
        return null;
    }

    /**
     * Update the current HP of the player
     */
    private void UpgradeEquipUpdate(){
        this.equipment = getEquipment(player, this.EquipType);
    }


    /**
     * Update heal infomation. The method must be called before the game print heal summary.
     */
    public void UpgradeInfoUpdate(){
        UpgradeEquipUpdate();
    }

    /**
     * let the presenter print the information of heal
     */
    public void HealInfoPrint(){
        VisualHealUpgrade speaker = new EssenceUseInfoDisplay();
        if (this.equipment.getTimesUpgraded() == 4){
            speaker.warnMaxLv(this.EquipType);
            return;
        }
        if(!this.CollectHelper.getAble()){
            speaker.showInfo(CollectHelper.getEssenceNum(), CollectHelper.getEssenceNeed(), false,
                    String.format("update the %s",this.EquipType));
            return;
        }
        speaker.showInfo(CollectHelper.getEssenceNum(), CollectHelper.getEssenceNeed(), true,
                String.format("update the %s",this.EquipType));
    }

    public void upgrade(){
        if (CollectHelper.getAble()) {
            this.CollectHelper.spendCollectible();
            this.equipment.addStatValue(this.StatAdded.determineAdd());
            this.equipment.addTimesUpgraded(1);
        }
    }
}
