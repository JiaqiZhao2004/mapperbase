package tv.mapper.mapperbase.world.level.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.FenceGateBlock;

public class CustomFenceGateBlock extends FenceGateBlock implements ToolManager
{
    private ToolTiers tier;
    private ToolTypes tool;

    public CustomFenceGateBlock(Properties properties, ToolTypes tool)
    {
        super(properties, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CustomFenceGateBlock(Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(properties, SoundEvents.FENCE_GATE_CLOSE, SoundEvents.FENCE_GATE_OPEN);
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