package items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Red_Hot_Candy extends ItemFood {

	public Red_Hot_Candy(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		GameRegistry.registerItem(this,"redhotcandy");
		this.setUnlocalizedName("redhotcandy");
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setPotionEffect(Potion.harm.id,600,50,1.0F);
		
		
		this.setAlwaysEdible();
		
	}

}
