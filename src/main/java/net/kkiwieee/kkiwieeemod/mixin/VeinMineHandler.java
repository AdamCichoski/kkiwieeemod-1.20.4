package net.kkiwieee.kkiwieeemod.mixin;

import net.kkiwieee.kkiwieeemod.enchantment.ModEnchantments;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Block.class)
public class VeinMineHandler {

    @Inject(method = "onBreak", at = @At("TAIL"))
    private void register(World world , BlockPos pos, BlockState state, PlayerEntity player, CallbackInfoReturnable<Boolean> info) {
        if (EnchantmentHelper.getLevel(ModEnchantments.VEIN_MINE, player.getMainHandStack()) > 0) {
            if (isOre(state.getBlock()) && hasNeighboringBlockState(world, pos, state.getBlock())) {
                veinMine(world, pos, state.getBlock());
            }
        }
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
                pos.down(),
        };
        for (BlockPos neighborPos : neighbors) {
            BlockState neighborBlockState = world.getBlockState(neighborPos);
            if (neighborBlockState.getBlock() == targetBlock) {
                return true;
            }
        }


        return false;
    }

    private static void veinMine(World world, BlockPos pos, Block targetBlock) {
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