package items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Gum extends ItemFood {

	public Gum(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		GameRegistry.registerItem(this,"gum");
		this.setUnlocalizedName("gum"); 
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setPotionEffect(Potion.blindness.id,30,5,0.10F);
		this.setAlwaysEdible();
	}

}
