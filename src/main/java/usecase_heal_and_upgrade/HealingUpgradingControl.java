package usecase_heal_and_upgrade;

import entity.player.Player;

import java.util.Observable;

public class HealingUpgradingControl extends Observable {
    /**
     * Initialize the basic control class with no Observer
     */
    public HealingUpgradingControl(){

    }

    public final String[] DEFAULT = new String[]{"1","2","H","N"};

    /**
     * Initialize the actions choice of the player.
     * The basic Upgrade and Heal actions will be initialized.
     */
    public HealingUpgradingControl(Player player, HealUpgradeCalculator healUpgradeCalculator){
        this.setDefaultUP(player, healUpgradeCalculator.getHealManage(), healUpgradeCalculator.getWeaponUpgradeManage(),
                healUpgradeCalculator.getArmorUpgradeManage());
    }

    /**
     * Sets up the default  observer of Heal and Upgrade
     */
    private void setDefaultUP(Player player, HealCalculator HealManage, UpgradeCalculator WeaponUpgradeManage,
                              UpgradeCalculator ArmorUpgradeManage) {
        setHealUpgrade(player,HealManage, WeaponUpgradeManage, ArmorUpgradeManage, DEFAULT);
    }

    private void setHealUpgrade(Player player, HealCalculator HealManage, UpgradeCalculator WeaponUpgradeManage,
                                UpgradeCalculator ArmorUpgradeManage, String[] Command){
        this.addObserver(new Upgrader(player, WeaponUpgradeManage, Command[0]));
        this.addObserver(new Upgrader(player, ArmorUpgradeManage, Command[1]));
        this.addObserver(new Healer(player, HealManage, Command[2]));
        this.addObserver(new LeaveRestPoint(player,Command[3]));
    }
    /**
     * Notify observers with the command given.
     * @param s the command given
     */
    public void keyPressed(String s){
        this.setChanged();
        this.notifyObservers(s.toUpperCase());
    }


}
