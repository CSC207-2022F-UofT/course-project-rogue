package usecase_essence_use.manager;

import entity.player.Player;
import interface_adapters.OutputBoundary;

public class essenceUseSpeakerManager {
    private final OutputBoundary speaker;
    private final Player player;
    private final essenceUseManager essenceUseManager;

    public essenceUseSpeakerManager(Player player, essenceUseManager essenceUseManager, OutputBoundary speaker){
        this.player = player;
        this.essenceUseManager = essenceUseManager;
        this.speaker = speaker;
    }

    /**
     * make the string in the small menu for heal/upgrade about healing
     * @return heal info string
     */
    private String makeHealString(){
        healManager healManager= essenceUseManager.getHealManage();
        int HPToHeal = healManager.getHPToHeal();
        int HPRequired = healManager.getRequireHP();
        int essenceNeed = healManager.getEssenceNeed();
        if (!player.getCanHeal()){
            return "You have healed.";
        }
        if (HPRequired == 0){
            return "Your HP is full, no need for heal.";
        }
        if (HPRequired == HPToHeal){
            return String.format("You can heal to full HP by costing %d essence.", essenceNeed);
        }
        if (HPToHeal == 0){
            return "Your essence is not enough to heal";
        }
        return  String.format("You can heal part of your HP, %d of %d can be healed with %d essence cost", HPToHeal,
                HPRequired, essenceNeed);
    }

    /**
     * make the string in the small menu for upgrade about weapon upgrade
     * @return upgrade weapon info string
     */
    private String makeWeaponUpgradeString(){
        upgradeManager weaponUpgradeManage = essenceUseManager.getWeaponUpgradeManage();
        boolean able = weaponUpgradeManage.getAble();
        String EquipName = weaponUpgradeManage.getEquipment().getName();
        int EssenceCost = weaponUpgradeManage.getEssenceCost();
        int statIncrease = weaponUpgradeManage.getStatIncrease();
        if(able){
            return String.format("You don't enough essence to upgrade your %s", EquipName);
        }
        return String.format("You can cost %d essence to upgrade your %s, it will add %d attack point",
                EssenceCost, EquipName, statIncrease);
    }

    /**
     * make the string in the small menu for upgrade about armor upgrade
     * @return upgrade armor info string
     */
    private String makeArmorUpgradeString(){
        String EquipName = this.essenceUseManager.getArmorUpgradeManage().getEquipment().getName();
        upgradeManager armorUpgradeManager = this.essenceUseManager.getWeaponUpgradeManage();
        if(armorUpgradeManager.getAble()){
            return String.format("You don't enough essence to upgrade your %s", EquipName);
        }
        return String.format("You can cost %d essence to upgrade your %s, it will add %d defence point",
                armorUpgradeManager.getEssenceCost(), EquipName, armorUpgradeManager.getStatIncrease());
    }

    /**
     * make the string in the small menu for heal/upgrade about upgrade
     * @return upgrade info string
     */
    private String makeGeneralUpgradeString(){
        if (!player.getCanUpgrade()){
            return "You have upgraded! You can only upgrade once everytime";
        }
        String toReturn="";
        if(this.essenceUseManager.getWeaponUpgradeManage().getAble()){
            toReturn = toReturn.concat("Weapon can be upgraded. ");
        }
        if(this.essenceUseManager.getArmorUpgradeManage().getAble()){
            toReturn = toReturn.concat("Armor can be upgraded.");
        }
        if (toReturn.equals("")){
            toReturn = "You don't have enough essence for upgrade.";
        }
        return toReturn;
    }

    private String makeKeypressString(){
        String toReturn = "";
        if(this.essenceUseManager.getHealManage().getHPToHeal()!=0 &&
                this.essenceUseManager.getHealManage().getRequireHP() != 0 && this.player.getCanHeal()){
            toReturn = toReturn.concat("Press [H] for heal. ");
        }
        if (player.getCanUpgrade()){
            toReturn = toReturn.concat("Press [U] for weapon and armor upgrade infomation. ");
        }
        toReturn = toReturn.concat("Press [L] for leave");
        return toReturn;
    }

    public void showEssenceUseInfo(){
        if (player.getEssence().getNum() == 0){
            easterEggNothingCanBeDone();
            return;
        }
        if (!(player.getCanHeal()&& player.getCanUpgrade())){
            easterEggEverythingDone();
            return;
        }
        String healString = makeHealString();
        String UpgradeString = makeGeneralUpgradeString();
        String keypressRequestString = makeKeypressString();
        this.speaker.updateText(healString, UpgradeString , "" ,keypressRequestString);
    }

    public void showUpgradeSelectPage(){
        String weaponUpgradeString = makeWeaponUpgradeString();
        String armorUpgradeString = makeArmorUpgradeString();
        String line4 = "[N] for no and return to menu";
        speaker.updateText(weaponUpgradeString,armorUpgradeString,"",line4);
    }

    public void showVerifyPage(String verb){
        String line1 = String.format("Are you sure that you want to %s? ", verb.toLowerCase());
        String line2 = "";
        if (verb.equalsIgnoreCase("upgrade")){
            line2 = line2.concat("Notice: you can only upgrade one equipment.");
        }
        String line3 = String.format("[Y] for yes and %s", verb.toLowerCase());
        String line4 = "[N] for no and return to menu";
        speaker.updateText(line1, line2, line3, line4);
    }


    public void showSuccessPage(String verb){
        if(verb.equalsIgnoreCase("heal")){
            speaker.updateHp(player.getCurrHitPoint());
        }
        speaker.updateEssenceCnt(player.getEssence().getNum());
        String line1 = String.format("You have successfully %s", verb.toLowerCase());
        String line4 = "Please press [space] to continue";
        speaker.updateText(line1, "", "", line4);
    }

    private void easterEggNothingCanBeDone(){}

    private void easterEggEverythingDone(){}

    public void showEssenceUseEnd(){
        String line1 = "You leave the rest point";
        String line2 = "Good Luck!";
        speaker.updateText(line1,line2,"","");
    }

}
