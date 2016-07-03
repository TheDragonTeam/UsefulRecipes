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
import sokratis12GR.UsefulRecipes.registry.ModItems;
import sokratis12GR.UsefulRecipes.resources.ConfigHandler;
import sokratis12GR.UsefulRecipes.resources.GlobalEventsUsefulRecipes;
import sokratis12GR.UsefulRecipes.util.TextHelper;

import java.io.File;

@Mod(modid = UsefulRecipes.MODID, name = UsefulRecipes.MODNAME, version = UsefulRecipes.VERSION, acceptedMinecraftVersions = "[1.9.4,1.10)", dependencies = UsefulRecipes.DEPEND, guiFactory = UsefulRecipes.GUIFACTORY, updateJSON = "https://github.com/sokratis12GR/VersionUpdate/blob/gh-pages/UsefulRecipes.json")
public class UsefulRecipes {

    public static final String MODNAME = "UsefulRecipes";
    public static final String MODID = "usefulrecipes";
    public static final String VERSION = "1.9.4-2.0.0.0";
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

    public static File getConfigDir() {
        return configDir;
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info(TextHelper.localize("info." + UsefulRecipes.MODID + ".console.load.postInit"));
        MinecraftForge.EVENT_BUS.register(new GlobalEventsUsefulRecipes());
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.init();
        logger.info(TextHelper.localize("info." + UsefulRecipes.MODID + ".console.load.preInit"));
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        configDir = new File(event.getModConfigurationDirectory() + "/" + "sokratis12GR's Mods" + "/" + UsefulRecipes.MODID);
        configDir.mkdirs();
        ConfigHandler.init(new File(configDir.getPath(), UsefulRecipes.MODID + ".cfg"));
        proxy.registerRenderers(this);

        if (ConfigHandler.Skull) {
            // Bones to Skull (Skeleton)
            GameRegistry.addRecipe(new ItemStack(Items.SKULL, 1), "BBB", "BXB", "BBB", 'B', new ItemStack(Items.BONE, 1));
        }
        // Flesh to Skull (Zombie)
        GameRegistry.addRecipe(new ItemStack(Items.SKULL, 1, 2), "RRR", "RSR", "RRR", 'R', new ItemStack(Items.ROTTEN_FLESH, 1), 'S', new ItemStack(Items.SKULL, 1));
        // Gunpowder to Skull (Creeper)
        GameRegistry.addRecipe(new ItemStack(Items.SKULL, 1, 4), "GGG", "GSG", "GGG", 'G', new ItemStack(Items.GUNPOWDER, 1), 'S', new ItemStack(Items.SKULL, 1));

        if (ConfigHandler.WitherSkull) {
            // Gunpowder to Skull (WitherSkeleton)
            GameRegistry.addRecipe(new ItemStack(Items.SKULL, 1, 1), "CCC", "CSC", "CCC", 'C', new ItemStack(Blocks.COAL_BLOCK, 1), 'S', new ItemStack(Items.SKULL, 1));
        }
        if (ConfigHandler.FasterGoldSmelting) {
            // Faster Gold Smelting
            GameRegistry.addRecipe(new ItemStack(Items.GOLD_INGOT, 8), "GGG", "GCG", "GGG", 'G', new ItemStack(Blocks.GOLD_ORE, 1), 'C', new ItemStack(Items.COAL, 1));
        }
        if (ConfigHandler.FasterIronSmelting) {
            // Faster Iron Smelting
            GameRegistry.addRecipe(new ItemStack(Items.IRON_INGOT, 8), "III", "ICI", "III", 'I', new ItemStack(Blocks.IRON_ORE, 1), 'C', new ItemStack(Items.COAL, 1));
        }
        if (ConfigHandler.Cobweb) {
            // Cobweb
            GameRegistry.addRecipe(new ItemStack(Blocks.WEB, 1), "SXS", "XSX", "SXS", 'S', new ItemStack(Items.STRING, 1));
        }
        if (ConfigHandler.NetherStarFragmentRecipe) {
            /** Nether Star Fragment Recipe */
            GameRegistry.addRecipe(new ItemStack(ModItems.NETHER_STAR_FRAGMENT, 1), "WWW", "SSS", "DSB", 'W', new ItemStack(Items.SKULL, 1, 1), 'S', new ItemStack(Blocks.SOUL_SAND, 1), 'D', new ItemStack(Items.DIAMOND_SWORD, 1), 'B', new ItemStack(Items.BOW, 1));
            /** Nether Star Recipe */
            GameRegistry.addShapelessRecipe(new ItemStack(Items.NETHER_STAR, 1), new ItemStack(ModItems.NETHER_STAR_FRAGMENT, 1), new ItemStack(ModItems.NETHER_STAR_FRAGMENT, 1), new ItemStack(ModItems.NETHER_STAR_FRAGMENT, 1), new ItemStack(ModItems.NETHER_STAR_FRAGMENT, 1));
        }
        if (!ConfigHandler.NetherStarFragmentRecipe) {
            /** Nether Star Recipe */
            GameRegistry.addRecipe(new ItemStack(Items.NETHER_STAR, 1), "WWW", "SSS", "DSB", 'W', new ItemStack(Items.SKULL, 1, 1), 'S', new ItemStack(Blocks.SOUL_SAND, 1), 'D', new ItemStack(Items.DIAMOND_SWORD, 1), 'B', new ItemStack(Items.BOW, 1));
        }
        /**
         * Shapeless Recipes
         */
        if (ConfigHandler.DirtToGrass)

        {
            // Grass Block
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.GRASS, 1), new ItemStack(Items.WHEAT_SEEDS, 1), new ItemStack(Blocks.DIRT, 1));
        }

        if (ConfigHandler.GravelToFlint)

        {
            // Gravel To Flint
            GameRegistry.addShapelessRecipe(new ItemStack(Items.FLINT, 1), new ItemStack(Blocks.GRAVEL, 1), new ItemStack(Blocks.GRAVEL, 1));
        }
        /**
         * Saplings
         */
        if (ConfigHandler.Saplings)

        {
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.SAPLING, 1, 0), new ItemStack(Blocks.LEAVES, 1, 0), new ItemStack(Items.STICK, 1));

            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.SAPLING, 1, 1), new ItemStack(Blocks.LEAVES, 1, 1), new ItemStack(Items.STICK, 1));

            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.SAPLING, 1, 2), new ItemStack(Blocks.LEAVES, 1, 2), new ItemStack(Items.STICK, 1));

            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.SAPLING, 1, 3), new ItemStack(Blocks.LEAVES, 1, 3), new ItemStack(Items.STICK, 1));
        }
        /**
         * Slabs to Blocks
         */

        // Wood Slabs to Blocks
        if (ConfigHandler.WoodenSlabsToPlanks)

        {
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 1, 0), new ItemStack(Blocks.WOODEN_SLAB, 1, 0), new ItemStack(Blocks.WOODEN_SLAB, 1, 0));

            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 1, 1), new ItemStack(Blocks.WOODEN_SLAB, 1, 1), new ItemStack(Blocks.WOODEN_SLAB, 1, 1));

            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 1, 2), new ItemStack(Blocks.WOODEN_SLAB, 1, 2), new ItemStack(Blocks.WOODEN_SLAB, 1, 2));

            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.PLANKS, 1, 3), new ItemStack(Blocks.WOODEN_SLAB, 1, 3), new ItemStack(Blocks.WOODEN_SLAB, 1, 3));
        }
        // Stone Types Slabs
        if (ConfigHandler.StoneSlabsToStone)

        {
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.COBBLESTONE, 1), new ItemStack(Blocks.STONE_SLAB, 1, 3), new ItemStack(Blocks.STONE_SLAB, 1, 3));

            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.BRICK_BLOCK, 1), new ItemStack(Blocks.STONE_SLAB, 1, 4), new ItemStack(Blocks.STONE_SLAB, 1, 4));
        }
        // Wool To String
        if (ConfigHandler.WoolToString)

        {
            GameRegistry.addShapelessRecipe(new ItemStack(Items.STRING, 4), new ItemStack(Blocks.WOOL, 1));
        }

        if (ConfigHandler.DiamondArmorToDiamond)

        {
            // Diamond Armor To Diamonds
            GameRegistry.addShapelessRecipe(new ItemStack(Items.DIAMOND, 5), new ItemStack(Items.DIAMOND_HELMET, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.DIAMOND, 8), new ItemStack(Items.DIAMOND_CHESTPLATE, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.DIAMOND, 7), new ItemStack(Items.DIAMOND_LEGGINGS, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.DIAMOND, 4), new ItemStack(Items.DIAMOND_BOOTS, 1));
        }

        if (ConfigHandler.IronArmorToIron)

        {
            // Iron Armor To Iron
            GameRegistry.addShapelessRecipe(new ItemStack(Items.IRON_INGOT, 5), new ItemStack(Items.IRON_HELMET, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.IRON_INGOT, 8), new ItemStack(Items.IRON_CHESTPLATE, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.IRON_INGOT, 7), new ItemStack(Items.IRON_LEGGINGS, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.IRON_INGOT, 4), new ItemStack(Items.IRON_BOOTS, 1));
        }

        if (ConfigHandler.GoldArmorToGold)

        {
            // Gold Armor To Gold
            GameRegistry.addShapelessRecipe(new ItemStack(Items.GOLD_INGOT, 5), new ItemStack(Items.GOLDEN_HELMET, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.GOLD_INGOT, 8), new ItemStack(Items.GOLDEN_CHESTPLATE, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.GOLD_INGOT, 7), new ItemStack(Items.GOLDEN_LEGGINGS, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.GOLD_INGOT, 4), new ItemStack(Items.GOLDEN_BOOTS, 1));
        }

        if (ConfigHandler.LeatherArmorToLeather)

        {
            // Leather Armor To Leather
            GameRegistry.addShapelessRecipe(new ItemStack(Items.LEATHER, 5), new ItemStack(Items.LEATHER_HELMET, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.LEATHER, 8), new ItemStack(Items.LEATHER_CHESTPLATE, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.LEATHER, 7), new ItemStack(Items.LEATHER_LEGGINGS, 1));
            GameRegistry.addShapelessRecipe(new ItemStack(Items.LEATHER, 4), new ItemStack(Items.LEATHER_BOOTS, 1));
        }
        /**
         * Smelting Recipes
         */
        if (ConfigHandler.FleshToBeef)

        {
            // Flesh To Beef
            GameRegistry.addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.BEEF), 0.5F);
        }

        if (ConfigHandler.PoisonPotatoSmelting)

        {
            // Poison Potato Smelting
            GameRegistry.addSmelting(Items.POTATO, new ItemStack(Items.BAKED_POTATO), 0.5F);
        }
    }

    public static class GuiHandler implements IGuiHandler {
        @Override
        public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            return null;
        }

        @Override
        public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
            return null;
        }
    }

}
