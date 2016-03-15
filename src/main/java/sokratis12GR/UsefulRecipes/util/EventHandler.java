package sokratis12GR.UsefulRecipes.util;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sokratis12GR.UsefulRecipes.ConfigHandler;
import sokratis12GR.UsefulRecipes.UsefulRecipes;

public class EventHandler
{

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs)
	{
		if (eventArgs.modID.equals(UsefulRecipes.MODID))
		{
			ConfigHandler.syncConfig();
			UsefulRecipes.logger.info(TextHelper.localize("info." + UsefulRecipes.MODID + ".console.config.refresh"));
		}
	}
}