package net.thedragonteam.usefulrecipes;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.thedragonteam.thedragonlib.config.ModConfigProcessor;
import net.thedragonteam.thedragonlib.util.LogHelper;
import net.thedragonteam.usefulrecipes.proxy.CommonProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = UsefulRecipes.MODID, name = UsefulRecipes.MODNAME, version = UsefulRecipes.VERSION, dependencies = UsefulRecipes.DEPEND, updateJSON = "http://cdn.thedragonteam.net/update/json/usefulrecipes.json")
public class UsefulRecipes {

    public static final String MODNAME = "UsefulRecipes";
    public static final String MODID = "usefulrecipes";
    public static final String VERSION = "1.11-3.0.0";
    public static final String LIB_VERSION = "1.11-2.0.1";
    public static final String DEPEND = "required-after:thedragonlib@[" + UsefulRecipes.LIB_VERSION + ",);";
    public static final String CLIENTPROXY = "net.thedragonteam.usefulrecipes.proxy.ClientProxy";
    public static final String SERVERPROXY = "net.thedragonteam.usefulrecipes.proxy.ServerProxy";

    @SidedProxy(clientSide = UsefulRecipes.CLIENTPROXY, serverSide = UsefulRecipes.SERVERPROXY)
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
        proxy.init(event);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        configuration = new Configuration(event.getSuggestedConfigurationFile());
        configProcessor.processConfig(USConfig.class, configuration);
        proxy.preInit(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

}
