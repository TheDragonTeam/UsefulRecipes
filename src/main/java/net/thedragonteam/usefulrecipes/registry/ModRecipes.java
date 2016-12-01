package net.thedragonteam.usefulrecipes.registry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import static net.minecraftforge.fml.common.registry.GameRegistry.*;
import static net.thedragonteam.usefulrecipes.USConfig.*;

/**
 * net.thedragonteam.usefulrecipes.registry
 * UsefulRecipes created by sokratis12GR on 8/1/2016 12:25 PM.
 */
public class ModRecipes {

    public static void init() {
        addShapedRecipes();
        addShapelessRecipes();
        addSmeltingRecipes();
    }

    public static void addShapedRecipes() {
        if (zombieSkull)
            addRecipe(new ItemStack(Items.SKULL, 1, 2), "RRR", "RSR", "RRR", 'R', new ItemStack(Items.ROTTEN_FLESH, 1), 'S', new ItemStack(Items.SKULL, 1));
        if (creeperSkull)
            addRecipe(new ItemStack(Items.SKULL, 1, 4), "GGG", "GSG", "GGG", 'G', new ItemStack(Items.GUNPOWDER, 1), 'S', new ItemStack(Items.SKULL, 1));
        if (skeletonSkull)
            addRecipe(new ItemStack(Items.SKULL, 1), "BBB", "BXB", "BBB", 'B', new ItemStack(Items.BONE, 1));
        if (witherSkull)
            addRecipe(new ItemStack(Items.SKULL, 1, 1), "CCC", "CSC", "CCC", 'C', new ItemStack(Blocks.COAL_BLOCK, 1), 'S', new ItemStack(Items.SKULL, 1));
        if (fasterGoldSmelting)
            addRecipe(new ItemStack(Items.GOLD_INGOT, 8), "GGG", "GCG", "GGG", 'G', new ItemStack(Blocks.GOLD_ORE, 1), 'C', new ItemStack(Items.COAL, 1));
        if (fasterIronSmelting)
            addRecipe(new ItemStack(Items.IRON_INGOT, 8), "III", "ICI", "III", 'I', new ItemStack(Blocks.IRON_ORE, 1), 'C', new ItemStack(Items.COAL, 1));
        if (cobweb) addRecipe(new ItemStack(Blocks.WEB, 1), "SXS", "XSX", "SXS", 'S', new ItemStack(Items.STRING, 1));
        if (saddle)
            addRecipe(new ItemStack(Items.SADDLE, 1), "LLL", "LXL", "IXI", 'L', new ItemStack(Items.LEATHER, 1), 'I', new ItemStack(Items.IRON_INGOT, 1));
        if (horseArmor) {
            addRecipe(new ItemStack(Items.DIAMOND_HORSE_ARMOR, 1), "XXD", "DDD", "DXD", 'D', new ItemStack(Items.DIAMOND, 1));
            addRecipe(new ItemStack(Items.GOLDEN_HORSE_ARMOR, 1), "XXG", "GGG", "GXG", 'G', new ItemStack(Items.GOLD_INGOT, 1));
            addRecipe(new ItemStack(Items.IRON_HORSE_ARMOR, 1), "XXI", "III", "IXI", 'I', new ItemStack(Items.IRON_INGOT, 1));
        }
        if (elytra)
            if (hardElytra)
                addRecipe(new ItemStack(Items.ELYTRA, 1), "FFF", "FDF", "FSF", 'F', new ItemStack(Items.FEATHER, 1), 'D', new ItemStack(Items.DIAMOND_CHESTPLATE, 1), 'S', new ItemStack(Items.NETHER_STAR, 1));
            else
                addRecipe(new ItemStack(Items.ELYTRA, 1), "FFF", "FDF", "FFF", 'F', new ItemStack(Items.FEATHER, 1), 'D', new ItemStack(Items.DIAMOND_CHESTPLATE, 1));
    }

    public static void addShapelessRecipes() {
        if (dirtToGrass) {
            addShapelessRecipe(new ItemStack(Blocks.GRASS, 1), new ItemStack(Items.WHEAT_SEEDS, 1), new ItemStack(Blocks.DIRT, 1));
        }
        if (gravelToFlint) {
            addShapelessRecipe(new ItemStack(Items.FLINT, 1), new ItemStack(Blocks.GRAVEL, 1), new ItemStack(Blocks.GRAVEL, 1));
        }
        if (saplings) {
            addShapelessRecipe(new ItemStack(Blocks.SAPLING, 1, 0), new ItemStack(Blocks.LEAVES, 1, 0), new ItemStack(Items.STICK, 1));
            addShapelessRecipe(new ItemStack(Blocks.SAPLING, 1, 1), new ItemStack(Blocks.LEAVES, 1, 1), new ItemStack(Items.STICK, 1));
            addShapelessRecipe(new ItemStack(Blocks.SAPLING, 1, 2), new ItemStack(Blocks.LEAVES, 1, 2), new ItemStack(Items.STICK, 1));
            addShapelessRecipe(new ItemStack(Blocks.SAPLING, 1, 3), new ItemStack(Blocks.LEAVES, 1, 3), new ItemStack(Items.STICK, 1));
        }
        if (woodenSlabsToPlanks) {
            addShapelessRecipe(new ItemStack(Blocks.PLANKS, 1, 0), new ItemStack(Blocks.WOODEN_SLAB, 1, 0), new ItemStack(Blocks.WOODEN_SLAB, 1, 0));
            addShapelessRecipe(new ItemStack(Blocks.PLANKS, 1, 1), new ItemStack(Blocks.WOODEN_SLAB, 1, 1), new ItemStack(Blocks.WOODEN_SLAB, 1, 1));
            addShapelessRecipe(new ItemStack(Blocks.PLANKS, 1, 2), new ItemStack(Blocks.WOODEN_SLAB, 1, 2), new ItemStack(Blocks.WOODEN_SLAB, 1, 2));
            addShapelessRecipe(new ItemStack(Blocks.PLANKS, 1, 3), new ItemStack(Blocks.WOODEN_SLAB, 1, 3), new ItemStack(Blocks.WOODEN_SLAB, 1, 3));
        }
        if (stoneSlabsToStone) {
            addShapelessRecipe(new ItemStack(Blocks.COBBLESTONE, 1), new ItemStack(Blocks.STONE_SLAB, 1, 3), new ItemStack(Blocks.STONE_SLAB, 1, 3));
            addShapelessRecipe(new ItemStack(Blocks.BRICK_BLOCK, 1), new ItemStack(Blocks.STONE_SLAB, 1, 4), new ItemStack(Blocks.STONE_SLAB, 1, 4));
        }
        if (woolToString) {
            addShapelessRecipe(new ItemStack(Items.STRING, 4), new ItemStack(Blocks.WOOL, 1));
        }
        if (diamondArmorToDiamond) {
            addShapelessRecipe(new ItemStack(Items.DIAMOND, diamondAmounts[0]), new ItemStack(Items.DIAMOND_HELMET, 1));
            addShapelessRecipe(new ItemStack(Items.DIAMOND, diamondAmounts[1]), new ItemStack(Items.DIAMOND_CHESTPLATE, 1));
            addShapelessRecipe(new ItemStack(Items.DIAMOND, diamondAmounts[2]), new ItemStack(Items.DIAMOND_LEGGINGS, 1));
            addShapelessRecipe(new ItemStack(Items.DIAMOND, diamondAmounts[3]), new ItemStack(Items.DIAMOND_BOOTS, 1));
        }
        if (ironArmorToIron) {
            addShapelessRecipe(new ItemStack(Items.IRON_INGOT, ironAmounts[0]), new ItemStack(Items.IRON_HELMET, 1));
            addShapelessRecipe(new ItemStack(Items.IRON_INGOT, ironAmounts[1]), new ItemStack(Items.IRON_CHESTPLATE, 1));
            addShapelessRecipe(new ItemStack(Items.IRON_INGOT, ironAmounts[2]), new ItemStack(Items.IRON_LEGGINGS, 1));
            addShapelessRecipe(new ItemStack(Items.IRON_INGOT, ironAmounts[3]), new ItemStack(Items.IRON_BOOTS, 1));
        }
        if (goldArmorToGold) {
            addShapelessRecipe(new ItemStack(Items.GOLD_INGOT, goldAmounts[0]), new ItemStack(Items.GOLDEN_HELMET, 1));
            addShapelessRecipe(new ItemStack(Items.GOLD_INGOT, goldAmounts[1]), new ItemStack(Items.GOLDEN_CHESTPLATE, 1));
            addShapelessRecipe(new ItemStack(Items.GOLD_INGOT, goldAmounts[2]), new ItemStack(Items.GOLDEN_LEGGINGS, 1));
            addShapelessRecipe(new ItemStack(Items.GOLD_INGOT, goldAmounts[3]), new ItemStack(Items.GOLDEN_BOOTS, 1));
        }
        if (leatherArmorToLeather) {
            addShapelessRecipe(new ItemStack(Items.LEATHER, leatherAmounts[0]), new ItemStack(Items.LEATHER_HELMET, 1));
            addShapelessRecipe(new ItemStack(Items.LEATHER, leatherAmounts[1]), new ItemStack(Items.LEATHER_CHESTPLATE, 1));
            addShapelessRecipe(new ItemStack(Items.LEATHER, leatherAmounts[2]), new ItemStack(Items.LEATHER_LEGGINGS, 1));
            addShapelessRecipe(new ItemStack(Items.LEATHER, leatherAmounts[3]), new ItemStack(Items.LEATHER_BOOTS, 1));
        }
    }

    public static void addSmeltingRecipes() {
        if (fleshSmelting) {
            if (fleshToBeef) {
                addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.BEEF), 0.5F);
            } else {
                addSmelting(Items.ROTTEN_FLESH, new ItemStack(Items.LEATHER), 0.5F);
            }
        }
        if (poisonPotatoSmelting) {
            addSmelting(Items.POTATO, new ItemStack(Items.BAKED_POTATO), 0.5F);
        }
    }
}