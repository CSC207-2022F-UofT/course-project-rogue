package usecase_event;

import entity.item.Equipment;
import entity.monster.Monster;
import entity.player.Player;
import interface_adapters.OutputBoundary;
import usecase_fight.DamageCalculator;
import usecase_fight.DropRetriever;
import usecase_fight.FightSummary;
import usecase_fight.WinCalculator;
import usecase_factories.MonsterFactory;

import java.util.Optional;
import java.util.Random;

public class FightEvent extends Event{
    public FightEvent(OutputBoundary outputBoundary){
        super(outputBoundary);
    }

    /**
     * Triggers a fight between Player and a Monster. Displays a summary of the following to the user:
     *      - Monster name and power
     *      - Possible damage to be taken
     *      - win chance
     *      - essence and equipment drops
     * and allows the user to choose to fight or run.
     *
     * @param player The Player that triggers the fight.
     */
    @Override
    public void trigger(Player player) {
        player.setFighting(true); // change Player state to fighting
        player.setCanMove(false); // change Player state to cant move

        Monster monster = this.randomMonster();
        FightSummary summary = this.createFight(player, monster);
        player.setFight(summary); // gives player current fight details
        this.displaySummary(summary);
    }

    /**
     * @return A random Monster from the database.
     */
    private Monster randomMonster(){
        Random random = new Random();
        int index = random.nextInt(4); // for now pick between the first 3 monsters
        return MonsterFactory.createRandom(index);
    }

    /**
     * Determines details of a fight between the given monster and player.
     *
     * @param player Player in the fight
     * @param monster Monster in the fight
     * @return A summary of the fight details
     */
    private FightSummary createFight(Player player, Monster monster){
        DamageCalculator damageCalculator = new DamageCalculator(monster, player);
        WinCalculator winCalculator = new WinCalculator(monster, player);
        DropRetriever dr = new DropRetriever();
        int winChance = winCalculator.calculate();
        int damage = damageCalculator.calculate();
        int essence = dr.getEssenceNum();

        Optional<Equipment> drop = dr.getEquipment();
        FightSummary summary;
        if (drop.isPresent()){
            Equipment equip = drop.get();
            summary = new FightSummary(monster, essence, winChance, damage, equip); // dependency injection here?
        } else{
            summary = new FightSummary(monster, essence, winChance, damage); // DI??
        }
        return summary;
    }

    /**
     * Displays the summary of the fight to the user.
     *
     * @param summary Summary of fight details.
     */
    private void displaySummary(FightSummary summary){
        Monster monster = summary.getMonster();
        String line1 = String.format("You encountered a %s", monster.toString());
        String line2 = String.format("Power: %s", this.getPowerString(monster));
        String line3 = String.format("Win chance: %d", summary.getWinChance()) + "%, "
                + String.format("Damage: %d", summary.getDamage());
        String line4 = String.format("Drops: %d essence,", summary.getAmountDrop()) +
                String.format(" %s", summary.getEquipment().toString());
        String line5 = "[F]Fight    or      [R]Run";
        // update view
    }


    /**
     * @param monster The Monster.
     * @return the string representation for the given Monsters power.
     */
    private String getPowerString(Monster monster){
        String power = "None";
        if (monster.isHasPower()){
            power = monster.getPower().toString();
        }
        return power;
    }


    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(Player player){
        return true;
    }
}
