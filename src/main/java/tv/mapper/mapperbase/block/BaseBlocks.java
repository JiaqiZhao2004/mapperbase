package tv.mapper.mapperbase.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.mapperbase.MapperBase;

public class BaseBlocks
{
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MapperBase.MODID);

    public static final RegistryObject<CustomBlock> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new CustomBlock(Block.Properties.of(Material.METAL, MaterialColor.STONE).strength(5.0F, 6.0F).sound(SoundType.LANTERN)));
    public static final RegistryObject<CustomStairsBlock> STEEL_STAIRS = BLOCKS.register("steel_stairs", () -> new CustomStairsBlock(() -> STEEL_BLOCK.get().defaultBlockState(), Block.Properties.of(Material.METAL, MaterialColor.STONE).strength(5.0F, 6.0F).sound(SoundType.LANTERN)));
    public static final RegistryObject<CustomSlabBlock> STEEL_SLAB = BLOCKS.register("steel_slab", () -> new CustomSlabBlock(Block.Properties.of(Material.METAL, MaterialColor.STONE).strength(5.0F, 6.0F).sound(SoundType.LANTERN)));
    public static final RegistryObject<CustomWallBlock> STEEL_WALL = BLOCKS.register("steel_wall", () -> new CustomWallBlock(Block.Properties.of(Material.METAL, MaterialColor.STONE).strength(5.0F, 6.0F).sound(SoundType.LANTERN)));
    public static final RegistryObject<CustomPressurePlateBlock> STEEL_PRESSURE_PLATE = BLOCKS.register("steel_pressure_plate", () -> new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.of(Material.METAL, MaterialColor.STONE).noCollission().strength(5.0F, 6.0F).sound(SoundType.LANTERN)));
    public static final RegistryObject<FenceBlock> STEEL_FENCE = BLOCKS.register("steel_fence", () -> new FenceBlock(Block.Properties.of(Material.METAL, MaterialColor.STONE).strength(5.0F, 6.0F).sound(SoundType.LANTERN)));
    public static final RegistryObject<FenceGateBlock> STEEL_FENCE_GATE = BLOCKS.register("steel_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.METAL, MaterialColor.STONE).strength(5.0F, 6.0F).sound(SoundType.LANTERN)));

    public static final RegistryObject<PaintableBlock> CONCRETE = BLOCKS.register("concrete", () -> new PaintableBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE), 1));
    public static final RegistryObject<CustomStairsBlock> CONCRETE_STAIRS = BLOCKS.register("concrete_stairs", () -> new CustomStairsBlock(() -> CONCRETE.get().defaultBlockState(), Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<CustomSlabBlock> CONCRETE_SLAB = BLOCKS.register("concrete_slab", () -> new CustomSlabBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<CustomWallBlock> CONCRETE_WALL = BLOCKS.register("concrete_wall", () -> new CustomWallBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<CustomPressurePlateBlock> CONCRETE_PRESSURE_PLATE = BLOCKS.register("concrete_pressure_plate", () -> new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.of(Material.STONE, MaterialColor.STONE).noCollission().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<FenceBlock> CONCRETE_FENCE = BLOCKS.register("concrete_fence", () -> new FenceBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<FenceGateBlock> CONCRETE_FENCE_GATE = BLOCKS.register("concrete_fence_gate", () -> new FenceGateBlock(Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE)));

    public static final RegistryObject<PaintableBlock> ASPHALT = BLOCKS.register("asphalt", () -> new PaintableBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(1.5F, 6.0F).sound(SoundType.STONE), 0));
    public static final RegistryObject<CustomStairsBlock> ASPHALT_STAIRS = BLOCKS.register("asphalt_stairs", () -> new CustomStairsBlock(() -> ASPHALT.get().defaultBlockState(), Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<CustomSlabBlock> ASPHALT_SLAB = BLOCKS.register("asphalt_slab", () -> new CustomSlabBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<CustomPressurePlateBlock> ASPHALT_PRESSURE_PLATE = BLOCKS.register("asphalt_pressure_plate", () -> new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).noCollission().strength(1.5F, 6.0F).sound(SoundType.STONE)));

    public static final RegistryObject<CustomBlock> BITUMEN_BLOCK = BLOCKS.register("bitumen_block", () -> new CustomBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(3.0F)));
    public static final RegistryObject<CustomOreBlock> BITUMEN_ORE = BLOCKS.register("bitumen_ore", () -> new CustomOreBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(3.0F)));

    public static void init()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}