package presenter;

import Interface.Visual;

public class Presenter_bottom implements Visual{

    @Override
    public void show_upgrade_info(String Text) {
        System.out.println("******Upgrading******");
        System.out.println(Text);
    }

    @Override
    public void show_heal_info(String Text) {
        System.out.println("******Healing Yourself******");
        System.out.println(Text);
    }
}

