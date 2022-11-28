package usecase_heal_and_upgrade;

import entity.item.Equipment;
import entity.player.Player;

public class UpgradeCalculator {

    private final CollectibleUseManager CollectHelper;
    private final Player player;
    private final CalculatorCollectible essenceNeed;

    private final CalculatorStat StatAdded;

    private Equipment equipment;

    private final String EquipType;


    /**
     * Constructor of Heal info. This class will collect the information of player and determine how to heal
     * @param player
     */
    public UpgradeCalculator(Player player, String equipType){
        this.player = player;
        this.essenceNeed = new CalculatorCollectible();
        this.CollectHelper = new CollectibleUseManager(player, this.essenceNeed.essenceForUpgrade());
        this.equipment = getEquipment(player , equipType);
        this.EquipType = equipType;
        this.StatAdded = new CalculatorStat();
    }

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
        VisualHealUpgrade speaker = new HealAndUpgradeInfoDisplay();
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
        this.CollectHelper.spendCollectible();
        this.equipment.addStatValue(this.StatAdded.determineAdd());
        this.equipment.getTimesUpgraded();
    }
}
