package usecase_fight;

import entity.Armor;
import entity.Equipment;
import entity.Monster.Monster;
import entity.Monster.MonsterPower;
import entity.Player;
import entity.Weapon;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/** A fight sequence. */
public class Fighter implements Observer {
    private final Player player;
    /** Keystroke that triggers this use case. */
    private final String trigger; // 'F'

    /** Creates a new Fighter with the given Player and trigger. */
    public Fighter(Player player, String trigger){
        this.player = player;
        this.trigger = trigger;
    }

    /** Helper method - get the summary of the fight a player is in. */
    private FightSummary getSummary(){
        return this.player.getFight();
    }


    /**
     * @return True iff Player wins the fight. False otherwise.
     *
     * @param summary Holds the win chance of Player.
     */
    private boolean determineWin(FightSummary summary){
        Random rand = new Random();
        int chance = summary.getWinChance();
        if (chance == 0){
            return false;
        }
        return (rand.nextInt(100) + 1) <= chance; // pick a number between 1 - 100.
    }

    /**
     * @param monster The Monster.
     * @param win The result of the fight.
     * @return The result of Monster using a power. Returns empty string if Monster does not have a Power.
     */
    private String getPowerResult(Monster monster, boolean win){
        String result = "";
        if (monster.isHasPower()) {
            MonsterPower power = monster.getPower();
            if (power.isMustBeat()) { // if you need to beat the monster
                if (win) { // use power if we beat the monster
                    result = power.usePower(player);
                }
            } else { // monster needs to be alive to use power
                if (!win) {
                    result = power.usePower(player);
                }
            }
        }
        return result;
    }

    /**
     * Inflict damage from the fight to Player. If Player won the fight, then only half damage is inflicted.
     *
     * @param summary holds the amount of damage the Player can take.
     */
    private void inflictDamage(FightSummary summary){
        int damage = summary.getDamage();
        this.player.changeCurrHitPoint(-damage);
    }

    /**
     * Checks if Player has died.
     *
     * @return True iff Player has 0 current hit point.
     */
    private boolean checkGameOver(){
        return this.player.getCurrHitPoint() == 0;
    }


    /**
     * Adds the amount of dropped essence to Player inventory.
     *
     * @param summary Holds the amount of essence dropped.
     */
    private void acceptEssence(FightSummary summary){
        int toAdd = summary.getAmountDrop();
        this.player.changeEssenceAmount(toAdd);
    }

    /**
     * Exchanges Player's Weapon/Armor with the dropped Weapon/Armor iff the dropped Equipment has higher stats than
     * Player's current Equipment.
     *
     * @param summary The summary of the fight details.
     * @return true iff Player's Equipment is exchanged.
     */
    private boolean acceptEquipment(FightSummary summary){
        Equipment equip = summary.getEquipment();
        if (equip instanceof Weapon){
            // if current weapon is weaker than dropped, replace
            if (player.getEquipment("Weapon").compareTo(equip) < 0){
                player.setEquipment((Weapon) equip);
                return true;
            }
            return false;
        } else if (equip instanceof Armor) {
            if (player.getEquipment("Armor").compareTo(equip) < 0){
                player.setEquipment((Armor) equip);
                return true;
            }
            return false;
        }
        return false; // this is just here so that if the equipment is neither, it doesn't get included in string
    }

    /**
     * Executes a fight. If Player wins the fight, then Player takes reduced damage and receives the drops from the
     * fight. If the Player loses, Player takes full damage and receives no rewards.
     */
    private void fight(){
        FightSummary summary = this.getSummary();
        Monster monster = summary.getMonster();
        boolean win = this.determineWin(summary);
        String powerResult = this.getPowerResult(monster, win);
        if (win){
            this.acceptEssence(summary);
            boolean exchange = this.acceptEquipment(summary);
            this.displayResults(powerResult, summary.getAmountDrop(), exchange, summary.getEquipment());
        } else {
            this.inflictDamage(summary);
            if (this.checkGameOver()){
                this.player.setGameOver();
                this.displayResults();
            } else {
                this.displayResults(powerResult, summary.getDamage());
            }
        }
    }

    /**
     * Display the win results of the fight to the user.
     *
     * @param powerResult Result of Monster using its Power.
     * @param essence The number of essence received
     * @param exchange Whether Equipment drop was exchanged with current.
     * @param equipment Equipment to be dropped.
     */
    private void displayResults(String powerResult, int essence, boolean exchange, Equipment equipment){
        String received;
        if (exchange) { // if exchanged equipment, show equipment gained
            received = String.format("%d essence, %s", essence, equipment);
        } else { // if not, equipment not gained
            received = String.format("%d essence", essence);
        }

        String line1 = "You won!" + powerResult;
        String line2 = "Damage Taken: 0";
        String line3 = "Items Received: " + received;
        String line5 = "Press [SpaceBar] to continue."; // not sure if space bar or a different key

        // call presenter where line 4 arg is empty string.
    }

    /**
     * Display the losing results to user.
     *
     * @param powerResult The result of Monster using its Power
     * @param dmg The damage taken by Player
     */
    private void displayResults(String powerResult, int dmg){
        String line1 = "You lost." + powerResult;
        String line2 = String.format("Damage Taken: %d", dmg);
        String line3 = "Items Received: None";
        String line5 = "Press [SpaceBar] to continue.";
        // call presenter where line 4 arg is empty string.
    }

    /**
     * Display game over results to Player.
     */
    private void displayResults(){
        // call a presenter to change to a game over screen
    }


    /** Execute a fight if the key input from the user matches trigger and Player is in a fight. */
    @Override
    public void update(Observable o, Object arg) {
        if(player.getFighting() && trigger.equals(arg)){
            this.fight();
        }
    }
}
