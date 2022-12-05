package usecase_fight;

import interface_adapters.OutputBoundary;

/** A path in a fight: run away path, fight path, game over path, and after fight path. */
public abstract class FightPath {
    protected static OutputBoundary outputBoundary;

    public static void setOutputBoundary(OutputBoundary outputBoundary){
        FightPath.outputBoundary = outputBoundary;
    }

    public abstract void takePath();
}
