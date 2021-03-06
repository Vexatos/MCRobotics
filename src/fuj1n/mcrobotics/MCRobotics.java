package fuj1n.mcrobotics;

import cpw.mods.fml.common.network.NetworkRegistry;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkMod;
import fuj1n.mcrobotics.common.*;

/**
 * NXT name proposals(obviously cannot use NXT)
 * BlockOS - (as suggested by Chaz_Turbo)
 *
 */

@Mod(modid="MCRobotics", name="MCRobotics", version=fuj1n.mcrobotics.ref.Version.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class MCRobotics {

	@Instance("MCRobotics")
	public static MCRobotics instance;
	
	@SidedProxy(clientSide="fuj1n.mcrobotics.client.ClientProxyMCRobotics", serverSide="fuj1n.mcrobotics.common.CommonProxyMCRobotics")
	public static CommonProxyMCRobotics proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		proxy.preInit();
		new ConfigMCRobotics(event.getSuggestedConfigurationFile());
		
		NetworkRegistry.instance().registerGuiHandler(instance, new GuiHandler());
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event){
		proxy.Init();
		new Content();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		proxy.postInit();
	}
	
}
