package tv.mapper.mapperbase.world.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.world.level.block.BaseBlocks;

@Mod.EventBusSubscriber(modid = MapperBase.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BaseGroups
{

    @SubscribeEvent
    public static void buildContents(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(new ResourceLocation(MapperBase.MODID, "mapperbase"), builder ->
                builder.title(Component.translatable("itemGroup.mapperbase_group"))
                        .icon(() -> new ItemStack(BaseItems.STEEL_INGOT.get()))
                        .displayItems((enabledFlags, populator, hasPermissions) -> {
                            populator.accept(BaseItems.BOLT.get());
                            populator.accept(BaseItems.STEEL_FENCE_ITEM.get());
                            populator.accept(BaseItems.STEEL_ITEM.get());
                            populator.accept(BaseItems.STEEL_INGOT.get());
                            populator.accept(BaseItems.STEEL_SLAB_ITEM.get());
                            populator.accept(BaseItems.STEEL_STAIRS_ITEM.get());
                            populator.accept(BaseItems.STEEL_WALL_ITEM.get());
                            populator.accept(BaseItems.STEEL_FENCE_GATE_ITEM.get());
                            populator.accept(BaseItems.STEEL_PRESSURE_PLATE_ITEM.get());
                            populator.accept(BaseItems.FERRITE.get());
                            populator.accept(BaseItems.FLATTER_HAMMER.get());
                            populator.accept(BaseItems.IRON_PLATE.get());
                            populator.accept(BaseItems.IRON_ROD.get());
                            populator.accept(BaseItems.RAW_STEEL.get());
                            populator.accept(BaseItems.STEEL_AXE.get());
                            populator.accept(BaseItems.STEEL_BOOTS.get());
                            populator.accept(BaseItems.STEEL_CHESTPLATE.get());
                            populator.accept(BaseItems.STEEL_HELMET.get());
                            populator.accept(BaseItems.STEEL_HOE.get());
                            populator.accept(BaseItems.STEEL_HORSE_ARMOR.get());
                            populator.accept(BaseItems.STEEL_LEGGINGS.get());
                            populator.accept(BaseItems.STEEL_NUGGET.get());
                            populator.accept(BaseItems.STEEL_PICKAXE.get());
                            populator.accept(BaseItems.STEEL_PLATE.get());
                            populator.accept(BaseItems.STEEL_ROD.get());
                            populator.accept(BaseItems.STEEL_SHOVEL.get());
                            populator.accept(BaseItems.STEEL_SWORD.get());
                            populator.accept(BaseBlocks.STEEL_BLOCK.get());
                            populator.accept(BaseBlocks.STEEL_FENCE.get());
                            populator.accept(BaseBlocks.STEEL_FENCE_GATE.get());
                            populator.accept(BaseBlocks.STEEL_PRESSURE_PLATE.get());
                            populator.accept(BaseBlocks.STEEL_SLAB.get());
                            populator.accept(BaseBlocks.STEEL_WALL.get());
                            populator.accept(BaseBlocks.STEEL_STAIRS.get());
                        })
        );
    }
}