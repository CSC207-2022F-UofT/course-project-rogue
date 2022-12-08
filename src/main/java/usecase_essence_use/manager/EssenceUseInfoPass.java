package usecase_essence_use.manager;

import interface_adapters.OutputBoundary;

public abstract class EssenceUseInfoPass {
    protected static OutputBoundary outputBoundary;

    public static void setOutputBoundary(OutputBoundary outputBoundary){
        EssenceUseInfoPass.outputBoundary = outputBoundary;
    }
}
