package net.elias.com.block;

import net.elias.com.TutorialMod;
import net.elias.com.block.custom.MagicBlock;
import net.elias.com.block.custom.PinkGarnetLampBlock;
import net.elias.com.tutorialmod.sound.ModSounds;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

//so regestriert man Blöcke
public class ModBlocks {

    // Creating blocks. Will not drop anything because that needs to be added in a loot table

    // Pink Garnet Block
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(1f, 6f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK)));

    // Raw Pink Garnet Block
    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create().strength(1f, 3f).requiresTool().sounds(BlockSoundGroup.STONE)));

    // Garnet Ore
    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5),
                    AbstractBlock.Settings.create().strength(1f, 3f).requiresTool().sounds(BlockSoundGroup.STONE)));

    // Garnet Deepslate Ore
    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(5, 8),
                    AbstractBlock.Settings.create().strength(1f, 3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));

    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new MagicBlock(AbstractBlock.Settings.create().strength(1f,1f).requiresTool().sounds(ModSounds.MAGIC_BLOCK_SOUNDS)));

    public static final Block PINK_GARNET_STAIRS = registerBlock("pink_garnet_stairs",
            new StairsBlock(ModBlocks.PINK_GARNET_BLOCK.getDefaultState(),
                    AbstractBlock.Settings.create().strength(2f,2f).requiresTool()));

    public static final Block PINK_GARNET_WALL = registerBlock("pink_garnet_wall",
            new WallBlock(AbstractBlock.Settings.create().strength(2f,2f).requiresTool()));

        public static final Block PINK_GARNET_DOOR = registerBlock("pink_garnet_door",
            new DoorBlock(BlockSetType.ACACIA, AbstractBlock.Settings.create().strength(2f,2f).requiresTool().nonOpaque()));

        public static final Block PINK_GARNET_SLAB = registerBlock("pink_garnet_slab",
            new SlabBlock(AbstractBlock.Settings.create().strength(2f,2f).requiresTool()));

        public static final Block PINK_GARNET_TRAPDOOR = registerBlock("pink_garnet_trapdoor",
            new TrapdoorBlock(BlockSetType.ACACIA,
                    AbstractBlock.Settings.create().strength(2f,2f).requiresTool().nonOpaque()));

        public static final Block PINK_GARNET_BUTTON = registerBlock("pink_garnet_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create().strength(2f,2f).requiresTool().noCollision()));

         public static final Block PINK_GARNET_PRESSURE_PLATE = registerBlock("pink_garnet_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(2f,2f).requiresTool()));

       public static final Block PINK_GARNET_FENCE = registerBlock("pink_garnet_fence",
            new FenceBlock(AbstractBlock.Settings.create().strength(2f,2f).requiresTool()));

        public static final Block PINK_GARNET_FENCE_GATE = registerBlock("pink_garnet_fence_gate",
            new FenceGateBlock(WoodType.ACACIA,AbstractBlock.Settings.create().strength(2f,2f).requiresTool()));

        public static final Block PINK_GARNET_LAMP = registerBlock("pink_garnet_lamp",
                new PinkGarnetLampBlock(AbstractBlock.Settings.create()
                        .strength(1f,1f).requiresTool().luminance(state -> state.get(PinkGarnetLampBlock.CLICKED) ? 15 : 0)));

    // Register helper function for blocks when they're in 3d block form (placed on the ground)
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    // Register helper function for blocks when they're in item form
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        // Adding the blocks to the 'Building Blocks' item group on the creative menu
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(PINK_GARNET_BLOCK);
            entries.add(RAW_PINK_GARNET_BLOCK);
        });
    }

}