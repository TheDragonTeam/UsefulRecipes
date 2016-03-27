package sokratis12GR.UsefulRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sokratis12GR.UsefulRecipes.util.TextHelper;

import java.io.File;

@Mod(modid = UsefulRecipes.MODID, name = UsefulRecipes.MODNAME, version = UsefulRecipes.VERSION, dependencies = UsefulRecipes.DEPEND, guiFactory = UsefulRecipes.GUIFACTORY, updateJSON =  "https://github.com/sokratis12GR/VersionUpdate/blob/gh-pages/UsefulRecipes.json")
public class UsefulRecipes
{

	public static final String MODNAME = "UsefulRecipes";
	public static final String MODID = "usefulrecipes";
	public static final String VERSION = "1.2";
	public static final String DEPEND = "";
	public static final String CLIENTPROXY = "sokratis12GR.UsefulRecipes.ClientProxy";
	public static final String COMMONPROXY = "sokratis12GR.UsefulRecipes.CommonProxy";
	public static final String GUIFACTORY = "sokratis12GR.UsefulRecipes.client.gui.ConfigGuiFactory";

	@SidedProxy(clientSide = UsefulRecipes.CLIENTPROXY, serverSide = UsefulRecipes.COMMONPROXY)
	public static CommonProxy proxy;
	public static Logger logger = LogManager.getLogger(UsefulRecipes.MODNAME);

	@Instance(MODID)
	public static UsefulRecipes instance;
	private static File configDir;

	public static File getConfigDir()
	{
		return configDir;
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		logger.info(TextHelper.localize("info." + UsefulRecipes.MODID + ".console.load.postInit"));
		MinecraftForge.EVENT_BUS.register(new GlobalEventsUsefulRecipes());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

	}

	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger.info(TextHelper.localize("info." + UsefulRecipes.MODID + ".console.load.preInit"));
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		configDir = new File(event.getModConfigurationDirectory() + "/" + UsefulRecipes.MODID);
		configDir.mkdirs();
		ConfigHandler.init(new File(configDir.getPath(), UsefulRecipes.MODID + ".cfg"));
		proxy.registerRenderers(this);
		if (ConfigHandler.Skull)
		{
			// Bones to Skull (Skeleton)
			GameRegistry.addRecipe(new ItemStack(Items.skull, 1), new Object[]
			{ "012", "3X5", "678", Character.valueOf('0'), new ItemStack(Items.bone, 1), Character.valueOf('1'),
					new ItemStack(Items.bone, 1), Character.valueOf('2'), new ItemStack(Items.bone, 1),
					Character.valueOf('3'), new ItemStack(Items.bone, 1), Character.valueOf('5'),
					new ItemStack(Items.bone, 1), Character.valueOf('6'), new ItemStack(Items.bone, 1),
					Character.valueOf('7'), new ItemStack(Items.bone, 1), Character.valueOf('8'),
					new ItemStack(Items.bone, 1), });
		}
		// Flesh to Skull (Zombie)
		GameRegistry.addRecipe(new ItemStack(Items.skull, 1, 2), new Object[]
		{ "012", "3X5", "678", Character.valueOf('0'), new ItemStack(Items.rotten_flesh, 1), Character.valueOf('1'),
				new ItemStack(Items.rotten_flesh, 1), Character.valueOf('2'), new ItemStack(Items.rotten_flesh, 1),
				Character.valueOf('3'), new ItemStack(Items.rotten_flesh, 1), Character.valueOf('5'),
				new ItemStack(Items.rotten_flesh, 1), Character.valueOf('6'), new ItemStack(Items.rotten_flesh, 1),
				Character.valueOf('7'), new ItemStack(Items.rotten_flesh, 1), Character.valueOf('8'),
				new ItemStack(Items.rotten_flesh, 1), Character.valueOf('4'), new ItemStack(Items.skull, 1), });

		// Gunpowder to Skull (Creeper)
		GameRegistry.addRecipe(new ItemStack(Items.skull, 1, 4), new Object[]
		{ "012", "3X5", "678", Character.valueOf('0'), new ItemStack(Items.gunpowder, 1), Character.valueOf('1'),
				new ItemStack(Items.gunpowder, 1), Character.valueOf('2'), new ItemStack(Items.gunpowder, 1),
				Character.valueOf('3'), new ItemStack(Items.gunpowder, 1), Character.valueOf('5'),
				new ItemStack(Items.gunpowder, 1), Character.valueOf('6'), new ItemStack(Items.gunpowder, 1),
				Character.valueOf('7'), new ItemStack(Items.gunpowder, 1), Character.valueOf('8'),
				new ItemStack(Items.gunpowder, 1), Character.valueOf('4'), new ItemStack(Items.skull, 1), });
		if (ConfigHandler.WitherSkull)
		{
			// Gunpowder to Skull (WitherSkeleton)
			GameRegistry.addRecipe(new ItemStack(Items.skull, 1, 1), new Object[]
			{ "012", "3X5", "678", Character.valueOf('0'), new ItemStack(Blocks.coal_block, 1), Character.valueOf('1'),
					new ItemStack(Blocks.coal_block, 1), Character.valueOf('2'), new ItemStack(Blocks.coal_block, 1),
					Character.valueOf('3'), new ItemStack(Blocks.coal_block, 1), Character.valueOf('5'),
					new ItemStack(Blocks.coal_block, 1), Character.valueOf('6'), new ItemStack(Blocks.coal_block, 1),
					Character.valueOf('7'), new ItemStack(Blocks.coal_block, 1), Character.valueOf('8'),
					new ItemStack(Blocks.coal_block, 1), Character.valueOf('4'), new ItemStack(Items.skull, 1), });
		}
		if (ConfigHandler.FasterGoldSmelting)
		{
			// Faster Gold Smelting
			GameRegistry.addRecipe(new ItemStack(Items.gold_ingot, 8), new Object[]
			{ "012", "3X5", "678", Character.valueOf('0'), new ItemStack(Blocks.gold_ore, 1), Character.valueOf('1'),
					new ItemStack(Blocks.gold_ore, 1), Character.valueOf('2'), new ItemStack(Blocks.gold_ore, 1),
					Character.valueOf('3'), new ItemStack(Blocks.gold_ore, 1), Character.valueOf('5'),
					new ItemStack(Blocks.gold_ore, 1), Character.valueOf('6'), new ItemStack(Blocks.gold_ore, 1),
					Character.valueOf('7'), new ItemStack(Blocks.gold_ore, 1), Character.valueOf('8'),
					new ItemStack(Blocks.gold_ore, 1), Character.valueOf('4'), new ItemStack(Items.coal, 1), });
		}
		if (ConfigHandler.FasterIronSmelting)
		{
			// Faster Iron Smelting
			GameRegistry.addRecipe(new ItemStack(Items.iron_ingot, 8), new Object[]
			{ "012", "3X5", "678", Character.valueOf('0'), new ItemStack(Blocks.iron_ore, 1), Character.valueOf('1'),
					new ItemStack(Blocks.iron_ore, 1), Character.valueOf('2'), new ItemStack(Blocks.iron_ore, 1),
					Character.valueOf('3'), new ItemStack(Blocks.iron_ore, 1), Character.valueOf('5'),
					new ItemStack(Blocks.iron_ore, 1), Character.valueOf('6'), new ItemStack(Blocks.iron_ore, 1),
					Character.valueOf('7'), new ItemStack(Blocks.iron_ore, 1), Character.valueOf('8'),
					new ItemStack(Blocks.iron_ore, 1), Character.valueOf('4'), new ItemStack(Items.coal, 1), });
		}
		if (ConfigHandler.Cobweb)
		{
			// Cobweb
			GameRegistry.addRecipe(new ItemStack(Blocks.web, 1), new Object[]
			{ "0X2", "X4X", "6X8", Character.valueOf('0'), new ItemStack(Items.string, 1), Character.valueOf('2'),
					new ItemStack(Items.string, 1), Character.valueOf('4'), new ItemStack(Items.string, 1),
					Character.valueOf('6'), new ItemStack(Items.string, 1), Character.valueOf('8'),
					new ItemStack(Items.string, 1), });
		}
		/*
		 * Shapeless Recipes
		 */
		if (ConfigHandler.DirtToGrass)
		{
			// Grass Block
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.grass, 1), new Object[]
			{ new ItemStack(Items.wheat_seeds, 1), new ItemStack(Blocks.dirt, 1), });
		}
		if (ConfigHandler.GravelToFlint)
		{
			// Gravel To Flint
			GameRegistry.addShapelessRecipe(new ItemStack(Items.flint, 1), new Object[]
			{ new ItemStack(Blocks.gravel, 1), new ItemStack(Blocks.gravel, 1), });
		}
		/*
		 * Saplings
		 */
		if (ConfigHandler.Saplings)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sapling, 1, 0), new Object[]
			{ new ItemStack(Blocks.leaves, 1, 0), new ItemStack(Items.stick, 1), });

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sapling, 1, 1), new Object[]
			{ new ItemStack(Blocks.leaves, 1, 1), new ItemStack(Items.stick, 1), });

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sapling, 1, 2), new Object[]
			{ new ItemStack(Blocks.leaves, 1, 2), new ItemStack(Items.stick, 1), });

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.sapling, 1, 3), new Object[]
			{ new ItemStack(Blocks.leaves, 1, 3), new ItemStack(Items.stick, 1), });
		}
		/*
		 * Slabs to Blocks
		 */

		// Wood Slabs to Blocks
		if (ConfigHandler.WoodenSlabsToPlanks)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 1, 0), new Object[]
			{ new ItemStack(Blocks.wooden_slab, 1, 0), new ItemStack(Blocks.wooden_slab, 1, 0), });

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 1, 1), new Object[]
			{ new ItemStack(Blocks.wooden_slab, 1, 1), new ItemStack(Blocks.wooden_slab, 1, 1), });

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 1, 2), new Object[]
			{ new ItemStack(Blocks.wooden_slab, 1, 2), new ItemStack(Blocks.wooden_slab, 1, 2), });

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 1, 3), new Object[]
			{ new ItemStack(Blocks.wooden_slab, 1, 3), new ItemStack(Blocks.wooden_slab, 1, 3), });
		}
		// Stone Types Slabs
		if (ConfigHandler.StoneSlabsToStone)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 1), new Object[]
			{ new ItemStack(Blocks.stone_slab, 1, 3), new ItemStack(Blocks.stone_slab, 1, 3), });

			GameRegistry.addShapelessRecipe(new ItemStack(Blocks.brick_block, 1), new Object[]
			{ new ItemStack(Blocks.stone_slab, 1, 4), new ItemStack(Blocks.stone_slab, 1, 4), });
		}
		// Wool To String
		if (ConfigHandler.WoolToString)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(Items.string, 4), new Object[]
			{ new ItemStack(Blocks.wool, 1), });
		}
		if (ConfigHandler.DiamondArmorToDiamond)
		{
			// Diamond Armor To Diamonds
			GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 5), new Object[]
			{ new ItemStack(Items.diamond_helmet, 1), });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 8), new Object[]
			{ new ItemStack(Items.diamond_chestplate, 1), });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 7), new Object[]
			{ new ItemStack(Items.diamond_leggings, 1), });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 4), new Object[]
			{ new ItemStack(Items.diamond_boots, 1), });
		}
		if (ConfigHandler.IronArmorToIron)
		{
			// Iron Armor To Iron
			GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 5), new Object[]
			{ new ItemStack(Items.iron_helmet, 1), });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 8), new Object[]
			{ new ItemStack(Items.iron_chestplate, 1), });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 7), new Object[]
			{ new ItemStack(Items.iron_leggings, 1), });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 4), new Object[]
			{ new ItemStack(Items.iron_boots, 1), });
		}
		if (ConfigHandler.GoldArmorToGold)
		{
			// Gold Armor To Gold
			GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 5), new Object[]
			{ new ItemStack(Items.golden_helmet, 1), });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 8), new Object[]
			{ new ItemStack(Items.golden_chestplate, 1), });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 7), new Object[]
			{ new ItemStack(Items.golden_leggings, 1), });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 4), new Object[]
			{ new ItemStack(Items.golden_boots, 1), });
		}
		if (ConfigHandler.LeatherArmorToLeather)
		{
			// Leather Armor To Leather
			GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 5), new Object[]
					{ new ItemStack(Items.leather_helmet, 1), });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 8), new Object[]
					{ new ItemStack(Items.leather_chestplate, 1), });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 7), new Object[]
					{ new ItemStack(Items.leather_leggings, 1), });
			GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 4), new Object[]
					{ new ItemStack(Items.leather_boots, 1), });
		}
		/*
		 * Smelting Recipes
		 */
		if (ConfigHandler.FleshToBeef)
		{
			// Flesh To Beef
			GameRegistry.addSmelting(Items.rotten_flesh, new ItemStack(Items.beef), 0.5F);
		}
		if (ConfigHandler.PoisonPotatoSmelting)
		{
			// Poison Potato Smelting
			GameRegistry.addSmelting(Items.potato, new ItemStack(Items.baked_potato), 0.5F);
		}
	}

	public static class GuiHandler implements IGuiHandler
	{
		@Override
		public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
		{
			return null;
		}

		@Override
		public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
		{
			return null;
		}
	}

}
