package items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class Gummy_Worm extends ItemFood {


	public Gummy_Worm(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		GameRegistry.registerItem(this,"gummyworm");
		this.setUnlocalizedName("gummyworm");
		this.setCreativeTab(CreativeTabs.tabFood);
		this.setPotionEffect(Potion.digSpeed.id,600,50,1.0F);
		
		
		this.setAlwaysEdible();
		
		
	}

}
