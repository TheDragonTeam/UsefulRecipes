package sokratis12GR.UsefulRecipes.client.gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;
import sokratis12GR.UsefulRecipes.resources.ConfigHandler;
import sokratis12GR.UsefulRecipes.UsefulRecipes;
import sokratis12GR.UsefulRecipes.util.TextHelper;

public class ConfigGui extends GuiConfig
{
	public ConfigGui(GuiScreen parentScreen)
	{
		super(parentScreen, getConfigElements(parentScreen), UsefulRecipes.MODID, false, true,
				TextHelper.localize("gui." + UsefulRecipes.MODID + ".config.title"));
	}

	private static List<IConfigElement> getConfigElements(GuiScreen parent)
	{
		List<IConfigElement> list = new ArrayList<IConfigElement>();

		// adds sections declared in ConfigHandler. toLowerCase() is used because the configuration class automatically does this, so must we.
		list.add(new ConfigElement(ConfigHandler.config.getCategory("Crafting".toLowerCase())));
		list.add(new ConfigElement(ConfigHandler.config.getCategory("Smelting".toLowerCase())));
		
		return list;
	}
}