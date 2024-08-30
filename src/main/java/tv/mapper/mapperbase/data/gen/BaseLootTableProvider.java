package tv.mapper.mapperbase.data.gen;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.advancements.critereon.EnchantmentPredicate;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.ApplyExplosionDecay;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.FunctionUserBuilder;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.ConditionUserBuilder;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;
import tv.mapper.mapperbase.world.level.block.CustomDoorBlock;

public abstract class BaseLootTableProvider extends LootTableProvider {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();

    private static final Set<Item> IMMUNE_TO_EXPLOSIONS = Stream.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).map(ItemLike::asItem).collect(ImmutableSet.toImmutableSet());

    private static final LootItemCondition.Builder SILK_TOUCH = MatchTool.toolMatches(ItemPredicate.Builder.item().hasEnchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.Ints.atLeast(1))));

    private final DataGenerator generator;

    public BaseLootTableProvider(DataGenerator generator, Set<ResourceLocation> lootTables, List<SubProviderEntry> subProviderEntryList) {
        super(generator.getPackOutput(), lootTables, subProviderEntryList);
        this.generator = generator;
    }

    protected abstract void addTables();



    protected static <T extends FunctionUserBuilder<T>> T withExplosionDecay(ItemLike p_218552_0_, FunctionUserBuilder<T> p_218552_1_) {
        return (T) (!IMMUNE_TO_EXPLOSIONS.contains(p_218552_0_.asItem()) ? p_218552_1_.apply(ApplyExplosionDecay.explosionDecay()) : p_218552_1_.unwrap());
    }

    protected static <T extends ConditionUserBuilder<T>> T withSurvivesExplosion(ItemLike p_218560_0_, ConditionUserBuilder<T> p_218560_1_) {
        return (T) (!IMMUNE_TO_EXPLOSIONS.contains(p_218560_0_.asItem()) ? p_218560_1_.when(ExplosionCondition.survivesExplosion()) : p_218560_1_.unwrap());
    }

    protected LootTable.Builder createStandardTable(String modid, Block block) {
        String name = block.getDescriptionId().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.lootPool().name(name).setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(block)).when(ExplosionCondition.survivesExplosion());
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createSlabTable(String modid, Block block) {
        String name = block.getDescriptionId().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.lootPool().name(name).setRolls(ConstantValue.exactly(1)).add(withExplosionDecay(block, LootItem.lootTableItem(block).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2)).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SlabBlock.TYPE, SlabType.DOUBLE))))));
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createDoorTable(String modid, Block block) {
        String name = block.getDescriptionId().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.lootPool().name(name).setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CustomDoorBlock.HALF, DoubleBlockHalf.LOWER)))).when(ExplosionCondition.survivesExplosion());
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createBedTable(String modid, Block block) {
        String name = block.getDescriptionId().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.lootPool().name(name).setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BedBlock.PART, BedPart.HEAD)))).when(ExplosionCondition.survivesExplosion());
        return LootTable.lootTable().withPool(builder);
    }

    protected LootTable.Builder createChestTable(String name, Block block) {
        LootPool.Builder builder = LootPool.lootPool().name(name).setRolls(ConstantValue.exactly(1)).add(LootItem.lootTableItem(block).apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY))).when(ExplosionCondition.survivesExplosion());
        return LootTable.lootTable().withPool(builder);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    protected LootTable.Builder createSilkTable(String modid, Block block, Block loot) {
        String name = block.getDescriptionId().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.lootPool().name(name).setRolls(ConstantValue.exactly(1)).add(((LootPoolSingletonContainer.Builder) LootItem.lootTableItem(block).when(SILK_TOUCH)).otherwise(withSurvivesExplosion(block, LootItem.lootTableItem(loot))));
        return LootTable.lootTable().withPool(builder);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    protected LootTable.Builder createSilkTable(String modid, Block block, Item loot) {
        String name = block.getDescriptionId().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.lootPool().name(name).setRolls(ConstantValue.exactly(1)).add(((LootPoolSingletonContainer.Builder) LootItem.lootTableItem(block).when(SILK_TOUCH)).otherwise(withSurvivesExplosion(block, LootItem.lootTableItem(loot))));
        return LootTable.lootTable().withPool(builder);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    protected LootTable.Builder createSilkTable(String modid, Block block, Item loot, int min, int max, int fortune) {
        String name = block.getDescriptionId().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.lootPool().name(name).setRolls(ConstantValue.exactly(1)).add(((LootPoolSingletonContainer.Builder) LootItem.lootTableItem(block).when(SILK_TOUCH)).otherwise(withSurvivesExplosion(block, LootItem.lootTableItem(loot).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, fortune)))));
        return LootTable.lootTable().withPool(builder);
    }

    @Override
    public @NotNull CompletableFuture<?> run(@NotNull CachedOutput pOutput) {
        addTables();

        Map<ResourceLocation, LootTable> tables = new HashMap<>();
        for (Map.Entry<Block, LootTable.Builder> entry : lootTables.entrySet()) {
            tables.put(entry.getKey().getLootTable(), entry.getValue().setParamSet(LootContextParamSets.BLOCK).build());
        }
        writeTables(pOutput, tables);
        return null;
    }

    private void writeTables(CachedOutput pOutput, Map<ResourceLocation, LootTable> tables) {
        Path outputFolder = this.generator.getPackOutput().getOutputFolder();
        tables.forEach((key, lootTable) ->
        {
            Path path = outputFolder.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");
//            try {
            DataProvider.saveStable(pOutput,LootTables.serialize(lootTable), path);
//            } catch (IOException e) {
//                MapperBase.LOGGER.error("Couldn't write loot table {}", path, e);
//            }
        });
    }

//    @Override
//    public String getName() {
//        return "MapperBase LootTables";
//    }
}