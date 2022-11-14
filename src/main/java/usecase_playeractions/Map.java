package usecase_playeractions;


import entity.Player;
import usecase_event.Event;

/**
 * The Map that the player move on
 */
public class Map{
    private final int WIDTH = 15;
    private final int LENGTH = 15;
    private final Event[][] board;

    public Map(){
        board = new Event[WIDTH][LENGTH];
    }

    /**
     * place e at point (x,y) on the board
     **/
    public void setBoard(Event e,int x, int y){
        board[x][y] = e;
    }

    /**
     * Attempts to move the player to (x,y).
     * Return false if (x,y) is unreachable(e.g. is a wall)
     *, then place the player on that tile
     *, triggers the event on that tile, and return True.
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
     * @return true if (x,y) is an Event
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
     * @return true if the move is successful, false otherwise
     */
    public boolean move(Player p,int x, int y){
        int[] location = p.getPlayerLocation();

        if(onBoard(location[0],location[1])){
            return moveTo(p,location[0]+x,location[1]+y);
        }else{
            return false;
        }

    }

}