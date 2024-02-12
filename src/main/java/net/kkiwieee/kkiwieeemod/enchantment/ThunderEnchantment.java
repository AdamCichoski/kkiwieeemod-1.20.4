package net.kkiwieee.kkiwieeemod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.concurrent.ThreadLocalRandom;


public class ThunderEnchantment extends Enchantment {



    public ThunderEnchantment(Rarity rarity, EnchantmentTarget target, EquipmentSlot... slotTypes) {
        super(rarity, target, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        int lowerBound = 1;
        int upperBound = 4;
        int upperBound2 = 2;
        int range = upperBound - lowerBound + 1;
        int range2 = upperBound2 - lowerBound + 1;
        if(!user.getWorld().isClient) {
            ServerWorld world = (ServerWorld) user.getWorld();
            BlockPos position = target.getBlockPos();

            if(level == 1) {
                int chance = ThreadLocalRandom.current().nextInt(range) + lowerBound;
                if(chance == 3) {
                    EntityType.LIGHTNING_BOLT.spawn(world, position, SpawnReason.TRIGGERED);
                }

            }
            if(level == 2) {
                int chance2 = ThreadLocalRandom.current().nextInt(range2) + lowerBound;
                if(chance2 == 1) {
                    EntityType.LIGHTNING_BOLT.spawn(world, position, SpawnReason.TRIGGERED);
                }

            }

        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
