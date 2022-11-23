package usecase_heal_and_upgrade;

import Interface_heal_and_upgrade.VisualHealUpgrade;
import StringMaker_heal_and_upgrade.infoDisplay;
import entity.Equipment;
import entity.Player;

public class UpgradeInfo {

    private CollectibleUseManage CollectHelper;
    private Player player;
    private CalculatorCollectable Essenceneed;

    private CalculatorStat StatAdded;

    private Equipment equipment;

    private String EquipType;


    /**
     * Constructor of Heal info. This class will collect the information of player and determine how to heal
     * @param player
     */
    public UpgradeInfo(Player player, String EquipType){
        this.player = player;
        this.Essenceneed = new CalculatorCollectable();
        this.CollectHelper = new CollectibleUseManage(player, this.Essenceneed.EssenceForUpgrade());
        //do I need try/catch here
        this.equipment = player.getEquipment(EquipType);
        this.EquipType = EquipType;
        this.StatAdded = new CalculatorStat();
    }

    /**
     * Update the require HP of the player
     */
    private void UpgradeEquipUpdate(){
        this.equipment = player.getEquipment(this.EquipType);
    }


    /**
     * Update the heal infomation. The method must be called before the game print the heal summary.
     */
    public void UpgradeInfoUpdate(){
        UpgradeEquipUpdate();
    }

    /**
     * let the presenter print the information of heal
     */
    public void HealInfoPrint(){
        VisualHealUpgrade speaker = new infoDisplay();
        if (this.equipment.getTimesUpgraded() == 4){
            speaker.WarnMaxLv(this.EquipType);
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
        this.equipment.addStatValue(this.StatAdded.determineAdd());
    }
}
