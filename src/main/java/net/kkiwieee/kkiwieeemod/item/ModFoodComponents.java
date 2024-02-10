package net.kkiwieee.kkiwieeemod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TOMATO = new FoodComponent.Builder().hunger(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 200, 2), 0.25f).build();

    public static final FoodComponent LAPIS_APPLE = new FoodComponent.Builder().hunger(2).alwaysEdible().saturationModifier(0.8f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1200, 1), 0.5f).build();


}
