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
		System.out.println("t");
		if (eventArgs.getModID().equals(UsefulRecipes.MODID))
		{
			System.out.println("a");
			ConfigHandler.syncConfig();
			UsefulRecipes.logger.info(TextHelper.localize("info." + UsefulRecipes.MODID + ".console.config.refresh"));
		}
	}
}