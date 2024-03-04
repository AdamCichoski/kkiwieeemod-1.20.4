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
public class TimberHandler {

    @Inject(method = "onBreak", at = @At("TAIL"))
    private void register(World world , BlockPos pos, BlockState state, PlayerEntity player, CallbackInfoReturnable<Boolean> info) {
        if (EnchantmentHelper.getLevel(ModEnchantments.TIMBER, player.getMainHandStack()) > 0) {
            if (isLog(state.getBlock()) && hasNeighboringBlockState(world, pos, state.getBlock())) {
                timber(world, pos, state.getBlock());
            }
        }
    }

    private static boolean isLog(Block block) {
        return block == Blocks.ACACIA_LOG || block == Blocks.BIRCH_LOG || block == Blocks.CHERRY_LOG || block == Blocks.JUNGLE_LOG || block == Blocks.OAK_LOG
                || block == Blocks.DARK_OAK_LOG || block == Blocks.MANGROVE_LOG || block == Blocks.SPRUCE_LOG;
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

    private static void timber(World world, BlockPos pos, Block targetBlock) {
        BlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();

        if (block == targetBlock) {
            world.breakBlock(pos, true);

            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = pos.offset(direction);
                timber(world, neighborPos, targetBlock);
            }
        }
    }
}