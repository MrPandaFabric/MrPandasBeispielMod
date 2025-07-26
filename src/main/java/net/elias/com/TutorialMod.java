package net.elias.com;

import net.elias.com.block.ModBlocks;
import net.elias.com.component.ModDataComponentTypes;
import net.elias.com.item.ModItemGroups;
import net.elias.com.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		//	Registering all mod assets
		ModItemGroups.registerItemGroups(); // Creative Mode Item Group
		ModItems.registerModItems();        // Mod Items
		ModBlocks.registerModBlocks();      // Mod Blocks
		ModDataComponentTypes.registerDataComponentTypes();

		LOGGER.info("Hello Fabric world!");


		//Register fuel items
		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES,600);

	}
}