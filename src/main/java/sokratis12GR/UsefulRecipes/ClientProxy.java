package sokratis12GR.UsefulRecipes;

import sokratis12GR.UsefulRecipes.registry.ModItems;

public class ClientProxy extends CommonProxy {
    @Override
    public void registerRenderers(UsefulRecipes ins) {
        ModItems.initModels();
    }
}
