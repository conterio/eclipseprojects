package items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBucketMilk;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Chocolate_Milk extends ItemBucketMilk  {
	
	public Chocolate_Milk(){
		GameRegistry.registerItem(this,"chocolatemilk");
		this.setUnlocalizedName("chocolatemilk");      
		this.setCreativeTab(CreativeTabs.tabMaterials);
	}

}
