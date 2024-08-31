package tv.mapper.mapperbase.world.level.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

public class CustomPressurePlateBlock extends PressurePlateBlock implements ToolManager
{
    private ToolTiers tier;
    private ToolTypes tool;

    public CustomPressurePlateBlock(Sensitivity sensitivity, Properties properties, ToolTypes tool)
    {
        super(sensitivity, properties, BlockSetType.OAK);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CustomPressurePlateBlock(Sensitivity sensitivity, Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(sensitivity, properties, BlockSetType.OAK);
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