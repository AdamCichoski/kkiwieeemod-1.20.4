package net.kkiwieee.kkiwieeemod.mixin;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.kkiwieee.kkiwieeemod.enchantment.ModEnchantments;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class VeinMineHandler {
    public static void register() {
        UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
            ItemStack heldItem = player.getStackInHand(hand);
            if (heldItem.isEmpty()) {
                return ActionResult.PASS;
            }

            if (EnchantmentHelper.getLevel(ModEnchantments.VEIN_MINE, heldItem) > 0) {
                BlockPos pos = hitResult.getBlockPos();
                Block block = world.getBlockState(pos).getBlock();

                if (isOre(block)) {
                    if (hasNeighboringBlockState(world, pos, block)) {
                        veinMine(world, pos, block);
                        return ActionResult.SUCCESS;
                    }
                }
            }

            return ActionResult.PASS;
        });
    }

    private static boolean isOre(Block block) {
        return block == Blocks.IRON_ORE || block == Blocks.GOLD_ORE || block == Blocks.DIAMOND_ORE || block == Blocks.COPPER_ORE;
    }

    private static boolean hasNeighboringBlockState(World world, BlockPos pos, Block targetBlock) {
        BlockPos[] neighbors = {
                pos.north(),
                pos.south(),
                pos.east(),
                pos.west(),
                pos.up(),
                pos.down()
        };

        for (BlockPos neighborPos : neighbors) {
            BlockState neighborBlockState = world.getBlockState(neighborPos);
            if (neighborBlockState.getBlock() == targetBlock) {
                return true;
            }
        }


        return false;
    }

    public static void veinMine(World world, BlockPos pos, Block targetBlock) {
        BlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();

        if (block == targetBlock) {
            world.breakBlock(pos, true);

            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = pos.offset(direction);
                veinMine(world, neighborPos, targetBlock);
            }
        }
    }
}