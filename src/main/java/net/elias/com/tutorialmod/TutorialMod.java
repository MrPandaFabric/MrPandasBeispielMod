package net.elias.com;

import net.elias.com.block.ModBlocks;
import net.elias.com.component.ModDataComponentTypes;
import net.elias.com.item.ModItemGroups;
import net.elias.com.item.ModItems;
import net.elias.com.tutorialmod.sound.ModSounds;
import net.elias.com.tutorialmod.util.HammerUsageEvent;
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
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();


		FuelRegistry.INSTANCE.add(ModItems.STARLIGHT_ASHES, 600);



		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
			if(entity instanceof SheepEntity sheepEntity) {
				if(player.getMainHandStack().getItem() == Items.END_ROD) {
					player.sendMessage(Text.literal("The Player just hit a sheep with an END ROD! YOU SICK FRICK!"));
					player.getMainHandStack().decrement(1);
					sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 6));
				}

				return ActionResult.PASS;
			}

			return ActionResult.PASS;
		});
	}
};