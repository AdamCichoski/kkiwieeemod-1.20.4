package net.kkiwieee.kkiwieeemod.enchantment;


import net.kkiwieee.kkiwieeemod.KkiwieeeMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static Enchantment THUNDER = register("thunder", new ThunderEnchantment(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.BOW, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(KkiwieeeMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        KkiwieeeMod.LOGGER.info("Registering Enchantments for " + KkiwieeeMod.MOD_ID);


    }

}