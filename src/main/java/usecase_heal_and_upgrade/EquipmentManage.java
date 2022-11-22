package usecase_heal_and_upgrade;

import entity.Equipment;

public class EquipmentManage {
    Equipment EquipmentSelected;
    public EquipmentManage(Equipment EquipmentSelected){
        this.EquipmentSelected = EquipmentSelected;
    }



    /**
     *
     * @return the number of collectible items needed for upgrading
     */
    public boolean checkMaxLv() {
        return this.EquipmentSelected.getTimesUpgraded() >=4;
    }

    public void StatsIncrease(int be_added){
        this.EquipmentSelected.addStatValue(be_added);
    }

}
