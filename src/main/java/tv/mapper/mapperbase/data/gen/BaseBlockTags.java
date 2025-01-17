package tv.mapper.mapperbase.data.gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import tv.mapper.mapperbase.data.BaseTags;
import tv.mapper.mapperbase.world.item.BaseTiers;
import tv.mapper.mapperbase.world.level.block.BaseBlocks;
import tv.mapper.mapperbase.world.level.block.ToolManager;

public class BaseBlockTags extends BlockTagsProvider
{
    public BaseBlockTags(GatherDataEvent event, String modid, ExistingFileHelper existingFileHelper)
    {
        super(event.getGenerator().getPackOutput(), event.getLookupProvider(), modid, existingFileHelper);
    }

    public void addTags(HolderLookup.@NotNull Provider provider)
    {
        this.tag(BlockTags.STAIRS).add(BaseBlocks.STEEL_STAIRS.get());
        this.tag(BlockTags.SLABS).add(BaseBlocks.STEEL_SLAB.get());
        this.tag(BlockTags.WALLS).add(BaseBlocks.STEEL_WALL.get());
        this.tag(BlockTags.FENCES).add(BaseBlocks.STEEL_FENCE.get());
        this.tag(Tags.Blocks.FENCE_GATES).add(BaseBlocks.STEEL_FENCE_GATE.get());
        this.tag(Tags.Blocks.FENCES).add(BaseBlocks.STEEL_FENCE.get());
        this.tag(BaseTags.ForgeBlocks.FENCES_STEEL).add(BaseBlocks.STEEL_FENCE.get());
        this.tag(Tags.Blocks.STORAGE_BLOCKS).add(BaseBlocks.STEEL_BLOCK.get());
        this.tag(BlockTags.BEACON_BASE_BLOCKS).add(BaseBlocks.STEEL_BLOCK.get());
        this.tag(BaseTags.ForgeBlocks.STORAGE_BLOCKS_STEEL).add(BaseBlocks.STEEL_BLOCK.get());
        this.tag(BaseTags.ForgeBlocks.PRESSURE_PLATES).add(BaseBlocks.STEEL_PRESSURE_PLATE.get());

        registerToolTags(BaseBlocks.BLOCKS);
    }

    // Tool system
    protected void registerToolTags(@SuppressWarnings("SameParameterValue") DeferredRegister<Block> blocks)
    {
        for(RegistryObject<Block> object : blocks.getEntries())
        {
            Block block = object.get();

            if(block instanceof ToolManager)
            {
                switch(((ToolManager)block).getTool())
                {
                    case PICKAXE:
                        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
                        break;
                    case AXE:
                        this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        break;
                    case SHOVEL:
                        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(block);
                        break;
                    case HOE:
                        this.tag(BlockTags.MINEABLE_WITH_HOE).add(block);
                        break;
                    default:
                        break;
                }

                switch(((ToolManager)block).getTier())
                {
                    case WOOD:
                        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL).add(block);
                        break;
                    case GOLD:
                        this.tag(Tags.Blocks.NEEDS_GOLD_TOOL).add(block);
                        break;
                    case STONE:
                        this.tag(BlockTags.NEEDS_STONE_TOOL).add(block);
                        break;
                    case IRON:
                        this.tag(BlockTags.NEEDS_IRON_TOOL).add(block);
                        break;
                    case STEEL:
                        this.tag(BaseTiers.NEEDS_STEEL_TOOL).add(block);
                        break;
                    case DIAMOND:
                        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(block);
                        break;
                    case NETHERITE:
                        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(block);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}