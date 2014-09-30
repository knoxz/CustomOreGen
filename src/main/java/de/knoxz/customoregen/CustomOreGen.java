package de.knoxz.customoregen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import de.knoxz.customoregen.configuration.ConfigurationHandler;
import de.knoxz.customoregen.proxy.CommonProxy;
import de.knoxz.customoregen.reference.Reference;
import de.knoxz.customoregen.utility.LogHelper;

import java.io.IOException;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class CustomOreGen {

    @Mod.Instance(Reference.MOD_ID)
    public static CustomOreGen instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {

        ConfigurationHandler.init(e.getSuggestedConfigurationFile());
        GameRegistry.registerWorldGenerator(new CustomOreGenerator(),10);
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
