package entity.player;

public class States {
    private boolean canMove;
    private boolean canHeal;
    private boolean canUpgrade;
    private boolean isUpgrading;
    private boolean fighting;

    public States(){
        this.canMove = true;
        this.canHeal = false;
        this.canUpgrade = false;
        this.isUpgrading = false;
        this.fighting = false;
    }

    /**Sets whether if the player can Heal
     *
     * @param canHeal: True if player can Heal, else false
     */
    public void setCanHeal(boolean canHeal) {
        this.canHeal = canHeal;
    }

    /**Sets whether if the player can move
     *
     * @param canMove: True if player can move, else false
     */
    public void setCanMove(boolean canMove){
        this.canMove = canMove;
    }

    /**Sets whether if the player can Upgrade
     *
     * @param canUpgrade: True if player can Upgrade, else false
     */
    public void setCanUpgrade(boolean canUpgrade) {
        this.canUpgrade = canUpgrade;
    }

    /**Sets whether if the player is Fighting
     *
     * @param fighting: True if player is Fighting, else false
     */
    public void setFighting(boolean fighting) {
        this.fighting = fighting;
    }

    /**Sets whether if the player is upgrading
     *
     * @param upgrading: True if player is upgrading, else false
     */
    public void setUpgrading(boolean upgrading) {
        isUpgrading = upgrading;
    }

    /**
     * Changes all states to false.
     */
    public void setGameOver(){
        setCanHeal(false);
        setCanMove(false);
        setCanUpgrade(false);
        setUpgrading(false);
        setFighting(false);
    }

    /**Returns true if player can Heal
     *
     */
    public boolean getCanHeal() {
        return canHeal;
    }

    /**Returns true if player can Move
     *
     */
    public boolean getCanMove() {
        return canMove;
    }

    /**Returns true if player can Upgrade
     *
     */
    public boolean getCanUpgrade() {
        return canUpgrade;
    }

    /**Returns true if player is in a Fight
     *
     */
    public boolean getFighting() {
        return fighting;
    }

    /**Returns true if player is choosing between upgrade
     *
     */
    public boolean getUpgrading() {
        return isUpgrading;
    }

    /**
     * @return Whether Player is in a GameOver state. A Player is in a GameOverState if all states are false.
     */
    public boolean getGameOver() {
        return !(canMove && canHeal && canUpgrade && isUpgrading && fighting);
    }
}
