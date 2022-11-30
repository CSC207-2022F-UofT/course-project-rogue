package usecase_playeractions;


import entity.player.Player;
import usecase_event.Event;

/**
 * The Map that the player move on
 */
public class Map{
    private final int WIDTH = 15;
    private final int LENGTH = 15;
    private final Event[][] board;

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
            p.setLocation(0,x);
            p.setLocation(1,y);
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
        if(x>=WIDTH || y>=LENGTH){
            return false;
        } else return board[x][y] != null;
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