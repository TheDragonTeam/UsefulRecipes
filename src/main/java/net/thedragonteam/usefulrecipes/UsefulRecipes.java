package net.thedragonteam.usefulrecipes;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thedragonteam.core.TheDragonCore;
import net.thedragonteam.core.config.ModConfigProcessor;
import net.thedragonteam.core.util.LogHelper;
import net.thedragonteam.usefulrecipes.proxy.CommonProxy;
import net.thedragonteam.usefulrecipes.registry.ModRecipes;
import net.thedragonteam.usefulrecipes.util.TextHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = UsefulRecipes.MODID, name = UsefulRecipes.MODNAME, version = UsefulRecipes.VERSION, dependencies = UsefulRecipes.DEPEND, updateJSON = "http://cdn.thedragonteam.net/update/json/usefulrecipes.json")
public class UsefulRecipes {

    public static final String MODNAME = "UsefulRecipes";
    public static final String MODID = "usefulrecipes";
    public static final String VERSION = "2.2.0";
    public static final String DEPEND = "required-after:thedragoncore@[" + TheDragonCore.VERSION + ",);";
    public static final String CLIENTPROXY = "net.thedragonteam.usefulrecipes.proxy.ClientProxy";
    public static final String COMMONPROXY = "net.thedragonteam.usefulrecipes.proxy.CommonProxy";

    @SidedProxy(clientSide = UsefulRecipes.CLIENTPROXY, serverSide = UsefulRecipes.COMMONPROXY)
    public static CommonProxy proxy;

    public static Logger logger = LogManager.getLogger(UsefulRecipes.MODNAME);

    @Instance(MODID)
    public static UsefulRecipes instance;

    public static ModConfigProcessor configProcessor = new ModConfigProcessor();

    public static Configuration configuration;

    public UsefulRecipes() {
        LogHelper.info("Welcoming Minecraft");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        ModRecipes.init();
        logger.info(TextHelper.localize("info." + UsefulRecipes.MODID + ".console.load.postInit"));
        proxy.init(event);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configuration = new Configuration(event.getSuggestedConfigurationFile());
        configProcessor.processConfig(USConfig.class, configuration);

        logger.info(TextHelper.localize("info." + UsefulRecipes.MODID + ".console.load.preInit"));
        proxy.registerRenderers(this);
        proxy.preInit(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info(TextHelper.localize("info." + UsefulRecipes.MODID + ".console.load.postInit"));
        proxy.postInit(event);
    }

}
