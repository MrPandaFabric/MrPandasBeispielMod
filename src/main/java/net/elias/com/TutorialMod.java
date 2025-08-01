package net.elias.com;

import net.elias.com.block.ModBlocks;
import net.elias.com.component.ModDataComponentTypes;
import net.elias.com.item.ModItemGroups;
import net.elias.com.item.ModItems;
import net.elias.com.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
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


		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

		AttackEntityCallback.EVENT.register((playerEntity, world, hand, entity, entityHitResult) -> {
			if (entity instanceof SheepEntity sheepEntity && !world.isClient) {
				if (playerEntity.getMainHandStack().getItem() == Items.END_ROD) {
					playerEntity.sendMessage(Text.literal("The Player just hit a Sheep with an END ROD! YOU SICK FRICK!"));
					playerEntity.getMainHandStack().decrement(1);
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 500,6));
				}
			}

            return ActionResult.PASS;
        });
	}
}