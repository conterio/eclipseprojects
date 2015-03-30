package items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Lollipop extends ItemFood {

	public Lollipop(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		GameRegistry.registerItem(this,"lollipop");
		this.setUnlocalizedName("lollipop"); 
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setPotionEffect(Potion.blindness.id,10,3,0.10F);
		this.setAlwaysEdible();
	}

}
