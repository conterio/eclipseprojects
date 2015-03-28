package items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Sour_Gummy_Worm extends ItemFood {

	public Sour_Gummy_Worm(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		GameRegistry.registerItem(this,"sourgummyworm");
		this.setUnlocalizedName("sourgummyworm"); 
		this.setCreativeTab(CreativeTabs.tabFood);
		
		this.setPotionEffect(Potion.moveSpeed.id,30,50,1.0F);
		this.setAlwaysEdible();
	}

}
