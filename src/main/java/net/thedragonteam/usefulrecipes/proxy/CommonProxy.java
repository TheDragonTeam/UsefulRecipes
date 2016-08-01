package net.thedragonteam.usefulrecipes.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thedragonteam.core.util.LogHelper;
import net.thedragonteam.usefulrecipes.UsefulRecipes;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        LogHelper.info("Finished PreInitialization");
    }

    public void init(FMLInitializationEvent event) {
        LogHelper.info("Finished Initialization");
    }

    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info("Finished PostInitialization");
    }

    public void loadCommands() {

    }

    public void loadRenders() {

    }

    public void addChatMessage(String string) {

    }

    /**
     * Sends a message to the client that gets replaced when the same messages are sent again. This reduces the amount of chat spam players end up with when checking things repeatedly.
     *
     * @param string - String message to send to player
     * @param id     - An ID for the message. Gets replaced by any other message that uses the same ID.
     */
    public void addChatMessage(String string, int id) {

    }

    public void registerRenderers(UsefulRecipes usefulrecipes) {
        // TODO Auto-generated method stub

    }
}