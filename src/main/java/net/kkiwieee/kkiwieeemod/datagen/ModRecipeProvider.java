package net.kkiwieee.kkiwieeemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kkiwieee.kkiwieeemod.block.ModBlocks;
import net.kkiwieee.kkiwieeemod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> RUBY_SMELTABLES = List.of(ModItems.RAW_RUBY,
            ModBlocks.RUBY_ORE, ModBlocks.END_STONE_RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE, ModBlocks.NETHER_RUBY_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 200, "ruby");
        offerBlasting(exporter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY, 0.7f, 100, "ruby");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.MISC,
                ModBlocks.RUBY_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.LAPIS_APPLE, 1)
                .pattern("SSS")
                .pattern("SRS")
                .pattern("SSS")
                .input('S', Ingredient.ofItems(Items.LAPIS_BLOCK))
                .input('R', Ingredient.ofItems(Items.APPLE))
                .criterion(hasItem(Items.LAPIS_BLOCK), conditionsFromItem(Items.LAPIS_BLOCK))
                .criterion(hasItem(Items.APPLE), conditionsFromItem(Items.APPLE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.LAPIS_APPLE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, Items.COAL, 1)
                .pattern("S")
                .pattern("S")
                .input('S', Ingredient.ofItems(ModItems.COAL_BRIQUETTE))
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .criterion(hasItem(ModItems.COAL_BRIQUETTE), conditionsFromItem(ModItems.COAL_BRIQUETTE))
                .offerTo(exporter, new Identifier(getRecipeName(Items.COAL)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COAL_BRIQUETTE, 2)
                .pattern("S")
                .input('S', Ingredient.ofItems(Items.COAL))
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .criterion(hasItem(ModItems.COAL_BRIQUETTE), conditionsFromItem(ModItems.COAL_BRIQUETTE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.COAL_BRIQUETTE)));


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_HELMET, 1)
                .pattern("SSS")
                .pattern("S S")
                .input('S', Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_HELMET)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_CHESTPLATE, 1)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_CHESTPLATE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_LEGGINGS, 1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_LEGGINGS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_BOOTS, 1)
                .pattern("S S")
                .pattern("S S")
                .input('S', Ingredient.ofItems(ModItems.RUBY))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_BOOTS)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_SWORD, 1)
                .pattern("S")
                .pattern("S")
                .pattern("T")
                .input('S', Ingredient.ofItems(ModItems.RUBY))
                .input('T', Ingredient.ofItems(Items.STICK))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_SWORD)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_PICKAXE, 1)
                .pattern("SSS")
                .pattern(" T ")
                .pattern(" T ")
                .input('S', Ingredient.ofItems(ModItems.RUBY))
                .input('T', Ingredient.ofItems(Items.STICK))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_PICKAXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_AXE, 1)
                .pattern("SS")
                .pattern("ST")
                .pattern(" T")
                .input('S', Ingredient.ofItems(ModItems.RUBY))
                .input('T', Ingredient.ofItems(Items.STICK))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_AXE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_SHOVEL, 1)
                .pattern("S")
                .pattern("T")
                .pattern("T")
                .input('S', Ingredient.ofItems(ModItems.RUBY))
                .input('T', Ingredient.ofItems(Items.STICK))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_SHOVEL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RUBY_HOE, 1)
                .pattern("SS")
                .pattern(" T")
                .pattern(" T")
                .input('S', Ingredient.ofItems(ModItems.RUBY))
                .input('T', Ingredient.ofItems(Items.STICK))
                .criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.RUBY_HOE)));




    }
}
