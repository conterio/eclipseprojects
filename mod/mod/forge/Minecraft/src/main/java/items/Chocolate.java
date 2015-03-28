package items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Chocolate extends ItemFood {

	public Chocolate(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		GameRegistry.registerItem(this,"chocolate");
		this.setUnlocalizedName("chocolate");
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setPotionEffect(Potion.moveSpeed.id,30,500,1.0F);
		this.setPotionEffect(Potion.digSpeed.id,30,500,1.0F);
		this.setAlwaysEdible();
	}




}
