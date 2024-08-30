package tv.mapper.mapperbase;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.BaseCoralFanBlock;
import net.minecraftforge.event.CreativeModeTabEvent;
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

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::addCreative);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == BaseGroups.MAPPERBASE) {
            event.accept(BaseItems.BOLT);
            event.accept(BaseItems.STEEL_FENCE_ITEM);
            event.accept(BaseItems.STEEL_ITEM);
            event.accept(BaseItems.STEEL_INGOT);
            event.accept(BaseItems.STEEL_SLAB_ITEM);
            event.accept(BaseItems.STEEL_STAIRS_ITEM);
            event.accept(BaseItems.STEEL_WALL_ITEM);
            event.accept(BaseItems.STEEL_FENCE_GATE_ITEM);
            event.accept(BaseItems.STEEL_PRESSURE_PLATE_ITEM);
            event.accept(BaseItems.FERRITE);
            event.accept(BaseItems.FLATTER_HAMMER);
            event.accept(BaseItems.IRON_PLATE);
            event.accept(BaseItems.IRON_ROD);
            event.accept(BaseItems.RAW_STEEL);
            event.accept(BaseItems.STEEL_AXE);
            event.accept(BaseItems.STEEL_BOOTS);
            event.accept(BaseItems.STEEL_CHESTPLATE);
            event.accept(BaseItems.STEEL_HELMET);
            event.accept(BaseItems.STEEL_HOE);
            event.accept(BaseItems.STEEL_HORSE_ARMOR);
            event.accept(BaseItems.STEEL_LEGGINGS);
            event.accept(BaseItems.STEEL_NUGGET);
            event.accept(BaseItems.STEEL_PICKAXE);
            event.accept(BaseItems.STEEL_PLATE);
            event.accept(BaseItems.STEEL_ROD);
            event.accept(BaseItems.STEEL_SHOVEL);
            event.accept(BaseItems.STEEL_SWORD);

            event.accept(BaseBlocks.STEEL_BLOCK);
            event.accept(BaseBlocks.STEEL_FENCE);
            event.accept(BaseBlocks.STEEL_FENCE_GATE);
            event.accept(BaseBlocks.STEEL_PRESSURE_PLATE);
            event.accept(BaseBlocks.STEEL_SLAB);
            event.accept(BaseBlocks.STEEL_WALL);
            event.accept(BaseBlocks.STEEL_STAIRS);
        }
        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(BaseBlocks.STEEL_BLOCK);
            event.accept(BaseBlocks.STEEL_FENCE);
            event.accept(BaseBlocks.STEEL_FENCE_GATE);
            event.accept(BaseBlocks.STEEL_PRESSURE_PLATE);
            event.accept(BaseBlocks.STEEL_SLAB);
            event.accept(BaseBlocks.STEEL_WALL);
            event.accept(BaseBlocks.STEEL_STAIRS);
        }
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(BaseItems.STEEL_INGOT);

        }
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