package tv.mapper.mapperbase.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tv.mapper.mapperbase.config.BaseConfig.ClientConfig;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class TagViewer
{
    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent e)
    {
        if(!ClientConfig.ENABLE_TAG_VIEWER.get())
            return;

        if(!Screen.hasControlDown())
            return;

        List<Component> tooltips = e.getToolTip();
        Item item = e.getItemStack().getItem();
        Map<ResourceLocation, Tag<Item>> tagmap = ItemTags.getAllTags().getAllTags();

        int count = 0;

        for(Entry<ResourceLocation, Tag<Item>> entry : tagmap.entrySet())
        {
            if(item.getTags().contains(entry.getKey()))
            {
                tooltips.add(new TextComponent("Tag: " + entry.getKey().toString()).withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.DARK_GRAY));
                count++;
            }
        }

        if(count <= 0)
            tooltips.add(new TextComponent("No tag found...").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.DARK_GRAY));
    }
}