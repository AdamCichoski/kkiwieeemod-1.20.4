package net.kkiwieee.kkiwieeemod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kkiwieee.kkiwieeemod.block.ModBlocks;
import net.kkiwieee.kkiwieeemod.enchantment.ModEnchantments;
import net.kkiwieee.kkiwieeemod.enchantment.VeinMineEnchantment;
import net.kkiwieee.kkiwieeemod.item.ModItemGroups;
import net.kkiwieee.kkiwieeemod.item.ModItems;
import net.kkiwieee.kkiwieeemod.mixin.VeinMineHandler;
import net.kkiwieee.kkiwieeemod.sound.ModSounds;
import net.kkiwieee.kkiwieeemod.util.ModCustomTrades;
import net.kkiwieee.kkiwieeemod.util.ModLootTableModifiers;
import net.kkiwieee.kkiwieeemod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KkiwieeeMod implements ModInitializer {
	public static final String MOD_ID = "kkiwieeemod";
    public static final Logger LOGGER = LoggerFactory.getLogger("kkiwieeemod");


	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.registerCustomTrades();

		ModSounds.registerSounds();

		FuelRegistry.INSTANCE.add(ModItems.COAL_BRIQUETTE, 800);

		ModWorldGeneration.generateModWorldGen();

		ModEnchantments.registerModEnchantments();

	}
}