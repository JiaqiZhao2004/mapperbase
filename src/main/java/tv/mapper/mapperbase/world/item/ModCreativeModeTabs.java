package tv.mapper.mapperbase.world.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import tv.mapper.mapperbase.MapperBase;

public class ModCreativeModeTabs {

        // Create a DeferredRegister for CreativeModeTabs
        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
                DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MapperBase.MODID);

        // Register your custom tab
        public static RegistryObject<CreativeModeTab> MAPPER_BASE_TAB = CREATIVE_MODE_TABS.register("mapperbase_tab",
                () -> CreativeModeTab.builder()
                        .icon(() -> new ItemStack(BaseItems.STEEL_INGOT.get())) // Set the icon for the tab
                        .title(Component.translatable("itemGroup.mapperbase_group")) // Set the title of the tab
                        .build()
        );

        public static void register(IEventBus modEventBus) {
                CREATIVE_MODE_TABS.register(modEventBus);
        }

}