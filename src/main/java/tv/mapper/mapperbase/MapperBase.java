package tv.mapper.mapperbase;

import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tv.mapper.mapperbase.config.BaseConfig;
import tv.mapper.mapperbase.world.BaseOreGenerator;
import tv.mapper.mapperbase.world.item.BaseItems;
import tv.mapper.mapperbase.world.item.BaseTiers;
import tv.mapper.mapperbase.world.item.ModCreativeModeTabs;
import tv.mapper.mapperbase.world.level.block.BaseBlocks;

@Mod(MapperBase.MODID)
public class MapperBase
{
    public static final String MODID = "mapperbase";
    public static final Logger LOGGER = LogManager.getLogger();

    public MapperBase()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, BaseConfig.CLIENT_CONFIG);

        ModCreativeModeTabs.register(modEventBus);

        BaseBlocks.register(modEventBus);
        BaseItems.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::serverSetup);

        modEventBus.register(new BaseOreGenerator());
        modEventBus.register(new BaseTiers());
        modEventBus.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModCreativeModeTabs.MAPPER_BASE_TAB.get()) {
            event.accept(BaseItems.BOLT.get());
            event.accept(BaseItems.STEEL_FENCE_ITEM.get());
            event.accept(BaseItems.STEEL_ITEM.get());
            event.accept(BaseItems.STEEL_INGOT.get());
            event.accept(BaseItems.STEEL_SLAB_ITEM.get());
            event.accept(BaseItems.STEEL_STAIRS_ITEM.get());
            event.accept(BaseItems.STEEL_WALL_ITEM.get());
            event.accept(BaseItems.STEEL_FENCE_GATE_ITEM.get());
            event.accept(BaseItems.STEEL_PRESSURE_PLATE_ITEM.get());
            event.accept(BaseItems.FERRITE.get());
            event.accept(BaseItems.FLATTER_HAMMER.get());
            event.accept(BaseItems.IRON_PLATE.get());
            event.accept(BaseItems.IRON_ROD.get());
            event.accept(BaseItems.RAW_STEEL.get());
            event.accept(BaseItems.STEEL_AXE.get());
            event.accept(BaseItems.STEEL_BOOTS.get());
            event.accept(BaseItems.STEEL_CHESTPLATE.get());
            event.accept(BaseItems.STEEL_HELMET.get());
            event.accept(BaseItems.STEEL_HOE.get());
            event.accept(BaseItems.STEEL_HORSE_ARMOR.get());
            event.accept(BaseItems.STEEL_LEGGINGS.get());
            event.accept(BaseItems.STEEL_NUGGET.get());
            event.accept(BaseItems.STEEL_PICKAXE.get());
            event.accept(BaseItems.STEEL_PLATE.get());
            event.accept(BaseItems.STEEL_ROD.get());
            event.accept(BaseItems.STEEL_SHOVEL.get());
            event.accept(BaseItems.STEEL_SWORD.get());
            event.accept(BaseBlocks.STEEL_BLOCK.get());
            event.accept(BaseBlocks.STEEL_FENCE.get());
            event.accept(BaseBlocks.STEEL_FENCE_GATE.get());
            event.accept(BaseBlocks.STEEL_PRESSURE_PLATE.get());
            event.accept(BaseBlocks.STEEL_SLAB.get());
            event.accept(BaseBlocks.STEEL_WALL.get());
            event.accept(BaseBlocks.STEEL_STAIRS.get());
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