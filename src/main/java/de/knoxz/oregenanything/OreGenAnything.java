package de.knoxz.oregenanything;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import de.knoxz.oregenanything.configuration.ConfigurationHandler;
import de.knoxz.oregenanything.proxy.CommonProxy;
import de.knoxz.oregenanything.reference.Reference;
import de.knoxz.oregenanything.utility.LogHelper;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, acceptableRemoteVersions = "*")
public class OreGenAnything {

    @Mod.Instance(Reference.MOD_ID)
    public static OreGenAnything instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {

        ConfigurationHandler.init(e.getSuggestedConfigurationFile());
        GameRegistry.registerWorldGenerator(new OreGenAnythingGenerator(),10);
        LogHelper.info("Pre Initialization Complete!");

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        LogHelper.info("Initialization Complete!");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        LogHelper.info("Post Initialization Complete!");
    }

}
