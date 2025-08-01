package net.elias.com.item;

import net.elias.com.TutorialMod;
import net.elias.com.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

    public class ModItemGroups {

        // Creates the Pink Garnet Items tab in the creative menu
        public static final ItemGroup PINK_GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(TutorialMod.MOD_ID, "pink_garnet_items"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINK_GARNET)) // Gives item group the pink garnet icon
                        .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_items"))  // Gives item group the name we want from the green directory location
                        .entries((displayContext, entries) -> {
                            // Add Pink Garnet Items here below:
                            entries.add(ModItems.PINK_GARNET);
                            entries.add(ModItems.RAW_PINK_GARNET);
                            entries.add(ModItems.CHISEL);
                            entries.add(ModItems.CAULIFLOWER);
                            entries.add(ModItems.STARLIGHT_ASHES);
                            entries.add(ModItems.PINK_GARNET_PICKAXE);
                            entries.add(ModItems.PINK_GARNET_AXE);
                            entries.add(ModItems.PINK_GARNET_HOE);
                            entries.add(ModItems.PINK_GARNET_SWORD);
                            entries.add(ModItems.PINK_GARNET_SHOVEL);
                            entries.add(ModItems.PINK_GARNET_HAMMER);
                            entries.add(ModItems.KAUPEN_BOW);

                            entries.add(ModItems.PINK_GARNET_HELMET);
                            entries.add(ModItems.PINK_GARNET_CHESTPLATE);
                            entries.add(ModItems.PINK_GARNET_LEGGINS);
                            entries.add(ModItems.PINK_GARNET_BOOTS);

                            entries.add(ModItems.PINK_GARNET_HORSE_ARMOR);
                            entries.add(ModItems.KAUPEN_SMITHING_TEMPLATE);
                        })
                        .build());

        // Creates the Pink Garnet Blocks tab in the creative menu
        public static final ItemGroup PINK_GARNET_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
                Identifier.of(TutorialMod.MOD_ID, "pink_garnet_block"),
                FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.PINK_GARNET_BLOCK)) // Gives item group the pink garnet icon
                        .displayName(Text.translatable("itemgroup.tutorialmod.pink_garnet_blocks"))  // Gives item group the name we want from the green directory location
                        .entries((displayContext, entries) -> {
                            // Add Pink Garnet Blocks here below:
                            entries.add(ModBlocks.PINK_GARNET_BLOCK);
                            entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                            entries.add(ModBlocks.PINK_GARNET_ORE);
                            entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                            entries.add(ModBlocks.PINK_GARNET_LAMP);

                            entries.add(ModBlocks.PINK_GARNET_DOOR);
                            entries.add(ModBlocks.PINK_GARNET_TRAPDOOR);
                            entries.add(ModBlocks.PINK_GARNET_FENCE);
                            entries.add(ModBlocks.PINK_GARNET_FENCE_GATE);
                            entries.add(ModBlocks.PINK_GARNET_STAIRS);
                            entries.add(ModBlocks.PINK_GARNET_SLAB);
                            entries.add(ModBlocks.PINK_GARNET_BUTTON);
                            entries.add(ModBlocks.PINK_GARNET_WALL);
                            entries.add(ModBlocks.PINK_GARNET_PRESSURE_PLATE);

                        })
                        .build());


        public static void registerItemGroups() {
            TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);

        }
    }