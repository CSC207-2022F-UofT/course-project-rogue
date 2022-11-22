package usecase_fight;

import entity.monster.Monster;
import entity.Player;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class Runner implements Observer {

    private final Player player;
    private final String trigger; // "R"
    public Runner(Player player, String trigger){
        this.player = player;
        this.trigger = trigger;
    }
    public String flee(){
        player.setFighting(false);
        player.setCanMove(true);

        Monster monster = player.getFight().getMonster();
        Random rand = new Random();
        boolean success = rand.nextBoolean();
        if (success){
            return "You got away safely!";
        } else{
            double dmg = player.getFight().getDamage() * 0.05;
            int fleeDmg = (int) Math.round(dmg * 0.05);
            return String.format("%s hit you as you ran away. Took %d damage.", monster, fleeDmg);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(player.getFighting() && trigger.equals(arg)){
            String result = this.flee();
            // call presenter to change text with line1 being result
        }
    }
}
