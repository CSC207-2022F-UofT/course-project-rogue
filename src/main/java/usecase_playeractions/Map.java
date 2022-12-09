package usecase_playeractions;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import entity.player.Player;
import file_reader.deserialization.MapDeserialization;
import interface_adapters.OutputBoundary;
import usecase_event.Event;

/**
 * The Map that the player move on
 */

@JsonDeserialize(using = MapDeserialization.class)
public class Map{
    private static final int WIDTH = 15;
    private static final int LENGTH = 15;
    private final Event[][] board;

    private static OutputBoundary outputBoundary;

    /**
     * Initialize an empty Map.
     */
    public Map(){
        board = new Event[WIDTH][LENGTH];
    }

    /**
     * place e at point (x,y) on the board
     * @param e The Event.
     * @param x x coordinate.
     * @param y y coordinate.
     **/
    public void setBoard(Event e,int x, int y){
        board[x][y] = e;
    }

    public static void setOutputBoundary(OutputBoundary output){
        Map.outputBoundary = output;
    }

    public String[][] getStringBoard(){
        String[][] map = new String[WIDTH][LENGTH];
        for(int i = 0; i < WIDTH; i++){
            for(int o = 0; o < LENGTH; o++){
                 map[i][o] = this.board[i][o].toString();
            }
        }
        return map;
    }

    /**
     * Attempts to move the player to (x,y).
     * Return false if (x,y) is unreachable(e.g. is a wall)
     *, then place the player on that tile
     *, triggers the event on that tile, and return True.
     * @param p the player.
     * @param x The x coordinate to move to.
     * @param y The y coordinate to move to.
     * @return true if the move is successful, false otherwise
     */
    private boolean moveTo(Player p,int x,int y){
        if(board[x][y].enter(p)){
            board[x][y].trigger(p);
            p.setLocation(x,y);
            outputBoundary.updatePlayerLocation(new int[]{x,y});
            return true;
        }else{
            return false;
        }
    }

    /**
     * Check if (x,y) is on the board and not null
     * @return true if (x,y) is an Event.
     */
    private boolean onBoard(int x,int y){
        if(x<WIDTH && 0 <= x && 0 <= y && y<LENGTH){
            return board[x][y] != null;
        } else {
            return false;
    }
    }

    /**
     * suppose player is at (a,b),
     * attempts to move the player to (a+x,b+y).
     * Return false if (a+x,b+y) is unreachable(e.g. is a wall)
     *, then place the player on that tile
     *, triggers the event on that tile, and return True.
     * @param p The player to move.
     * @param x Change in x coordinate when moved.
     * @param y Change in y coordinate when moved.
     * @return true if the move is successful, false otherwise.
     */
    public boolean move(Player p,int x, int y){
        int[] location = p.getPlayerLocation();
        if(onBoard(location[0]+x,location[1]+y)){
            return moveTo(p,location[0]+x,location[1]+y);
        }else{
            return false;
        }

    }

}