package tv.mapper.mapperbase;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.BaseCoralFanBlock;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tv.mapper.mapperbase.config.BaseConfig;
import tv.mapper.mapperbase.world.BaseOreGenerator;
import tv.mapper.mapperbase.world.item.BaseGroups;
import tv.mapper.mapperbase.world.item.BaseItems;
import tv.mapper.mapperbase.world.item.BaseTiers;
import tv.mapper.mapperbase.world.level.block.BaseBlocks;

@Mod(MapperBase.MODID)
public class MapperBase
{
    public static final String MODID = "mapperbase";
    public static final Logger LOGGER = LogManager.getLogger();

    public MapperBase()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, BaseConfig.CLIENT_CONFIG);

        BaseBlocks.init();
        BaseItems.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);

        MinecraftForge.EVENT_BUS.register(new BaseOreGenerator());
        MinecraftForge.EVENT_BUS.register(new BaseGroups());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Mapper Base setup started! Thank you for using my mods!");
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {}

    private void serverSetup(final FMLDedicatedServerSetupEvent event)
    {}
}