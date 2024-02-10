package net.kkiwieee.kkiwieeemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.kkiwieee.kkiwieeemod.KkiwieeeMod;
import net.kkiwieee.kkiwieeemod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup RUBY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(KkiwieeeMod.MOD_ID, "ruby"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.ruby"))
                    .icon(() -> new ItemStack(ModItems.RUBY)).entries((displayContext, entries) -> {

                       entries.add(ModItems.RUBY_SWORD);
                       entries.add(ModItems.RUBY_PICKAXE);
                       entries.add(ModItems.RUBY_AXE);
                       entries.add(ModItems.RUBY_SHOVEL);
                       entries.add(ModItems.RUBY_HOE);

                       entries.add(ModItems.RUBY_HELMET);
                       entries.add(ModItems.RUBY_CHESTPLATE);
                       entries.add(ModItems.RUBY_LEGGINGS);
                       entries.add(ModItems.RUBY_BOOTS);

                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.RAW_RUBY);
                        entries.add(ModItems.RUBY);

                        entries.add(ModBlocks.RAW_RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModBlocks.NETHER_RUBY_ORE);
                        entries.add(ModBlocks.END_STONE_RUBY_ORE);


                        entries.add(ModItems.CORN_SEEDS);
                        entries.add(ModItems.CORN);
                        entries.add(ModItems.TOMATO_SEEDS);
                        entries.add(ModItems.TOMATO);
                        entries.add(ModItems.LAPIS_APPLE);

                        entries.add(ModItems.COAL_BRIQUETTE);


                    }).build());

    public static void registerItemGroups() {
        KkiwieeeMod.LOGGER.info("Registering Item Groups for " +KkiwieeeMod.MOD_ID);
    }
}
