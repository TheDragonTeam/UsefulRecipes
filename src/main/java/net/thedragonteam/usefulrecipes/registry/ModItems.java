package net.thedragonteam.usefulrecipes.registry;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.thedragonteam.usefulrecipes.items.NetherStarFragment;

public class ModItems {

    public static NetherStarFragment NETHER_STAR_FRAGMENT;

    public static void init() {
        NETHER_STAR_FRAGMENT = new NetherStarFragment();
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        NETHER_STAR_FRAGMENT.initModel();
    }
}
