package usecase_heal_and_upgrade;

import entity.Player;
import usecase_playeractions.Mover;

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
    public HealingUpgradingControl(Player player, HealInfo HealManage, UpgradeInfo WeaponUpgradeManage,
                                   UpgradeInfo ArmorUpgradeManage){
        this.setDefaultUP(player,HealManage, WeaponUpgradeManage, ArmorUpgradeManage);
    }

    /**
     * Sets up the default  observer of Heal and Upgrade
     */
    private void setDefaultUP(Player player, HealInfo HealManage, UpgradeInfo WeaponUpgradeManage,
                              UpgradeInfo ArmorUpgradeManage) {
        setHealUpgrade(player,HealManage, WeaponUpgradeManage, ArmorUpgradeManage, DEFAULT);
    }

    private void setHealUpgrade(Player player, HealInfo HealManage, UpgradeInfo WeaponUpgradeManage,
                                UpgradeInfo ArmorUpgradeManage, String[] Command){
        this.addObserver(new Upgrader(player, ArmorUpgradeManage, Command[0]));
        this.addObserver(new Upgrader(player, WeaponUpgradeManage, Command[1]));
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
