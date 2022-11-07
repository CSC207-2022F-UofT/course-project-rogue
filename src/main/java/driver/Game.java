package driver;
import user_interface.*;
public class Game {
    public void start_program(View_interface vi){
        vi.setFrameVisible(true);
    }
    public static void main(String[] args) {
        //Injecting interface into classes to create the structure of MVC
        View_interface vi = new View();
        Visual_interface visI = new Visual(vi);
        //observer interface here.....


        Game myGame = new Game();
        myGame.start_program(vi);
    }

}
