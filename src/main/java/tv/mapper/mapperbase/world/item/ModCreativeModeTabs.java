package tv.mapper.mapperbase.world.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.world.level.block.BaseBlocks;

//@Mod.EventBusSubscriber(modid = MapperBase.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
//public class BaseGroups {
//    @SubscribeEvent
//    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
//        CreativeModeTab.builder()
//            .title(Component.translatable("itemGroup.mapperbase_group"))
//            .icon(() -> new ItemStack(BaseItems.STEEL_INGOT.get()))
////            .withTabsAfter(CreativeModeTabs.BUILDING_BLOCKS)
//            .displayItems((parameters, output) -> {
//                output.accept(BaseItems.BOLT.get());
//                output.accept(BaseItems.STEEL_FENCE_ITEM.get());
//                output.accept(BaseItems.STEEL_ITEM.get());
//                output.accept(BaseItems.STEEL_INGOT.get());
//                output.accept(BaseItems.STEEL_SLAB_ITEM.get());
//                output.accept(BaseItems.STEEL_STAIRS_ITEM.get());
//                output.accept(BaseItems.STEEL_WALL_ITEM.get());
//                output.accept(BaseItems.STEEL_FENCE_GATE_ITEM.get());
//                output.accept(BaseItems.STEEL_PRESSURE_PLATE_ITEM.get());
//                output.accept(BaseItems.FERRITE.get());
//                output.accept(BaseItems.FLATTER_HAMMER.get());
//                output.accept(BaseItems.IRON_PLATE.get());
//                output.accept(BaseItems.IRON_ROD.get());
//                output.accept(BaseItems.RAW_STEEL.get());
//                output.accept(BaseItems.STEEL_AXE.get());
//                output.accept(BaseItems.STEEL_BOOTS.get());
//                output.accept(BaseItems.STEEL_CHESTPLATE.get());
//                output.accept(BaseItems.STEEL_HELMET.get());
//                output.accept(BaseItems.STEEL_HOE.get());
//                output.accept(BaseItems.STEEL_HORSE_ARMOR.get());
//                output.accept(BaseItems.STEEL_LEGGINGS.get());
//                output.accept(BaseItems.STEEL_NUGGET.get());
//                output.accept(BaseItems.STEEL_PICKAXE.get());
//                output.accept(BaseItems.STEEL_PLATE.get());
//                output.accept(BaseItems.STEEL_ROD.get());
//                output.accept(BaseItems.STEEL_SHOVEL.get());
//                output.accept(BaseItems.STEEL_SWORD.get());
//                output.accept(BaseBlocks.STEEL_BLOCK.get());
//                output.accept(BaseBlocks.STEEL_FENCE.get());
//                output.accept(BaseBlocks.STEEL_FENCE_GATE.get());
//                output.accept(BaseBlocks.STEEL_PRESSURE_PLATE.get());
//                output.accept(BaseBlocks.STEEL_SLAB.get());
//                output.accept(BaseBlocks.STEEL_WALL.get());
//                output.accept(BaseBlocks.STEEL_STAIRS.get());
//            })
//        ;
//    }
//}

//@Mod.EventBusSubscriber(modid = MapperBase.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
//public class BaseGroups {
//
//        @SubscribeEvent
//        public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
//                if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
//                        event.accept(BaseBlocks.STEEL_STAIRS.get());
//                }
//        }
//}

public class ModCreativeModeTabs {

        // Create a DeferredRegister for CreativeModeTabs
        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
                DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MapperBase.MODID);

        // Register your custom tab
        public static RegistryObject<CreativeModeTab> MAPPER_BASE_TAB = CREATIVE_MODE_TABS.register("mapperbase_tab",
                () -> CreativeModeTab.builder()
                        .icon(() -> new ItemStack(BaseItems.STEEL_INGOT.get())) // Set the icon for the tab
                        .title(Component.translatable("itemGroup.mapperbase_group")) // Set the title of the tab
//                        .displayItems((parameters, output) -> {
//                                output.accept(ModItems.MY_ITEM.get()); // Add items to the tab
//                                output.accept(ModBlocks.MY_BLOCK.get());
//                        })
                        .build()
        );

        public static void register(IEventBus modEventBus) {
                CREATIVE_MODE_TABS.register(modEventBus);
        }

}