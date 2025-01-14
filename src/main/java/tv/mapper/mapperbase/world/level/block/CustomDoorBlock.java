package tv.mapper.mapperbase.world.level.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class CustomDoorBlock extends DoorBlock implements ToolManager
{
    protected ToolTiers tier;
    protected ToolTypes tool;

    public CustomDoorBlock(Properties properties, ToolTypes tool)
    {
        super(properties, BlockSetType.OAK);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CustomDoorBlock(Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(properties, BlockSetType.OAK);
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