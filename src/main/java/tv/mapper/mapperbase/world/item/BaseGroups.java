package tv.mapper.mapperbase.world.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.common.Mod;
import tv.mapper.mapperbase.MapperBase;

@Mod.EventBusSubscriber(modid = MapperBase.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BaseGroups
{
    public static CreativeModeTab MAPPERBASE;

    public static void registerCreativeModeTab(CreativeModeTabEvent.Register event) {
        MAPPERBASE = event.registerCreativeModeTab(new ResourceLocation(MapperBase.MODID, "mapperbase_group"),
                builder -> builder.icon(() -> new ItemStack(BaseItems.BOLT.get())).title(Component.translatable("item.mapperbase.bolt")).build());
    }
//    = new CreativeModeTab("mapperbase_group")
//    {
//        @Override
//        public ItemStack makeIcon()
//        {
//            return new ItemStack(BaseItems.STEEL_INGOT.get());
//        }
//    };
}