package tv.mapper.mapperbase.world.level.block;

import net.minecraft.world.level.block.FenceGateBlock;


public class CustomFenceGateBlock extends FenceGateBlock implements ToolManager
{
    private ToolTiers tier;
    private ToolTypes tool;

    public CustomFenceGateBlock(Properties properties, ToolTypes tool)
    {
        super(properties, BaseBlocks.SAMPLE_WOOD_TYPE);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CustomFenceGateBlock(Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(properties, BaseBlocks.SAMPLE_WOOD_TYPE);
        this.tool = tool;
        this.tier = tier;
    }

    @Override
    public ToolTiers getTier()
    {
        return this.tier;
    }

    @Override
    public ToolTypes getTool()
    {
        return this.tool;
    }
}