package usecase_heal_and_upgrade;

import Interface.InputBoundary_h_u;
import Interface.Visual_h_u;
import controller.Controller;
import entity.Collectible;
import entity.Equipment;
import entity.Player;
import presenter.Presenter_bottom;
import usecase_event.NoEvent;

import java.util.Observable;
import java.util.Observer;


public class healing_control implements Observer {
    private final Player player;
    private final Map map;

    public healing_control(Player player, Map map) {
        this.player = player;
        this.map = map;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (this.map.getEvent(this.player.getPlayerLocation()) instanceof NoEvent && arg == "H" || arg == "h") {
            heal();
        }
    }



    private int determine_Ess(){
        /*
          Determine the Essence required to do the healing. This method will return a non-negative integer.

          I will set the initial value as 1 here.In the future, I hope I can let the difficulty of the game decide the
          collectible items required for healing.

        */
        int i;
        i = 1;
        return i;
    }

    private int determine_Art(){
        /*
          Determine the Artifact required to do the healing. This method will return a non-negative integer.

          I will set the initial value as 1 here.In the future, I hope I can let the difficulty of the game decide the
          collectible items required for healing.

         */
        int i;
        i = 1;
        return i;
    }

    private boolean CheckFullHP(){
        return this.player.getMaxHitPoint() == this.player.getCurrHitPoint();
    }




    private void heal() {
        /*
          The basic part of the healing, it will return nothing but send message to presenter.
         */
        Visual_h_u speaker = new Presenter_bottom();
        if (CheckFullHP()) {
            speaker.Warn_FullHP();
            return;
        }
        InputBoundary_h_u input = new Controller();
        CollectibleUseManage ColHelper = new CollectibleUseManage(this.player, determine_Ess(), determine_Art(),
                "heal");
        ColHelper.ItemBroadcast();
        if (ColHelper.able) {
            speaker.keypress_request("Y", "N");
            if (input.get_decision()) {
                this.player.changeCurrHitPoint(player.getMaxHitPoint());
                ColHelper.spendCollectible();
                speaker.show_result("heal");
            } else {
                speaker.notifyGiveUp("heal");
            }
        }
    }
}