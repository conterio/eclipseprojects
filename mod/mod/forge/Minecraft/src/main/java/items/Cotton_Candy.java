package items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Cotton_Candy extends ItemFood {

	public Cotton_Candy(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		GameRegistry.registerItem(this,"cottoncandy");
		this.setUnlocalizedName("cottoncandy");
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setPotionEffect(Potion.moveSpeed.id,25,5,1.0F);
		this.setAlwaysEdible();
	}

}
