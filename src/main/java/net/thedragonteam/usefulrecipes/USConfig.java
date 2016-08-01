package net.thedragonteam.usefulrecipes;

import net.thedragonteam.core.config.ModConfigProperty;

/**
 * net.thedragonteam.usefulrecipes
 * UsefulRecipes created by sokratis12GR on 8/1/2016 12:27 PM.
 */
public class USConfig {

    //Recipes.Crafting
    @ModConfigProperty(category = "Recipes.Crafting", name = "leatherArmorToLeather", comment = "Enable/Disable leatherArmorToLeather Crafting")
    public static boolean leatherArmorToLeather = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "goldArmorToGold", comment = "Enable/Disable goldArmorToGold Crafting")
    public static boolean goldArmorToGold = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "ironArmorToIron", comment = "Enable/Disable ironArmorToIron Crafting")
    public static boolean ironArmorToIron = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "diamondArmorToDiamond", comment = "Enable/Disable diamondArmorToDiamond Crafting")
    public static boolean diamondArmorToDiamond = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "woodenSlabsToPlanks", comment = "Enable/Disable woodenSlabsToPlanks Crafting")
    public static boolean woodenSlabsToPlanks = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "stoneSlabsToStone", comment = "Enable/Disable stoneSlabsToStone Crafting")
    public static boolean stoneSlabsToStone = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "woolToString", comment = "Enable/Disable woolToString Crafting")
    public static boolean woolToString = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "saplings", comment = "Enable/Disable saplings Crafting")
    public static boolean saplings = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "skull", comment = "Enable/Disable skull Crafting")
    public static boolean skull = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "witherSkull", comment = "Enable/Disable witherSkull Crafting")
    public static boolean witherSkull = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "cobweb", comment = "Enable/Disable cobweb Crafting")
    public static boolean cobweb = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "saddle", comment = "Enable/Disable saddle Crafting")
    public static boolean saddle = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "horseArmor", comment = "Enable/Disable horseArmor Crafting")
    public static boolean horseArmor = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "elytra", comment = "Enable/Disable elytra Crafting")
    public static boolean elytra = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "hardElytra", comment = "If true a nether star is needed to craft an elytra. If false not.")
    public static boolean hardElytra = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "dirtToGrass", comment = "Enable/Disable dirtToGrass Crafting")
    public static boolean dirtToGrass = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "gravelToFlint", comment = "Enable/Disable gravelToFlint Crafting")
    public static boolean gravelToFlint = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "fasterIronSmelting", comment = "Enable/Disable fasterIronSmelting Crafting")
    public static boolean fasterIronSmelting = true;

    @ModConfigProperty(category = "Recipes.Crafting", name = "fasterGoldSmelting", comment = "Enable/Disable fasterGoldSmelting Crafting")
    public static boolean fasterGoldSmelting = true;

    //Recipes.Smelting
    @ModConfigProperty(category = "Recipes.Smelting", name = "poisonPotatoSmelting", comment = "Enable/Disable poisonPotatoSmelting Crafting")
    public static boolean poisonPotatoSmelting = true;

    @ModConfigProperty(category = "Recipes.Smelting", name = "fleshSmelting", comment = "Enable/Disable Smelting of Rotten Flesh")
    public static boolean fleshSmelting = true;

    @ModConfigProperty(category = "Recipes.Smelting", name = "fleshToBeef", comment = "Toggles what is produced by smelting Rotten Flesh. True = Beef, False = Leather")
    public static boolean fleshToBeef = true;
}
