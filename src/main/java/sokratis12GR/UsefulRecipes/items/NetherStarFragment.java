package sokratis12GR.UsefulRecipes.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Socrates on 4/19/2016.
 */
public class NetherStarFragment extends Item {

    public NetherStarFragment() {
        setRegistryName("NetherStarFragment");        // The unique name (within your mod) that identifies this item
        setUnlocalizedName("NetherStarFragment");     // Used for localization (en_US.lang)
        GameRegistry.register(this);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation("usefulrecipes:NetherStarFragment", "inventory"));
    }

}
