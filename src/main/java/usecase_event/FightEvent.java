package usecase_event;

import entity.item.Equipment;
import entity.monster.Monster;
import entity.player.Player;
import usecase_fight.DamageCalculator;
import usecase_fight.DropRetriever;
import usecase_fight.FightSummary;
import usecase_fight.WinCalculator;
import usecase_factories.EquipmentFactory;
import usecase_factories.MonsterFactory;

import java.util.Optional;
import java.util.Random;

public class FightEvent extends Event{

    private final MonsterFactory mf;
    private final EquipmentFactory ef;

    public FightEvent(){
        this.mf = new MonsterFactory();
        this.ef = new EquipmentFactory();
    }

    /**
     * Triggers a fight between Player and a Monster which displays a summary of the following to the user:
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
        String[] output = summary.getSummary();
        outputBoundary.updateText(output[0], output[1], output[2], "[F]Fight or [R]Run");
    }

    /**
     * @return A random Monster from the database.
     */
    private Monster randomMonster(){
        Random random = new Random();
        int index = random.nextInt(6);
        return mf.create(index);
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
        DropRetriever dr = new DropRetriever(ef);
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


    /** Tells Map whether this tile could be stepped on by Player
     *
     * @return True if player can step on it, false if it can's
     */
    @Override
    public boolean enter(Player player){
        return true;
    }

    @Override
    public String toString() {
        return "FightEvent";
    }
}
